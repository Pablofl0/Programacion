package Excepciones;

public class ExcepcionStockNegativo extends Exception{
    public ExcepcionStockNegativo(){
        super("El stock no puede ser negativo.");
    }
}
