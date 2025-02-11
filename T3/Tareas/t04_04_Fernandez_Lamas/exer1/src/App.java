import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Pregunta cuestionario = new Pregunta();
        boolean activo = true;


        while (activo) {
            System.out.println("Selecciona una opción: ");
            System.out.println("\ta) Añadir pregunta.");
            System.out.println("\tb) Responder cuestionario.");
            System.out.println("\tc) Mostrar resultado.");
            System.out.println("\tz) Salir del programa.");
            System.out.print("\t> ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "a":
                    System.out.println("Introduce una pregunta:");
                    String enunciado = sc.nextLine();
                    cuestionario.añadirPregunta(enunciado);

                    ArrayList<Respuesta> colaRespuestas = new ArrayList<>();
                    boolean pedir = true;
                    int i = 0;
                    while (pedir) {
                        System.out.println("Intrdoduce al menos dos posibles respuestas:");
                        System.out.println("(Pulsa z para salir)");
                        System.out.print(i + ": ");
                        String respuesta = sc.nextLine();
                        Respuesta resp = new Respuesta();
                        resp.setContenido(respuesta);
                        colaRespuestas.add(resp);
                        switch (respuesta) {
                            case "z":
                                if (colaRespuestas.size() >= 2) {
                                    cuestionario.añadirCola(enunciado, colaRespuestas);
                                }
                                pedir = false;
                                break;
                            default:
                                break;
                        }
                    }
        
                case "b":
                    ArrayList<String> Preguntas = cuestionario.getPreguntas();
                    for (String preg : Preguntas) {
                        System.out.println(preg);

                        ArrayList<Respuesta> Respuestas = cuestionario.getRespuestas();
                        for (Respuesta resp : Respuestas) {
                            System.out.println((Respuestas.indexOf(resp) + 1) + ": " + resp);
                    }


                    System.out.print("Selecciona una opción: ");
                    int opc = sc.nextInt();
                    switch (opc) {
                        case 1:
                            
                            break;
                    
                        default:
                            break;
                    }
                    }
                    

                    
                    

                case "z":
                    activo = false;
                    break;




        }




    }
}
