package Excepciones;
public class ExcepcionClienteSinPrestamos extends Exception{
    public ExcepcionClienteSinPrestamos(){
        super("El cliente no tiene préstamos actualmente.");
    }
}