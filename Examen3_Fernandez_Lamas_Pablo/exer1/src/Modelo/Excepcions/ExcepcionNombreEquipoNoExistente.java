package Modelo.Excepcions;

public class ExcepcionNombreEquipoNoExistente extends Exception {
    public ExcepcionNombreEquipoNoExistente() {
        super("No existe un equipo con ese nombre.");
    }
}
