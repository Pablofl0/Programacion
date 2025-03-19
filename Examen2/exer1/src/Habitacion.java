import java.util.ArrayList;

public class Habitacion {
    private int numHabitacion;
    private int tipoHabitacion;
    private double precioPorNoche;
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();


    public Habitacion(int numHabitacion, int tipoHabitacion, double precioPorNoche) {
        this.numHabitacion = numHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioPorNoche = precioPorNoche;
    }

    public boolean comprobarReservasHabitacion(String fechaEntradaReserva, String fechaSalidaReserva){
        for (Reserva reserva : reservas) {
            if (!reserva.comprobarFechas(fechaEntradaReserva, fechaSalidaReserva)) {
                return false;
            }
        }
        return true;
    }

    public void añadirReservaEnHabitacion(Reserva reserva){
        this.reservas.add(reserva);
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }


    public int getTipoHabitacion() {
        return tipoHabitacion;
    }


    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

   


}
