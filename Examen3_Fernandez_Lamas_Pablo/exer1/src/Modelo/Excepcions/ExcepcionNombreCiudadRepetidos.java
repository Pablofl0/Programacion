package Modelo.Excepcions;

public class ExcepcionNombreCiudadRepetidos extends Exception {
    public ExcepcionNombreCiudadRepetidos() {
        super("Ya existe un equipo con ese nombre en esa ciudad.");
    }
}
