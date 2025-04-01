package Excepciones;

public class ExcepcionEliminarStockDeMas extends Exception{
    public ExcepcionEliminarStockDeMas(){
        super("No es posible eliminar tanto stock.");
    }
}
