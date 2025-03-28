public class Libro extends Complemento{
    private String titulo;
    private String autor;
    private String ISBN;


    public Libro(int idProducto, double precio, int stock, String descripcion, String titulo, String autor, String ISBN) throws ExcepcionGeneral {
        this.setIdProducto(idProducto);
        this.setPrecioSinIVE(precio);
        this.setPrecioConIVE();
        this.setStock(stock);
        this.setDescripcion(descripcion);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setISBN(ISBN);
    }

    @Override
    public String toString() {
        return "Libro" + super.toString();
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

    private void setISBN(String ISBN) throws ExcepcionGeneral{
        if (!ISBNValido(ISBN)) {
            throw new ExcepcionGeneral("ISBN no válido.");
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
