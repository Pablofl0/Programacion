package Modelos;

import java.util.regex.Pattern;

import Excepciones.ExcepcionGeneral;

public abstract class Usuario {

    private String nombreUsuario;
    private String contrasenhaUsuario;
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasenhaUsuario, TipoUsuario tipoUsuario) throws ExcepcionGeneral {
        this.setNombreUsuario(nombreUsuario);
        this.setContrasenhaUsuario(contrasenhaUsuario);
        this.setTipoUsuario(tipoUsuario);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    private void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    // public void setNombreUsuario(String nombreUsuario) throws ExcepcionGeneral {
    //     if (existeNombreUsuario(nombreUsuario)) {
    //         throw new ExcepcionGeneral("El nombre de Usuario ya está en uso.");
    //     }
    //     this.nombreUsuario = nombreUsuario;
    // }

    public String getContrasenhaUsuario() {
        return contrasenhaUsuario;
    }

    private void setContrasenhaUsuario(String contrasenhaUsuario) throws ExcepcionGeneral {
        if (!contrasenhaValida(contrasenhaUsuario)) {
            throw new ExcepcionGeneral("La contraseña no es válida.");
        }
        this.contrasenhaUsuario = contrasenhaUsuario;
    }

    private boolean contrasenhaValida(String contrasenhaUsuario) {
        // Expresión regular para validar la contraseña
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z0-9]{8,}$";

        // Verificar si la contraseña coincide con el patrón
        return Pattern.matches(regex, contrasenhaUsuario);
        // Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*0-9)[a-zA-Z0-9]{8,}");
        // Matcher matcher = pattern.matcher(contrasenhaUsuario);
        // return matcher.matches();
    }

    

    public boolean coincideContrasenha(String contrasenha) {
        return contrasenha.equals(this.contrasenhaUsuario);
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    private void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
;
}
