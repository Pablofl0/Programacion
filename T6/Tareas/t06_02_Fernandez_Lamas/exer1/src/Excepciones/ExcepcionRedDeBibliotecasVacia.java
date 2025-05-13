package Excepciones;
public class ExcepcionRedDeBibliotecasVacia extends Exception{
    public ExcepcionRedDeBibliotecasVacia(){
        super("La red de bibliotecas está vacía.");
    }
}