package Modelo.Excepcions;

public class ExcepcionCorreoUsuarioNonExistente extends Exception {
    public ExcepcionCorreoUsuarioNonExistente() {
        super("No existe jugador con ese correo.");
    }
}
