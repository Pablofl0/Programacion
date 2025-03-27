public class Libro extends Complemento{
    private String titulo;
    private String autor;
    private String ISBN;


    @Override
    public String toString() {
        return "Libro" + super.toString();
    }
}
