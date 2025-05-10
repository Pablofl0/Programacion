package Modelo;

import Excepciones.ExcepcionEmailInvalido;
import Excepciones.ExcepcionGeneral;
import java.util.ArrayList;

public class AdministradorBiblioteca extends Usuario {
    private Biblioteca bibliotecaAsignada;

    public AdministradorBiblioteca(String nombreUsuario, String contrasenhaUsuario, 
            String nombre, String apellido1, String apellido2, String dni, String correo, Biblioteca bibliotecaAsignada)
            throws ExcepcionGeneral, ExcepcionEmailInvalido {
        super(nombreUsuario, contrasenhaUsuario, TipoUsuario.ADMINBIBLIOTECA, nombre, apellido1, apellido2, dni, correo);
        this.setBibliotecaAsignada(bibliotecaAsignada);
    }

    public ArrayList<Ejemplar> verListaDeEjemplaresSinPrestarEnLaBiblioteca() {
        return this.bibliotecaAsignada.getListaEjemplaresSinPrestar();
    }

    public Biblioteca getBibliotecaAsignada() {
        return bibliotecaAsignada;
    }

    public void setBibliotecaAsignada(Biblioteca bibliotecaAsignada) {
        this.bibliotecaAsignada = bibliotecaAsignada;
    }

}
