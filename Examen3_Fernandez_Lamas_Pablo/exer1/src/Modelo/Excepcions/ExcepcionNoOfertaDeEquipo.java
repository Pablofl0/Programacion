package Modelo.Excepcions;

public class ExcepcionNoOfertaDeEquipo extends Exception {
    public ExcepcionNoOfertaDeEquipo() {
        super("El jugador no tiene ofertas de ese equipo.");
    }
}
