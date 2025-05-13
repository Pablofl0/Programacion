package Modelo;

import Excepciones.ExcepcionEjemplaresInsuficientes;
import java.io.Serializable;
import java.util.ArrayList;

public class Biblioteca implements Serializable {
    private Integer identificadorBiblioteca;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String provincia;
    private ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();

    private static int contadorDeIdentificador = 1;

    public Biblioteca(String nombre, String direccion, String ciudad,
            String provincia) {
        this.setIdentificadorBiblioteca();
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setCiudad(ciudad);
        this.setProvincia(provincia);
    }

    public ArrayList<Ejemplar> getListaEjemplaresSinPrestar() {
        ArrayList<Ejemplar> listaEjemplaresSinPrestar = new ArrayList<>();
        for (Ejemplar ejemplar : this.listaEjemplares) {
            if (!ejemplar.isPrestado()) {
                listaEjemplaresSinPrestar.add(ejemplar);
            }
        }
        return listaEjemplaresSinPrestar;
    }

    @Override
    public String toString() {
        return this.getIdentificadorBiblioteca() + this.getNombre() + ", " + this.getDireccion() + "; "
                + this.getCiudad() + "(" + this.getProvincia() + ")";
    }

    public Integer getIdentificadorBiblioteca() {
        return identificadorBiblioteca;
    }

    public void setIdentificadorBiblioteca() {
        this.identificadorBiblioteca = contadorDeIdentificador;
        contadorDeIdentificador++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void anhadirEjemplares(int numeroDeEjemplares, Libro libro) throws ExcepcionEjemplaresInsuficientes{
        if (libro.getNumeroEjemplaresDisponibles() < numeroDeEjemplares) {
            throw new ExcepcionEjemplaresInsuficientes();
        }
        ArrayList<Ejemplar> listaEjemplaresDisponibles = libro.getEjemplaresDisponibles();
        for (int i = 0; i < numeroDeEjemplares; i++) {
            libro.anhadirEjemplar(listaEjemplaresDisponibles.get(i));
        }
    }

    public ArrayList<Ejemplar> getListaEjemplares() {
        return listaEjemplares;
    }

    public void setListaEjemplares(ArrayList<Ejemplar> listaEjemplares) {
        this.listaEjemplares = listaEjemplares;
    }
}
