package Excepciones;

public class ExcepcionIdNoValido extends Exception{
    public ExcepcionIdNoValido(){
        super("El identificador de producto no es válido.");
    }
}
