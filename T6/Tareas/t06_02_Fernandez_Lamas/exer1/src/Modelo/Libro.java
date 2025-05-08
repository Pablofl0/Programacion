package Modelo;

import java.util.ArrayList;

import Excepciones.ExcepcionISBNNoValido;

public class Libro {
    private String titulo;
    private String[] autor;
    private TipoLengua lengua;
    private String editorial;
    private String ISBN;
    private ArrayList<Ejemplar> ejemplares;

    public Libro() {
    }

    public Libro(String titulo, String autor, TipoLengua lengua, String editorial, String ISBN)
            throws ExcepcionISBNNoValido {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setLengua(lengua);
        this.setEditorial(editorial);
        this.setISBN(ISBN);
        this.setEjemplares(new ArrayList<>());
    }

    public void anhadirEjemplar(Ejemplar ejemplar) {
        this.ejemplares.add(ejemplar);
    }

    @Override
    public String toString() {
        return this.getISBN() + ", " + this.getTitulo() + " de " + this.getAutor() + " en " + this.getLengua() + "(" + this.getEditorial() + ")";
    }

    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        String autoresDevolucion = null;
        for (int i = 0; i < autor.length; i++) {
            autoresDevolucion += autor[i];
            if (i < autor.length - 1) {
                autoresDevolucion += "; ";
            }
        }
        return autoresDevolucion;
    }

    private void setAutor(String autor) {
        this.autor = autor.split("&");
    }

    public String getISBN() {
        return ISBN;
    }

    private void setISBN(String ISBN) throws ExcepcionISBNNoValido {
        if (!ISBNValido(ISBN)) {
            throw new ExcepcionISBNNoValido();
        }
        this.ISBN = ISBN;
    }

    public TipoLengua getLengua() {
        return lengua;
    }

    public void setLengua(TipoLengua lengua) {
        this.lengua = lengua;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    private static boolean ISBNValido(String isbn) {
        // Comprobar si son 10 dígitos.
        if (isbn.length() != 10) {
            return false;
        }

        // Collemos os números é a letra
        String numeros = isbn.substring(0, 9);
        int ultimoDigito = Integer.valueOf(isbn.substring(9));

        // Comprobar los primeros nueve números e ir sumando la variable sumatorio.
        int sumatorio = 0;
        for (int i = 0; i < numeros.length(); i++) {
            if (!((int) numeros.charAt(i) >= (int) '0' && (int) numeros.charAt(i) <= (int) '9')) {
                return false;
            }
            sumatorio += ((i + 1) * Integer.valueOf(numeros.substring(i, i + 1)));
        }

        // Comprobar el último dígito.
        int resto = sumatorio % 11;
        int ultimoDigitoCalculado;
        if (resto == 10) {
            ultimoDigitoCalculado = Integer.valueOf('X');
        } else {
            ultimoDigitoCalculado = resto;
        }

        if (ultimoDigito != ultimoDigitoCalculado) {
            return false;
        }
        return true;

    }

    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(ArrayList<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }

}
