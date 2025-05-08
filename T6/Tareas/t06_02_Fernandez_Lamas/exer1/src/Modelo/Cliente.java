package Modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Excepciones.ExcepcionEmailInvalido;
import Excepciones.ExcepcionGeneral;

public class Cliente extends Usuario {
    private Libro libroPrestado;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimiteDevolucion;
    private LocalDate fechaDevolucion;
    private LocalDate fechaFinDeSancion;
    private boolean libroDevuelto;
    private boolean sancionado;

    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cliente(String nombreUsuario, String contrasenhaUsuario, TipoUsuario tipoUsuario, String nombre,
            String apellido1, String apellido2, String dni, String correo)
            throws ExcepcionGeneral, ExcepcionEmailInvalido {
        super(nombreUsuario, contrasenhaUsuario, TipoUsuario.CLIENTE, nombreUsuario, contrasenhaUsuario,
                contrasenhaUsuario, nombreUsuario, contrasenhaUsuario);
        this.setSancionado(false);
    }

    public LocalDate cambioAFechaNoDomingo(LocalDate fecha) {
        LocalDate newFecha = null;
        if (fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            newFecha = fecha.plusDays(1);
        }
        return newFecha;
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
        this.fechaPrestamo = LocalDate.parse(fechaPrestamo, formato);
        this.setLibroDevuelto(false);
    }

    public LocalDate getFechaLimiteDevolucion() {
        return fechaLimiteDevolucion;
    }

    public void setFechaLimiteDevolucion() {
        this.fechaLimiteDevolucion = cambioAFechaNoDomingo(this.fechaPrestamo.plusDays(15));
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = LocalDate.parse(fechaDevolucion, formato);
        if (this.fechaDevolucion.isAfter(fechaLimiteDevolucion)) {
            this.setSancionado(true);
            this.setFechaFinDeSancion();
        }
        this.setLibroDevuelto(true);
        this.setLibroPrestado(null);
    }

    public LocalDate getFechaFinDeSancion() {
        return fechaFinDeSancion;
    }

    public void setFechaFinDeSancion() {
        this.fechaFinDeSancion = cambioAFechaNoDomingo(this.fechaPrestamo.plusYears(1));
    }

    public boolean isLibroDevuelto() {
        return libroDevuelto;
    }

    public void setLibroDevuelto(boolean libroDevuelto) {
        this.libroDevuelto = libroDevuelto;
    }

    public boolean isSancionado() {
        return sancionado;
    }

    public void setSancionado(boolean sancionado) {
        this.sancionado = sancionado;
    }

}
