package Modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Prestamo {

    private Libro libroPrestado;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimiteDevolucion;
    private LocalDate fechaDevolucion;
    private boolean enPrestamo;

    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Prestamo(Libro libroPrestado, String fechaPrestamo) {
        this.setLibroPrestado(libroPrestado);
        this.setFechaPrestamo(fechaPrestamo);
        this.setEnPrestamo(true);
    }

    public LocalDate cambioAFechaNoDomingo(LocalDate fecha) {
        LocalDate newFecha = null;
        if (fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            newFecha = fecha.plusDays(1);
        }
        return newFecha;
    }

    public boolean isFalta() {
        if (this.fechaDevolucion.isAfter(this.fechaLimiteDevolucion) && ChronoUnit.YEARS.between(this.fechaPrestamo, LocalDate.now()) < 1) {
            return true;
        }
        return false;
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
    }

    public String getFechaLimiteDevolucion() {
        return fechaLimiteDevolucion.format(formato);
    }

    public void setFechaLimiteDevolucion() {
        this.fechaLimiteDevolucion = cambioAFechaNoDomingo(this.fechaPrestamo.plusDays(15));
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
