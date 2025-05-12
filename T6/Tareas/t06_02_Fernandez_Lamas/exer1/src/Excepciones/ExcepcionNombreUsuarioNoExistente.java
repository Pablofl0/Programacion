package Excepciones;
public class ExcepcionNombreUsuarioNoExistente extends Exception{
    public ExcepcionNombreUsuarioNoExistente(){
        super("El nombre de usuario no existe en la base de datos.");
    }
}