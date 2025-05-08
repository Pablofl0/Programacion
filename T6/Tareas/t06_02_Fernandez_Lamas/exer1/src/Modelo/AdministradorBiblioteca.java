package Modelo;

import Excepciones.ExcepcionEmailInvalido;
import Excepciones.ExcepcionGeneral;

public class AdministradorBiblioteca extends Usuario {
    private Biblioteca bibliotecaAsignada;

    public AdministradorBiblioteca(String nombreUsuario, String contrasenhaUsuario, TipoUsuario tipoUsuario,
            String nombre, String apellido1, String apellido2, String dni, String correo, Biblioteca bibliotecaAsignada)
            throws ExcepcionGeneral, ExcepcionEmailInvalido {
        super(nombreUsuario, contrasenhaUsuario, tipoUsuario, nombre, apellido1, apellido2, dni, correo);
        this.setBibliotecaAsignada(bibliotecaAsignada);
    }

    public Biblioteca getBibliotecaAsignada() {
        return bibliotecaAsignada;
    }

    public void setBibliotecaAsignada(Biblioteca bibliotecaAsignada) {
        this.bibliotecaAsignada = bibliotecaAsignada;
    }

}
