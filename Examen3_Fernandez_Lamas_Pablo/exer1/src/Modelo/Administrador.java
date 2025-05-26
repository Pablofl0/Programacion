package Modelo;

import java.io.Serializable;

import Modelo.Excepcions.ExcepcionEmailInvalido;

public class Administrador extends Usuario implements Serializable {
    
    public Administrador(String correoUsuario) throws ExcepcionEmailInvalido {
        super(correoUsuario, TipoUsuario.ADMINISTRADOR);
    }
}
