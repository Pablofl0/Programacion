package Excepciones;

public class ExcepcionComprarProductoSinStock extends Exception{
    public ExcepcionComprarProductoSinStock(){
        super("No quedan unidades de este producto.");
    }
}
