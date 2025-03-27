import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

public class GestionUsuarios {
    private static GestionUsuarios INSTANCE; // Singleton

    private HashMap<String,Usuario> usuarios;

    public GestionUsuarios() {
        usuarios = new HashMap<>();
    }

    public void engadirUsuario(String nombreUsuario, String contrasenhaUsuario){
        try {
            Usuario newUsuario = new Cliente(nombreUsuario, contrasenhaUsuario);
            usuarios.put(nombreUsuario, newUsuario);
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

