package Modelo;

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
    }

    public void anhadirPrestamo(Libro libroPrestado, String fechaPrestamo) {
        this.prestamos.add(new Prestamo(libroPrestado, fechaPrestamo));
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
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isEnPrestamo()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object object) {
        Cliente cliente = (Cliente) object;
        if (this.getDni().equals(cliente.getDni())) {
            return true;
        }
        return false;
    }
}
