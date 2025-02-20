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

    public void marcarTUsuario(Tarea tarea) {
        this.listaTareasP.remove(tarea);
        this.listaTareasM.add(tarea);
    }

    public Tarea escogerTarea(int i) {
        return this.listaTareasP.get(i - 1);
    }

    public int sizeTareasM() {
        return getListaTareasM().size();
    }

    public int sizeTareasPF() {
        return getListaTareasPF().size();
    }

    public int sizeTareasP48() {
        return getListaTareasP48().size();
    }

    public int sizeTareasP() {
        return this.listaTareasP.size();
    }

    public void añadirTareaP(String tit, String desc, String fchlim) {
        Tarea newTarea = new Tarea(tit, desc, fchlim);
        this.listaTareasP.add(newTarea);
    }

    public boolean comprobarContrasenha(String con) {
        if (this.contrasenha.equals(HashPassword.hashPassword(con))) {
            return true;
        }
        return false;
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

    public ArrayList<Tarea> getListaTareasP48() {
        ArrayList<Tarea> listaTareasP48 = new ArrayList<Tarea>();
        for (Tarea tarea : getListaTareasP()) {
            if (LocalDateTime.now().until(tarea.getFechaLimite(), ChronoUnit.HOURS) <= 48 && LocalDateTime.now().until(tarea.getFechaLimite(), ChronoUnit.HOURS) > 0) {
                listaTareasP48.add(tarea);
            }
        }
        return listaTareasP48;
    }

    public ArrayList<Tarea> getListaTareasPF() {
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
