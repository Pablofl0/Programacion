package Excepciones;
public class ExcepcionRegistroUsuario extends Exception{
    public ExcepcionRegistroUsuario(){
        super("El nombre de usuario ya está siendo utilizado.");
    }
}