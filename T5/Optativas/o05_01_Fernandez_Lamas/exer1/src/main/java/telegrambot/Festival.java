package telegrambot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Festival {
    private String nombre;
    private String poblacion;
    private NombreProvincia nombreProvincia;
    private LocalDate horaInicio;
    private LocalDate horaFinal;

    private final static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 

    public Festival(String nombre, String poblacion, NombreProvincia nombreProvincia, String horaInicio, String horaFinal) {
        this.setNombre(nombre);
        this.setPoblacion(poblacion);
        this.setProvincia(nombreProvincia);
        this.setHoraInicio(horaInicio);
        this.setHoraFinal(horaFinal);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public NombreProvincia getProvincia() {
        return nombreProvincia;
    }

    public void setProvincia(NombreProvincia nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public LocalDate getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = LocalDate.parse(horaInicio);
    }

    public LocalDate getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = LocalDate.parse(horaFinal);
    }

}
