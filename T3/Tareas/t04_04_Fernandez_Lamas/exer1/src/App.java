import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);


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
                    PreguntaRespuestas.añadirPregunta();
                    PreguntaRespuestas.añadirRespuesta();
                     

                case "b":
                    

                case "z":
                    activo = false;
                    break;




        }




    }
}
