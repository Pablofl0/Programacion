import java.util.ArrayList;
import java.util.HashMap;

public class Pregunta {
    private HashMap<String, ArrayList<String>> PreguntaRespuestas;


    public void añadirPregunta(String enunciado){
        this.PreguntaRespuestas.put(enunciado, new ArrayList<String>());
    }

    public void añadirRespuesta(String enunciado, String respuesta){
        this.PreguntaRespuestas.get(enunciado).add(respuesta);
    }

}
