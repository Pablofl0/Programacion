package Modelo.Excepcions;

public class ExcepcionCorreoUsuarioExistente extends Exception {
    public ExcepcionCorreoUsuarioExistente() {
        super("El correo ya está en uso.");
    }
}
