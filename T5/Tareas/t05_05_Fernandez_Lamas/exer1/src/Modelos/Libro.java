package Modelos;
import Excepciones.ExcepcionISBNNoValido;
import Excepciones.ExcepcionPrecioNegativo;
import Excepciones.ExcepcionStockNegativo;

public class Libro extends Complemento{
    private String titulo;
    private String autor;
    private String ISBN;


    public Libro(double precio, int stock, String descripcion, String titulo, String autor, String ISBN) throws ExcepcionStockNegativo,ExcepcionPrecioNegativo,ExcepcionISBNNoValido {
        super(precio,stock,descripcion);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setISBN(ISBN);
        this.setTipoProducto(TipoProducto.libro);
    }

    @Override
    public String toString() {
        return "Libro" + super. toString();
    }

    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    private void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    private void setISBN(String ISBN) throws ExcepcionISBNNoValido{
        if (!ISBNValido(ISBN)) {
            throw new ExcepcionISBNNoValido();
        }
        this.ISBN = ISBN;
    }

    private static boolean ISBNValido(String isbn){
        //Comprobar si son 10 dígitos.
        if (isbn.length() != 10) {
            return false;
        }

        // Collemos os números é a letra
        String numeros = isbn.substring(0, 9);
        int ultimoDigito = Integer.valueOf(isbn.substring(9));


        //Comprobar los primeros nueve números e ir sumando la variable sumatorio.
        int sumatorio = 0;
        for (int i = 0; i < numeros.length(); i++) {
            if (!((int) numeros.charAt(i) >= (int) '0' && (int) numeros.charAt(i) <= (int) '9')) {
                return false;
            }
            sumatorio += ((i+1) * Integer.valueOf(numeros.substring(i, i+1)));
        }
        
        
        //Comprobar el último dígito.
        int resto = sumatorio % 11;
        int ultimoDigitoCalculado;
        if (resto == 10) {
            ultimoDigitoCalculado = Integer.valueOf('X');
        }
        else{
            ultimoDigitoCalculado = resto;
        }

        if (ultimoDigito != ultimoDigitoCalculado) {
            return false;
        }
        return true;

    }

    
}
