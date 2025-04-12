package telegrambot;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOFestivalDB implements DAOFestival {

    // Aquí é onde está o ficheiro da base de datos
    private static final String URL_DB = "jdbc:sqlite:festivais.db";

    // DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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
        String[] provincias = {"A Coruña", "Lugo", "Ourense", "Pontevedra"};
        try {
            Connection conn = DriverManager.getConnection(URL_DB);
            String inserirProvincia = "INSERT OR IGNORE INTO Provincias (nome) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(inserirProvincia);

            for (String provincia : provincias) {
                ps.setString(1, provincia);
                ps.executeUpdate();
            }

            ArrayList<Festival> listaFestivales = AnhadirDatos.crearDatos();
            String insertarFestival = "INSERT OR IGNORE INTO Festivais (nome,poboacion,provincia_id,data_comenzo,data_fin) VALUES (?,?,?,?,?);";
            PreparedStatement psFestival = conn.prepareStatement(insertarFestival);

            for (Festival festival : listaFestivales) {
                psFestival.setString(1, festival.getNombre());
                psFestival.setString(2, festival.getPoblacion());
                String getProvincia = "Select id from Provincias where nome='" + festival.getProvincia().getProvincia() + "'";
                PreparedStatement psProvincia = conn.prepareStatement(getProvincia);
                ResultSet rsPovincia = psProvincia.executeQuery();
                int idProvincia = rsPovincia.getInt("id");
                psFestival.setInt(3, idProvincia);
                java.sql.Date sqlHoraInicio = new java.sql.Date(
                        Date.from(festival.getHoraInicio().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()
                );
                psFestival.setDate(4, sqlHoraInicio);
                java.sql.Date sqlHoraFinal = new java.sql.Date(
                        Date.from(festival.getHoraFinal().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()
                );
                psFestival.setDate(5, sqlHoraFinal);
                psFestival.executeUpdate();
                // psFestival.setDate(4, new java.sql.Date(Date.from(festival.getHoraInicio().atStartOfDay(ZoneId.systemDefault()).toInstant())));
                // psFestival.setString(4, new Java.sql.Date(Date.from(festival.getHoraInicio().format(formato).atStartOfDay(defaultZoneId).toInstant()).getTime()));
            }
            // TODO: Inserir Festivais
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    // TODO: Implementar os métodos que faltan
    @Override
    public List<Festival> getFestivales() {
        List<Festival> listaDevolver = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL_DB);
            String select = "select * from Festivais";
            PreparedStatement stmt = conn.prepareStatement(select);
            ResultSet rsFestivales = stmt.executeQuery();
            listaDevolver = transformarDeSQliteAMemoria(rsFestivales);
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return listaDevolver;
    }

    @Override
    public Festival getProximoFestival() {
        List<Festival> listaDevolver = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL_DB);
            String select = "SELECT * "
                    + "FROM Festivais "
                    + "WHERE data_comenzo > strftime('%s', 'now') * 1000 "
                    + "ORDER BY data_comenzo ASC "
                    + "LIMIT 1;";
            PreparedStatement stmt = conn.prepareStatement(select);
            ResultSet rsFestivales = stmt.executeQuery();
            listaDevolver = transformarDeSQliteAMemoria(rsFestivales);
        } catch (SQLException e) {
            // TODO: handle exception
        }
        if (listaDevolver.isEmpty()) {
            System.out.println("No se encontró ningún festival próximo.");
            return null;
        }
        return listaDevolver.get(0);
    }

    @Override
    public List<Festival> getFestivaisProvincia(NombreProvincia nombreProvincia) {
        List<Festival> listaDevolver = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL_DB);
            String select = "select * from Festivais where provincia_id=(select id from Provincias where nome='" + nombreProvincia.getProvincia() + "')";
            PreparedStatement stmt = conn.prepareStatement(select);
            ResultSet rsFestivales = stmt.executeQuery();
            listaDevolver = transformarDeSQliteAMemoria(rsFestivales);
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return listaDevolver;
    }

    private List<Festival> transformarDeSQliteAMemoria(ResultSet rs) throws SQLException {
        List<Festival> listaFestivales = new ArrayList<>();
        while (rs.next()) {
            NombreProvincia newNombreProvincia = null;
            int provincia_id = rs.getInt("provincia_id");
            String provinciaNombre = "Select nome from Provincias where id=" + provincia_id;
            Connection conn = DriverManager.getConnection(URL_DB);
            PreparedStatement stmt = conn.prepareStatement(provinciaNombre);
            ResultSet rsprovincia = stmt.executeQuery();
            switch (rsprovincia.getString("nome")) {
                case "Lugo":
                    newNombreProvincia = NombreProvincia.LUGO;
                    break;
                case "A Coruña":
                    newNombreProvincia = NombreProvincia.CORUÑA;
                    break;
                case "Ourense":
                    newNombreProvincia = NombreProvincia.OURENSE;
                    break;
                case "Pontevedra":
                    newNombreProvincia = NombreProvincia.PONTEVEDRA;
                    break;
                default:
                    throw new AssertionError();
            }
            LocalDate localDateInicio = Instant.ofEpochMilli(rs.getLong("data_comenzo"))
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate localDateFinal = Instant.ofEpochMilli(rs.getLong("data_fin"))
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            // Convertir LocalDate a String con formato dd/MM/yyyy
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaComienzoString = localDateInicio.format(formato);
            String fechaFinalString = localDateFinal.format(formato);
            Festival newFestival = new Festival(rs.getString("nome"), rs.getString("poboacion"), newNombreProvincia, fechaComienzoString, fechaFinalString);
            listaFestivales.add(newFestival);
        }
        return listaFestivales;
    }
}
