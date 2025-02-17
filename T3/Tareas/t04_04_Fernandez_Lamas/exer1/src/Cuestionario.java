import java.text.DecimalFormat;
import java.util.ArrayList;


public class Cuestionario {
    private ArrayList<Pregunta> cuestionario = new ArrayList<Pregunta>();

    DecimalFormat dosDecimales = new DecimalFormat("#.00");

    public Cuestionario() {
    }

    public Cuestionario(ArrayList<Pregunta> cuestionario) {
        this.cuestionario = cuestionario;
    }

    public void añadir1preg(Pregunta pregunta) {
        this.cuestionario.add(pregunta);
    }

    public void mostrarPorcentajes() {

    }

    public ArrayList<Pregunta> getCuestionario() {
        return cuestionario;
    }
}
