package Modelo.Excepcions;

public class ExcepcionSinPartidos extends Exception {
    public ExcepcionSinPartidos() {
        super("Este jugador no ha disputado partidos.");
    }
}
