package Excepciones;
public class ExcepcionNoLibrosPorTitulo extends Exception{
    public ExcepcionNoLibrosPorTitulo(){
        super("No se han encontrado libros con ese título.");
    }
}