package Excepciones;
public class ExcepcionNoLibrosPorAutor extends Exception{
    public ExcepcionNoLibrosPorAutor(){
        super("No se han encontrado libros con ese autor.");
    }
}