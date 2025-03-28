import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

public class GestionUsuarios {
    private static GestionUsuarios INSTANCE; // Singleton

    private HashMap<String,Usuario> usuarios;

    public GestionUsuarios() {
        usuarios = new HashMap<>();
    }

    //Añade el usuario, sea cliente o admin, a la tabla de usuarios.
    public void anhadirUsuario(Usuario newUsuario){
        usuarios.put(newUsuario.getNombreUsuario(), newUsuario);
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

    public boolean existeUsuarioRegistrado(String nombre, String contrasenha){
        return (usuarios.containsKey(nombre) && usuarios.get(nombre).coincideContrasenha(contrasenha));
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
    public static GestionUsuarios getInstance(){
        if(INSTANCE == null)
            INSTANCE = new GestionUsuarios();
        return INSTANCE;
    }
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

