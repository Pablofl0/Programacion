package Excepciones;

public class ExcepcionDNIInexistente extends Exception{
    public ExcepcionDNIInexistente(){
        super("El DNI no se encuentra en la base de datos.");
    } 
}
