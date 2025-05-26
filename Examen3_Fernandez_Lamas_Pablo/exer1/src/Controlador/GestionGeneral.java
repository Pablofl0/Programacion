package Controlador;

import Modelo.Administrador;
import Modelo.Equipo;
import Modelo.Oferta;
import Modelo.TipoUsuario;
import Modelo.TipoXogador;
import Modelo.Usuario;
import Modelo.Xogador;
import Modelo.Excepcions.ExcepcionCorreoUsuarioExistente;
import Modelo.Excepcions.ExcepcionCorreoUsuarioNonExistente;
import Modelo.Excepcions.ExcepcionEmailInvalido;
import Modelo.Excepcions.ExcepcionInicioNoValido;
import Modelo.Excepcions.ExcepcionNombreCiudadRepetidos;
import Modelo.Excepcions.ExcepcionPlantillaChea;
import Modelo.Excepcions.ExcepcionXogadorNonLibre;
import io.GestionGeneralIO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GestionGeneral implements Serializable {

    private static GestionGeneral INSTANCE; // Singleton

    private HashMap<String, Usuario> usuarios;

    private GestionGeneral() {
        this.usuarios = new HashMap<>();
    }

    public List<Usuario> getListaUsuarios() {
        return this.usuarios.values().stream().toList();
    }

    public ArrayList<Equipo> getListaEquipos() {
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        for (Usuario equipo : this.getListaUsuarios()) {
            if (equipo.getTipoUsuario().equals(TipoUsuario.EQUIPO)) {
                listaEquipos.add((Equipo) equipo);
            }
        }
        return listaEquipos;
    }

    public ArrayList<Xogador> getListaXogadores() {
        ArrayList<Xogador> listaXogadores = new ArrayList<>();
        for (Usuario xogador : this.getListaUsuarios()) {
            if (xogador.getTipoUsuario().equals(TipoUsuario.XOGADOR)) {
                listaXogadores.add((Xogador) xogador);
            }
        }
        return listaXogadores;
    }

    public void anhadirAdministrador(String correo) throws ExcepcionEmailInvalido {
        Administrador admin = new Administrador(correo);
        this.usuarios.put(correo, admin);
        this.gardar();
    }

    // Métodos Administrador.
    // Métodos de usuarios.
    public void anhadirEquipo(String nomeEquipo, String cidade)
            throws ExcepcionNombreCiudadRepetidos, Modelo.Excepcions.ExcepcionEmailInvalido {
        if (existeNombreEquipo(nomeEquipo, cidade)) {
            throw new ExcepcionNombreCiudadRepetidos();
        }
        Equipo newEquipo = new Equipo(nomeEquipo, cidade);
        this.usuarios.put(newEquipo.getcorreoUsuario(), newEquipo);
        this.gardar();
    }

    public boolean existeNombreEquipo(String nomeEquipo, String cidade) {
        if (this.getListaEquipos().stream()
                .filter(c -> c.getNomeEquipo().equals(nomeEquipo) && c.getCidade().equals(cidade)).count() > 0) {
            return true;
        }
        return false;
    }

    public Optional<Equipo> getEquipoPorNomeCidade(String nomeEquipo, String cidade) {
        return this.getListaEquipos().stream()
                .filter(c -> c.getNomeEquipo().equals(nomeEquipo) && c.getCidade().equals(cidade)).findFirst();
    }

    public void anhadirXogador(String correoUsuario, TipoXogador tipoXogador, String nomeDeportivo)
            throws ExcepcionCorreoUsuarioExistente, Modelo.Excepcions.ExcepcionEmailInvalido {
        if (existeCorreoUsuario(correoUsuario)) {
            throw new ExcepcionCorreoUsuarioExistente();
        }
        Xogador newXogador = new Xogador(correoUsuario, tipoXogador, nomeDeportivo);
        this.usuarios.put(correoUsuario, newXogador);
        this.gardar();
    }

    public boolean existeCorreoUsuario(String correoUsuario) {
        return this.usuarios.keySet().contains(correoUsuario);
    }

    public List<Xogador> getXogadoresLibres() {
        return this.getListaXogadores().stream().filter(c -> c.getEquipoAsignado() == null).sorted().toList();
    }

    public void facerOfertaAXogadorLibre(Equipo equipo, String correo)
            throws ExcepcionPlantillaChea, ExcepcionXogadorNonLibre, ExcepcionCorreoUsuarioNonExistente {
        if (!existeCorreoUsuario(correo)) {
            throw new ExcepcionCorreoUsuarioNonExistente();
        } else if (equipo.plantillaChea()) {
            throw new ExcepcionPlantillaChea();
        } else if (!((Xogador) this.usuarios.get(correo)).isXogadorLibre()) {
            throw new ExcepcionXogadorNonLibre();
        }
        Oferta newOferta = new Oferta(equipo, (Xogador) this.usuarios.get(correo));
        ((Xogador) this.usuarios.get(correo)).anhadirOferta(equipo);
        this.gardar();
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    // Añadir admin:abc123.
    private void anhadirDatosDePrueba() {
        try {
            this.anhadirAdministrador("admin@fgb.gal");
        } catch (ExcepcionEmailInvalido e) {
            System.out.println(e.getMessage());
        }
    }

    public void InicioDeSesionValido(String nombre, String contrasenha) throws ExcepcionInicioNoValido {
        if (!(this.usuarios.keySet().contains(nombre)
                && this.usuarios.get(nombre).coincideContrasenha(contrasenha))) {
            throw new ExcepcionInicioNoValido();
        }
    }

    public TipoUsuario getTipoUsuario(String nombreUsuario) {
        return this.usuarios.get(nombreUsuario).getTipoUsuario();
    }

    public boolean existeNombreUsuario(String nombreUsuario) {
        return (this.usuarios.keySet().contains(nombreUsuario));
    }

    // Patrón Singleton
    // public static GestionGeneral getInstance() {
    // if (INSTANCE == null) {
    // INSTANCE = new GestionGeneral();
    // }
    // return INSTANCE;
    // }

    // Metodo publico e estatico para poder acceder aos métodos da clase
    public static GestionGeneral getInstance() {
        // Se inda non se accedeu, inicializase
        if (INSTANCE == null) {

            // Intentamos cargar os restaurantes
            Optional<GestionGeneral> lectura = GestionGeneralIO.cargar();

            // Se non devolve nada, creamos unha nova cadea
            if (lectura.isEmpty()) {
                INSTANCE = new GestionGeneral();
                GestionGeneral.getInstance().anhadirDatosDePrueba();
                INSTANCE.gardar();

            }
            // Xa temos a cadea gardada
            else {
                INSTANCE = lectura.get();
            }
        }
        return INSTANCE;
    }

    /**
     * Garda os datos da cadea de restaurantes
     */
    public void gardar() {
        GestionGeneralIO.gardar(INSTANCE);
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
