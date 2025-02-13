import java.util.ArrayList;

public class Usuario {
    private String usuario;
    private String nombrePila;
    private String contrasenha;
    private ArrayList<Tarea> listaTareas;

    
    public String getNombrePila() {
        return nombrePila;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

    //Constructor para crear el usuario.
    public Usuario(String usuario, String nombrePila, String contrasenha) {
        this.usuario = usuario;
        this.nombrePila = nombrePila;
        this.contrasenha = HashPassword.hashPassword(contrasenha);
        this.listaTareas = new ArrayList<Tarea>();
    }

    //Modificar nombre.
    public void modificarNombre(String newNombre){
        this.nombrePila = newNombre;
    }

}   
