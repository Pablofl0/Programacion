package Modelo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Excepciones.ExcepcionEmailInvalido;
import Excepciones.ExcepcionGeneral;

public class Cliente extends Usuario{
    private Libro libroPrestado;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private LocalDate fechaFinDeSancion;
    private boolean sancionado;

    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cliente(String nombreUsuario, String contrasenhaUsuario) throws ExcepcionGeneral,ExcepcionEmailInvalido {
        super(nombreUsuario, contrasenhaUsuario, TipoUsuario.CLIENTE, nombreUsuario, contrasenhaUsuario, contrasenhaUsuario, nombreUsuario, contrasenhaUsuario);
        this.setSancionado(false);
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Libro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public LocalDate getFechaFinDeSancion() {
        return fechaFinDeSancion;
    }

    public void setFechaFinDeSancion(LocalDate fechaFinDeSancion) {
        this.fechaFinDeSancion = fechaFinDeSancion;
    }

    public boolean isSancionado() {
        return sancionado;
    }

    public void setSancionado(boolean sancionado) {
        this.sancionado = sancionado;
    }

    
}
