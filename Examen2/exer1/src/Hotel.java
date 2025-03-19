import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private String nombreHotel;
    private HashMap<Integer, Habitacion> habitaciones = new HashMap<>();

    public Hotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public boolean comprobarNumeroHabitacion(int numeroNuevo) {
        for (Integer numHabitacion : habitaciones.keySet()) {
            if (numHabitacion == numeroNuevo) {
                return false;
            }
        }
        return true;
    }

    public void añadirHabitacion(int numHabitacion, int tipoHabitacion, double precioPorNoche) {
        Habitacion newHabitacion = new Habitacion(numHabitacion, tipoHabitacion, precioPorNoche);
        this.habitaciones.put(numHabitacion, newHabitacion);
    }

    public ArrayList<Habitacion> getHabitacionesSegunTipo(int tipoHabitacion) {
        ArrayList<Habitacion> habitacionesSegunTipo = new ArrayList<>();
        for (Integer clave : habitaciones.keySet()) {
            if (habitaciones.get(clave).getTipoHabitacion() == tipoHabitacion) {
                habitacionesSegunTipo.add(habitaciones.get(clave));
            }
        }
        return habitacionesSegunTipo;
    }

    public ArrayList<Habitacion> getReservas(int tipoHabitacion, String fchEntrada, String fchSalida){
        ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<>();
        ArrayList<Habitacion> habitacionesSegunTipo = this.getHabitacionesSegunTipo(tipoHabitacion);
            for (Habitacion habitacion : habitacionesSegunTipo) {
                if (habitacion.getReservas().size() == 0) {
                    habitacionesDisponibles.add(habitacion);
                } else {
                    for (Reserva reserva : habitacion.getReservas()) {
                        if (reserva.comprobarFechas(fchEntrada, fchSalida)) {
                            habitacionesDisponibles.add(habitacion);
                        }
                    }

                }
            }
        return habitacionesDisponibles;
    }

    public double calcularPorcentajeOcupacionHotel(String diaPorcentaje) {
        double reservasTotal = 0;
        double reservasDiaEscogido = 0;
        for (int numHabitacion : habitaciones.keySet()) {
            for (Reserva reserva : habitaciones.get(numHabitacion).getReservas()) {
                reservasTotal++;
                if (reserva.comprobarDiaEnReserva(diaPorcentaje)) {
                    reservasDiaEscogido++;
                }
            }
        }
        return ((reservasDiaEscogido / reservasTotal) * 100);
    }

    public boolean comprobarNumeroHabitacionReserva(int numeroHabitacionReserva) {
        for (Integer num : habitaciones.keySet()) {
            if (numeroHabitacionReserva == num) {
                return true;
            }
        }
        return false;
    }

    public boolean comprobarReservasHabitacionHotel(int numeroHabitacionReserva, String fechaEntradaReserva,
            String fechaSalidaReserva) {
        if (!this.habitaciones.get(numeroHabitacionReserva).comprobarReservasHabitacion(fechaEntradaReserva,
                fechaSalidaReserva)) {
            return false;
        }
        return true;
    }

    public void añadirReservaEnHotel(int numeroHabitacionReserva, Reserva newReserva) {
        this.habitaciones.get(numeroHabitacionReserva).añadirReservaEnHabitacion(newReserva);
    }

    public boolean comprobarReservaGeneral(int numeroHabitacionReserva, String fechaEntradaReserva,
            String fechaSalidaReserva) {
        if (!this.comprobarNumeroHabitacionReserva(numeroHabitacionReserva)
                || !this.comprobarReservasHabitacionHotel(numeroHabitacionReserva, fechaEntradaReserva,
                        fechaSalidaReserva)) {
            return false;
        }
        return true;
    }

    public HashMap<Integer, Habitacion> getHabitaciones() {
        return habitaciones;
    }

}
