package Modelo.Excepcions;

public class ExcepcionXogadorNonLibre extends Exception {
    public ExcepcionXogadorNonLibre() {
        super("Este jugador no está libre.");
    }
}
