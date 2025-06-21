package Modelo;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Modelo.Excepcions.ExcepcionEmailInvalido;

public abstract class Usuario implements Serializable {

    private String correoUsuario;
    private String contrasenhaUsuario;
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(String correoUsuario, TipoUsuario tipoUsuario)
            throws ExcepcionEmailInvalido {
        this.setcorreoUsuario(correoUsuario);
        this.setContrasenhaUsuario(tipoUsuario);
        this.setTipoUsuario(tipoUsuario);
    }

    public String getcorreoUsuario() {
        return correoUsuario;
    }

    protected void setcorreoUsuario(String correoUsuario) throws ExcepcionEmailInvalido {
        if (!comprobarEmail(correoUsuario)) {
            throw new ExcepcionEmailInvalido("El correo no es válido.");
        }
        this.correoUsuario = correoUsuario;
    }

    public boolean comprobarEmail(String correo) {
        Pattern pattern = Pattern.compile("^([A-Za-z0-9._%+-]+)@([A-Za-z0-9.-]+\\.[A-Za-z]{2,6})$");
        Matcher matcher = pattern.matcher(correo);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public void setContrasenhaUsuario(TipoUsuario tipoUsuario) {
        switch (tipoUsuario) {
            case ADMINISTRADOR:
                this.contrasenhaUsuario = "fgb";
                break;
            case EQUIPO:
                this.contrasenhaUsuario = "fgb";
                break;
            case XOGADOR:
                this.contrasenhaUsuario = "abc123.";
                break;
            default:
                break;
        }
    }

    public String getContrasenhaUsuario() {
        return contrasenhaUsuario;
    }

    public boolean coincideContrasenha(String contrasenha) {
        return contrasenha.equals(this.contrasenhaUsuario);
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    };
}
