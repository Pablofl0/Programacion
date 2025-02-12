import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarea {
    private String titulo;
    private String descripcion;
    private String fechaLimiteStr;
    private LocalDateTime fechaLimite;
    private LocalDateTime fechaIngreso;
    private boolean pendiente;

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    //Cambiar de string a localdatetime con formato.
    private LocalDateTime formatDateTime(String fch){
        return LocalDateTime.parse(fch, formato);
    }

    //Constructor para introducir las tareas.
    public Tarea(String titulo, String desc, String fchlim){
        this.titulo = titulo;
        this.descripcion = desc;
        this.fechaLimiteStr = fchlim;
        this.fechaLimite = formatDateTime(fchlim);
        this.fechaIngreso = LocalDateTime.now();
        this.pendiente = true;
    }

    //Maracar tarea como realizada. 
    public void marcarTarea(){
        this.pendiente = !pendiente;
    }
}
