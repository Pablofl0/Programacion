import Excepciones.ExcepcionGeneral;

package Modelos;
public class Administrador extends Usuario{


    public Administrador(String nombreUsuario, String contrasenhaUsuario, String contrasenhaUsuarioConfirmación) throws ExcepcionGeneral{
        super(nombreUsuario, contrasenhaUsuario, contrasenhaUsuarioConfirmación, TipoUsuario.Administrador);
    }

}
