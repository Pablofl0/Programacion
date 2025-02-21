import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pregunta {
    private String enunciado;
    private ArrayList<Respuesta> resps;
    private final int minimo = 2;
    private final double zero = 0;
    private final double porcentajeCte = 100;
    private static DecimalFormat dosDecimales = new DecimalFormat("#.00");

    // Constructor de pregunta.
    public Pregunta(String enunciado) {
        this.enunciado = enunciado;
        this.resps = new ArrayList<Respuesta>();
    }

    public void crearRespuesta(String contenido){
        Respuesta newRespuesta = new Respuesta(contenido);
        this.resps.add(newRespuesta);
    }

    public String Porcentaje2decimales(Respuesta respuesta){
        return dosDecimales.format((respuesta.getVeces()/getRespTotales()) * porcentajeCte);
    }

    public boolean minRespuestas(){
        if (this.resps.size() >= minimo) {
            return true;
        }
        return false;
    }

    public boolean indiceCorrecto(int i){
        if (i <= zero && i > getResps().size()) {
            return false;
        }
        return true;
    }

    public void sumar1vezResp(int opcion) {
        resps.get(opcion - 1).sumar1vez();
    }

    public double getRespTotales() {
        double suma = 0;
        for (Respuesta respuesta : getResps()) {
            suma += respuesta.getVeces();
        }
        return suma;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public ArrayList<Respuesta> getResps() {
        return resps;
    }

}
