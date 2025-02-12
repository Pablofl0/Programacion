import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Pregunta {
    private HashMap<String, ArrayList<Respuesta>> PreguntaRespuestas = new HashMap<>();

    DecimalFormat dosDecimales = new DecimalFormat("#.00");

    public HashMap<String, ArrayList<Respuesta>> getCuestionario() {
        return PreguntaRespuestas;
    }

    public void añadirPregunta(String enunciado) {
        this.PreguntaRespuestas.put(enunciado, new ArrayList<Respuesta>());
    }

    public void añadirCola(String enunciado, ArrayList<Respuesta> lista) {
        this.PreguntaRespuestas.put(enunciado, lista);
    }

    public void añadirRespuesta(String enunciado, Respuesta respuesta) {
        this.PreguntaRespuestas.get(enunciado).add(respuesta);
    }

    public ArrayList<String> getPreguntas() {
        return new ArrayList<String>(this.PreguntaRespuestas.keySet());
    }

    public ArrayList<Respuesta> getRespuestas() {
        ArrayList<Respuesta> RespuestasPregunta = new ArrayList<Respuesta>();

        ArrayList<String> Preguntas = getPreguntas();
        for (String clave : Preguntas) {
            for (Respuesta valor : this.PreguntaRespuestas.get(clave)) {
                if (!RespuestasPregunta.contains(valor)) {
                    Respuesta claveResp = new Respuesta();
                    claveResp.setContenido(clave);
                    RespuestasPregunta.add(claveResp);
                }
            }
        }
        return RespuestasPregunta;
    }

    public void imprimirCuestionario() {
        for (String clave : this.PreguntaRespuestas.keySet()) {
            System.out.println((clave.indexOf(clave) + 1) + "-. " + clave);
            ArrayList<Respuesta> valores = this.PreguntaRespuestas.get(clave);
            for (Respuesta valor : valores) {
                System.out.print((valores.indexOf(valor) + 1) + ": " + valor + "\t");
            }
        }
    }

    public void imprimir1Preg(String clave, int i) {
        System.out.println(i + "-. " + clave);
        ArrayList<Respuesta> valores = this.PreguntaRespuestas.get(clave);
        for (Respuesta valor : valores) {
            System.out.print((valores.indexOf(valor) + 1) + ": " + valor.getContenido() + "\t");
        }
    }

    private double getRespTotales(ArrayList<Respuesta> lista) {
        double suma = 0;
        for (Respuesta respuesta : lista) {
            suma += respuesta.getVeces();
        }
        return suma;
    }

    public void getPorcentajes() {
        for (String clave : this.PreguntaRespuestas.keySet()) {
            System.out.println((clave.indexOf(clave) + 1) + "-" + clave);
            ArrayList<Respuesta> resps = this.PreguntaRespuestas.get(clave);
            for (Respuesta resp : resps) {
                System.out.print((resps.indexOf(resp) + 1) + ": " + dosDecimales.format((resp.getVeces() / (getRespTotales(resps))) * 100) + "%\t");
            }
            System.out.println();
        }
    }

    public void sumar1vezCuestionario(String clave, int indice) {
        ArrayList<Respuesta> Respuestas = this.PreguntaRespuestas.get(clave);
        if (indice > 0 && indice <= Respuestas.size()) {
            Respuestas.get(indice - 1).sumar1vez();
        }
    }

}
