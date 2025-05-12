package Modelo;

import Excepciones.ExcepcionClienteConPrestamos;
import Excepciones.ExcepcionClienteSinPrestamos;
import Excepciones.ExcepcionEmailInvalido;
import Excepciones.ExcepcionGeneral;
import java.util.ArrayList;

public class Cliente extends Usuario {

    private ArrayList<Prestamo> prestamos;
    private final int CERO = 0;
    private final int UNO = 1;
    private final int DOS = 2;

    public Cliente(String nombreUsuario, String contrasenhaUsuario, String nombre,
            String apellido1, String apellido2, String dni, String correo)
            throws ExcepcionGeneral, ExcepcionEmailInvalido {
        super(nombreUsuario, contrasenhaUsuario, TipoUsuario.CLIENTE, nombre, apellido1, apellido2, dni, correo);
        this.setPrestamos(new ArrayList<>());
    }

    public void anhadirPrestamo(Ejemplar ejemplarPrestado, String fechaPrestamo) throws ExcepcionClienteConPrestamos{
        if (this.tieneLibrosPrestados()) {
            throw new ExcepcionClienteConPrestamos();
        }
        else if (isSancionado()) {
            throw new Excepcion
        }
        this.prestamos.add(new Prestamo(ejemplarPrestado, fechaPrestamo));
    }

    public boolean isSancionado() {
        int suma = CERO;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isFalta()) {
                suma += UNO;
                if (suma == DOS) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean tieneLibrosPrestados() {
        if (this.prestamos.isEmpty()) {
            return false;
        }
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isEnPrestamo()) {
                return true;
            }
        }
        return false;
    }

    public String fechaDevolucionPrestamoActual() {
        String fecha = null;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isEnPrestamo()) {
                fecha = prestamo.getFechaLimiteDevolucion();
            }
        }
        return fecha;
    }

    public Prestamo getPrestamoActual() throws ExcepcionClienteSinPrestamos{
        if (!this.tieneLibrosPrestados()) {
            throw new ExcepcionClienteSinPrestamos();
        }
        return this.prestamos.stream().filter(c -> c.isEnPrestamo()).findFirst().get();
    }

    public void devolverPrestamoActual(String fechaDevolucion) throws ExcepcionClienteSinPrestamos{
        this.getPrestamoActual().setFechaDevolucion(fechaDevolucion);
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    // @Override
    // public boolean equals(Object object) {
    //     Cliente cliente = (Cliente) object;
    //     if (this.getDni().equals(cliente.getDni())) {
    //         return true;
    //     }
    //     return false;
    // }
    
}
