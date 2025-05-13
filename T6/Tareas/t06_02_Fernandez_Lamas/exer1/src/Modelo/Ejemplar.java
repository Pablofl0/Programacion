package Modelo;

import java.io.Serializable;

public class Ejemplar implements Serializable {
    private Libro libro;
    private Biblioteca biblioteca;
    private Cliente cliente;
    private String idEjemplar;
    private boolean prestado;
    private static int contadorDeIdentificador = 1;


    public Ejemplar(Libro libro) {
        this.setLibro(libro);
        this.setIdEjemplar();
        this.setPrestado(false);
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
        this.setPrestado(true);
    }

    public void quitarCliente() {
        this.setCliente(null);
        this.setPrestado(false);
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar() {
        this.idEjemplar = libro.getISBN() + contadorDeIdentificador;
        contadorDeIdentificador++;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

}
