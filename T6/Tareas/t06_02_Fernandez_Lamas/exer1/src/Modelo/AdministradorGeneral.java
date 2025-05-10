package Modelo;

import Excepciones.ExcepcionEmailInvalido;
import Excepciones.ExcepcionGeneral;

public class AdministradorGeneral extends Usuario {

    public AdministradorGeneral(String nombreUsuario, String contrasenhaUsuario, String nombre,
            String apellido1, String apellido2, String dni, String correo) throws ExcepcionGeneral,ExcepcionEmailInvalido {
        super(nombreUsuario, contrasenhaUsuario, TipoUsuario.ADMINGENERAL, nombre, apellido1, apellido2, dni, correo);
    }

}
