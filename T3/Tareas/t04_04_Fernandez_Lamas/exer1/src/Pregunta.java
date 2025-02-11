import java.util.ArrayList;
import java.util.HashMap;

public class Pregunta {
    private HashMap<String, ArrayList<Respuesta>> PreguntaRespuestas;
    private HashMap<String, ArrayList<Integer>> resultados;


    public void añadirPregunta(String enunciado){
        this.PreguntaRespuestas.put(enunciado, new ArrayList<Respuesta>());
    }

    public void añadirCola(String enunciado, ArrayList<Respuesta> lista){
        this.PreguntaRespuestas.put(enunciado, lista);
    }

    public void añadirRespuesta(String enunciado, Respuesta respuesta){
        this.PreguntaRespuestas.get(enunciado).add(respuesta);
    }

    public ArrayList<String> getPreguntas(){
        return new ArrayList<String>(this.PreguntaRespuestas.keySet());
    }

    public ArrayList<Respuesta> getRespuestas(){
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

    public void añadir1(int numeroPregunta, int numeroRespuesta){
        this.resultados.get(numeroPregunta).get(numeroRespuesta) ;
    }

}
