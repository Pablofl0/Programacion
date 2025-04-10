package telegrambot;

import java.sql.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import telegrambot.DAO.DAOFestival;

public class DAOFestivalDB //implements DAOFestival 
{

    // Aquí é onde está o ficheiro da base de datos
    private static final String URL_DB = "jdbc:sqlite:festivais.db";

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /**
     * Construtor da clase
     */
    public DAOFestivalDB() {
        // Se non existe o ficheiro da base de datos creao
        if (!existeBaseDeDatos()) {
            // Crear a base de datos e insertar os festivais se non existen
            System.out.println("Creando a base de datos");
            crearBaseDeDatos();
            System.out.println("Engadindo datos");
            insertarFestivaisSeNonExisten();
            System.out.println("Carga finalizada");
        } else {
            System.out.println("Base de datos atopada");
        }
    }

    /**
     * Comproba que existe a base de datos
     * 
     * @return
     */
    private boolean existeBaseDeDatos() {
        File dbFile = new File("festivais.db");
        return dbFile.exists();
    }

    /**
     * Crea as táboas senón existen
     */
    private void crearBaseDeDatos() {
        String crearProvincias = "CREATE TABLE IF NOT EXISTS Provincias ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL);";

        String crearFestivais = "CREATE TABLE IF NOT EXISTS Festivais ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL, "
                + "poboacion TEXT NOT NULL, "
                + "provincia_id INTEGER NOT NULL, "
                + "data_comenzo DATE NOT NULL, "
                + "data_fin DATE NOT NULL, "
                + "FOREIGN KEY (provincia_id) REFERENCES Provincias(id));";

        try {
            Connection conn = DriverManager.getConnection(URL_DB);
            Statement stmt = conn.createStatement();
            stmt.execute(crearProvincias);
            stmt.execute(crearFestivais);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Engade os datos se non existen
     */
    private void insertarFestivaisSeNonExisten() {
        // Inserir provincias
        String[] provincias = { "A Coruña", "Lugo", "Ourense", "Pontevedra" };
        try {
            Connection conn = DriverManager.getConnection(URL_DB);
            String inserirProvincia = "INSERT OR IGNORE INTO Provincias (nome) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(inserirProvincia);

            for (String provincia : provincias) {
                ps.setString(1, provincia);
                ps.executeUpdate();
            }
            
            ArrayList<Festival> listaFestivales = AnhadirDatos.crearDatos();
            String insertarFestival = "INSERT OR IGNORE INTO Festivais (nome,poboacion,provincia_id,data_comezo,data_fin) VALUES (?,?,?,?,?);";
            PreparedStatement psFestival = conn.prepareStatement(insertarFestival);

            for (Festival festival : listaFestivales) {
                psFestival.setString(1, festival.getNombre());
                psFestival.setString(2, festival.getPoblacion());
                String getProvincia = "Select id from Provincias where nome='" + festival.getProvincia().getProvincia() + "'";
                psFestival.setString(3, getProvincia);
                psFestival.setString(4, festival.getHoraInicio().format(formato));
                psFestival.setString(5, festival.getHoraFinal().format(formato));
            }
            // TODO: Inserir Festivais
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    // TODO: Implementar os métodos que faltan

    // public List<Festival> getFestivales() {
    //     ArrayList<Festival> listaDevolver = new ArrayList<>();
    //     for (Festival festival : listaFestivales) {
    //         listaDevolver.add(festival);
    //     }
    //     return listaDevolver;
    // }

    // public Festival getProximoFestival() {
    //     Festival festivalFinal = null;
    //     int diff = -1;
    //     for (Festival festival : listaFestivales) {
    //         int diffNow = (int) ChronoUnit.DAYS.between(LocalDate.now(), festival.getHoraInicio());
    //         if (diff == -1 || diff > diffNow) {
    //             diff = diffNow;
    //             festivalFinal = festival;
    //         }
    //     }
    //     return festivalFinal;
    // }

    // public List<Festival> getFestivaisProvincia(NombreProvincia nombreProvincia) {
    //     ArrayList<Festival> festivalesPorProvincia = new ArrayList<>();
    //     for (Festival festival : listaFestivales) {
    //         if (nombreProvincia == festival.getProvincia()) {
    //             festivalesPorProvincia.add(festival);
    //         }
    //     }
    //     return festivalesPorProvincia;
    // }
}