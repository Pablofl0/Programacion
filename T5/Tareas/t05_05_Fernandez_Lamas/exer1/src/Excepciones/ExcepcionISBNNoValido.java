package Excepciones;

public class ExcepcionISBNNoValido extends Exception{
    public ExcepcionISBNNoValido(){
        super("El ISBN es incorrecto.");
    }
}
