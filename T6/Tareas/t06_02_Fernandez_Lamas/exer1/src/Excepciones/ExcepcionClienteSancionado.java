package Excepciones;
public class ExcepcionClienteSancionado extends Exception{
    public ExcepcionClienteSancionado(){
        super("El cliente está sancionado.");
    }
}