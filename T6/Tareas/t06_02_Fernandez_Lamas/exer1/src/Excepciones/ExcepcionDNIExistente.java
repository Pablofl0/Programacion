package Excepciones;

public class ExcepcionDNIExistente extends Exception{
    public ExcepcionDNIExistente(){
        super("El DNI ya está en uso.");
    } 
}
