package Excepciones;
public class ExcepcionClienteConPrestamos extends Exception{
    public ExcepcionClienteConPrestamos(){
        super("El cliente ya tiene un préstamo actualmente.");
    }
}