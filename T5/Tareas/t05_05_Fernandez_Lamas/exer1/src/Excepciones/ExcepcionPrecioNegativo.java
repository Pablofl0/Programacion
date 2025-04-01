package Excepciones;

public class ExcepcionPrecioNegativo extends Exception{
    public ExcepcionPrecioNegativo(){
        super("El precio no puede ser negativo.");
    }
}
