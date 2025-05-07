package Modelo;
import Excepciones.ExcepcionGeneral;


public class Administrador extends Usuario{


    public Administrador(String nombreUsuario, String contrasenhaUsuario) throws ExcepcionGeneral{
        super(nombreUsuario, contrasenhaUsuario, TipoUsuario.Administrador);
    }

}
