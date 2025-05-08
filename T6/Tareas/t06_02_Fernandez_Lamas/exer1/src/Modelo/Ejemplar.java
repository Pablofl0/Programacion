package Modelo;

public class Ejemplar {
    private Libro libro;
    private Biblioteca biblioteca;
    private Cliente cliente;
    private String idEjemplar;
    private static int contadorDeIdentificador = 1;


    public Ejemplar(Libro libro, Biblioteca biblioteca) {
        this.setLibro(libro);
        this.setBiblioteca(biblioteca);
        this.setCliente(cliente);
        this.setIdEjemplar();
        this.getLibro().anhadirEjemplar(this);
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar() {
        this.idEjemplar = libro.getISBN() + contadorDeIdentificador;
        contadorDeIdentificador++;
    }

}
