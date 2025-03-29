
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Usuario {

    private String nombreUsuario;
    private String contrasenhaUsuario;
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasenhaUsuario, String contrasenhaUsuarioConfirmación, TipoUsuario tipoUsuario) throws ExcepcionGeneral {
        this.setNombreUsuario(nombreUsuario);
        this.setContrasenhaUsuario(contrasenhaUsuario, contrasenhaUsuarioConfirmación);
        this.setTipoUsuario(tipoUsuario);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) throws ExcepcionGeneral {
        if (existeNombreUsuario(nombreUsuario)) {
            throw new ExcepcionGeneral("El nombre de Usuario ya está en uso.");
        }
        this.nombreUsuario = nombreUsuario;
    }

    public  boolean existeNombreUsuario(String nombreUsuario) {
        return (GestionUsuarios.getInstance().obtenerNombreUsuarios().contains(nombreUsuario));
    }

    public String getContrasenhaUsuario() {
        return contrasenhaUsuario;
    }

    public void setContrasenhaUsuario(String contrasenhaUsuario, String contrasenhaUsuarioConfirmación) throws ExcepcionGeneral {
        if (!contrasenhaValida(contrasenhaUsuario) || !coincidenCon1YCon2(contrasenhaUsuario, contrasenhaUsuarioConfirmación)) {
            throw new ExcepcionGeneral("La contraseña no es válida.");
        }
        this.contrasenhaUsuario = contrasenhaUsuario;
    }

    private boolean contrasenhaValida(String contrasenhaUsuario) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher matcher = pattern.matcher(contrasenhaUsuario);
        return matcher.matches();
    }

    private static boolean coincidenCon1YCon2(String con1, String con2) {
        return (con1.equals(con2));
    }

    public boolean coincideContrasenha(String contrasenha) {
        return contrasenha.equals(this.contrasenhaUsuario);
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
;
}
