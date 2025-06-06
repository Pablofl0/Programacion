package Modelo;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Prestamo implements Serializable {

    private Ejemplar ejemplarPrestado;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimiteDevolucion;
    private LocalDate fechaDevolucion;
    private boolean enPrestamo;

    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Prestamo(Ejemplar ejemplarPrestado, String fechaPrestamo) {
        this.setEjemplarPrestado(ejemplarPrestado);
        this.setFechaPrestamo(fechaPrestamo);
        this.setFechaLimiteDevolucion(fechaPrestamo);
        this.setEnPrestamo(true);
    }

    public LocalDate cambioAFechaNoDomingo(LocalDate fecha) {
        LocalDate newFecha = null;
        if (fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            newFecha = fecha.plusDays(1);
            return newFecha;
        }
        newFecha = fecha;
        return newFecha;
    }

    public boolean isFalta() {
        if (this.fechaDevolucion.isAfter(this.fechaLimiteDevolucion) && ChronoUnit.YEARS.between(this.fechaPrestamo, LocalDate.now()) < 1) {
            return true;
        }
        return false;
    }

    public Ejemplar getEjemplarPrestado() {
        return ejemplarPrestado;
    }

    public void setEjemplarPrestado(Ejemplar ejemplarPrestado) {
        this.ejemplarPrestado = ejemplarPrestado;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = LocalDate.parse(fechaPrestamo, formato);
        // this.setFechaLimiteDevolucion(fechaPrestamo);
    }

    public String getFechaLimiteDevolucion() {
        return this.fechaLimiteDevolucion.format(formato);
    }

    public void setFechaLimiteDevolucion(String fechaPrestamo) {
        this.fechaLimiteDevolucion = cambioAFechaNoDomingo(LocalDate.parse(fechaPrestamo, formato).plusDays(15));
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = LocalDate.parse(fechaDevolucion, formato);
        this.setEnPrestamo(false);
    }

    public boolean isEnPrestamo() {
        return enPrestamo;
    }

    public void setEnPrestamo(boolean enPrestamo) {
        this.enPrestamo = enPrestamo;
    }
}
