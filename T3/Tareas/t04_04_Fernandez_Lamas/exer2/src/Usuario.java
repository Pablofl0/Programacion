import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Usuario {
    private String usuario;
    private String nombrePila;
    private String contrasenha;
    private ArrayList<Tarea> listaTareasP;
    private ArrayList<Tarea> listaTareasM;

    // Constructor para crear el usuario.
    public Usuario(String usuario, String nombrePila, String contrasenha) {
        this.usuario = usuario;
        this.nombrePila = nombrePila;
        this.contrasenha = HashPassword.hashPassword(contrasenha);
        this.listaTareasP = new ArrayList<Tarea>();
        this.listaTareasM = new ArrayList<Tarea>();
    }

    // Añadir tarea a pendiente.
    public void añadirP(Tarea tarea) {
        this.listaTareasP.add(tarea);
    }

    // Añadir tarea a marcada.
    public void añadirM(Tarea tarea) {
        this.listaTareasM.add(tarea);
    }

    // Modificar nombre.
    public void modificarNombre(String newNombre) {
        this.nombrePila = newNombre;
    }

    public String getNombrePila() {
        return nombrePila;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public ArrayList<Tarea> getListaTareasP() {
        return listaTareasP;
    }

    public ArrayList<Tarea> getListaTareasP48(){
        ArrayList<Tarea> listaTareasP48 = new ArrayList<Tarea>();
        for (Tarea tarea : getListaTareasP()) {
            if (tarea.getFechaLimite().until(LocalDateTime.now(), ChronoUnit.HOURS) <= 48) {
                listaTareasP48.add(tarea);   
            }
        }
        return listaTareasP48;
    }

    public ArrayList<Tarea> getListaTareasPF(){
        ArrayList<Tarea> listaTareasPF = new ArrayList<Tarea>();
        for (Tarea tarea : getListaTareasP()) {
            if (tarea.getFechaLimite().isBefore(LocalDateTime.now())) {
                listaTareasPF.add(tarea);   
            }
        }
        return listaTareasPF;
    }

    public ArrayList<Tarea> getListaTareasM() {
        return listaTareasM;
    }

}
