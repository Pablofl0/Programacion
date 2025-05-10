package Excepciones;

public class ExcepcionISBNRepetido extends Exception{
    public ExcepcionISBNRepetido(){
        super("Ya existe un libro con ese ISBN.");
    } 
}
