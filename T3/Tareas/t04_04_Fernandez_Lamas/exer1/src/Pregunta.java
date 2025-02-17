import java.util.ArrayList;

public class Pregunta {
    private String enunciado;
    private ArrayList<Respuesta> resps;

    // Constructor de pregunta.
    public Pregunta(String enunciado, ArrayList<Respuesta> resps) {
        this.enunciado = enunciado;
        this.resps = resps;
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
