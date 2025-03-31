package Controlador;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

import Excepciones.ExcepcionGeneral;

public class GestionUsuarios {

    private static GestionUsuarios INSTANCE; // Singleton

    private HashMap<String, Usuario> usuarios = new HashMap<>();

    public GestionUsuarios() {
        usuarios = new HashMap<>();
    }

    //Añade el usuario, sea cliente o admin, a la tabla de usuarios.
    public static void anhadirUsuario(Usuario newUsuario) {
        GestionUsuarios.getInstance().usuarios.put(newUsuario.getNombreUsuario(), newUsuario);
    }

    public void anhadirCliente(String nombreUsuario, String contrasenhaUsuario){
        try {
            Usuario newCliente = new Cliente(nombreUsuario, contrasenhaUsuario);
            usuarios.put(nombreUsuario, newCliente);
        } catch (ExcepcionGeneral e) {
            System.out.println(e.getMessage());
        }
    }
    public void anhadirAdministrador(String nombreUsuario, String contrasenhaUsuario){
        try {
            Usuario newAdmin = new Administrador(nombreUsuario, contrasenhaUsuario);
            usuarios.put(nombreUsuario, newAdmin);
        } catch (ExcepcionGeneral e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void InicioDeSesionValido(String nombre, String contrasenha) throws ExcepcionGeneral {
        if (!(GestionUsuarios.getInstance().usuarios.containsKey(nombre) && GestionUsuarios.getInstance().usuarios.get(nombre).coincideContrasenha(contrasenha))) {
            throw new ExcepcionGeneral("No ha sido posible iniciar sesión.");
        }
    }


    //Registrarse
    // public boolean registroValido(String nombreUsuario, String con1, String con2){
    //     return ((!(existeNombreUsuario(nombreUsuario))) && contrasenhaValida(con1) && coincidenCon1YCon2(con1, con2));
    // }

    // public boolean existeNombreUsuario(String nombreUsuario) {
    //     return (GestionUsuarios.getInstance().obtenerNombreUsuarios().contains(nombreUsuario));
    // }

    // public boolean contrasenhaValida(String contrasenhaUsuario) {
    //     Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
    //     Matcher matcher = pattern.matcher(contrasenhaUsuario);
    //     return matcher.matches();
    // }

    // private static boolean coincidenCon1YCon2(String con1, String con2) {
    //     return (con1.equals(con2));
    // }

    //Iniciar sesión.

    public static TipoUsuario getTipoUsuario(String nombreUsuario){
        return GestionUsuarios.getInstance().usuarios.get(nombreUsuario).getTipoUsuario();
    }

    public Set<String> obtenerNombreUsuarios() {
        return usuarios.keySet();
    }

    public Optional<Usuario> obterUsuarioPorNome(String nombre) {
        for (String nombreUsuario : usuarios.keySet()) {
            if (nombreUsuario.equals(nombre)) {
                return Optional.of(usuarios.get(nombreUsuario));
            }
        }
        return Optional.empty();
    }

    // Patrón Singleton
    public static GestionUsuarios getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GestionUsuarios();
        }
        return INSTANCE;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
