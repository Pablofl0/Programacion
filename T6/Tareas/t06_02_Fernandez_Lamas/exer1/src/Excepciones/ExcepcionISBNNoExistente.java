package Excepciones;

public class ExcepcionISBNNoExistente extends Exception{
    public ExcepcionISBNNoExistente(){
        super("No se ha encontrado un libro con ese ISBN.");
    } 
}
