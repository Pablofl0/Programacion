import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private int idResereva;
    private String nombreReserva;
    private LocalDate fechEntrada;
    private LocalDate fechSalida;

    private static int contadorIdentity = 1;
    private final static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reserva(String nombreReserva, String fechEntrada, String fechSalida) {
        this.nombreReserva = nombreReserva;
        this.fechEntrada = LocalDate.parse(fechEntrada, formato);
        this.fechSalida = LocalDate.parse(fechSalida, formato);
        this.idResereva = contadorIdentity;
        contadorIdentity++;
    }

    public boolean comprobarFechas(String fchEntrada, String fchSalida){
        LocalDate fechaEntradaPeticion = LocalDate.parse(fchEntrada, formato);
        LocalDate fechaSalidaPeticion = LocalDate.parse(fchSalida, formato);
        if ((fechaEntradaPeticion.isAfter(fechEntrada.minusDays(1)) && fechaEntradaPeticion.isBefore(fechSalida)) || fechaSalidaPeticion.isAfter(fechEntrada)) {
            return false;
        }
        return true;
    }
    
    public boolean comprobarDiaEnReserva(String diaPorcentaje){
        LocalDate diaPorcentajeFormateado = LocalDate.parse(diaPorcentaje, formato);
        if ((diaPorcentajeFormateado.isAfter(fechEntrada.minusDays(1)) && diaPorcentajeFormateado.isBefore(fechSalida))) {
            return true;
        }
        return false;
    }
}
