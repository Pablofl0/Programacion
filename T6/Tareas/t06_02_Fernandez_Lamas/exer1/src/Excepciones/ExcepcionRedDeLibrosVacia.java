package Excepciones;
public class ExcepcionRedDeLibrosVacia extends Exception{
    public ExcepcionRedDeLibrosVacia(){
        super("La red de bibliotecas está vacía.");
    }
}