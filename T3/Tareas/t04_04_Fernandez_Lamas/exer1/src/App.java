import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Cuestionario cuestionario = new Cuestionario();
        boolean activo = true;
        DecimalFormat dosDecimales = new DecimalFormat("#.00");

        // Bucle que imprime el menú.
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
                    // Se introduce la pregunta.
                    System.out.println("Introduce una pregunta:");
                    String enunciado = sc.nextLine();
                    // Se preparan las variables.
                    ArrayList<Respuesta> colaRespuestas = new ArrayList<>();
                    boolean pedir = true;
                    int i = 0;
                    System.out.println("Introduce al menos dos posibles respuestas (pulsa fin para salir):");
                    // Se piden respuestas hasta que se tengan dos o más.
                    while (pedir) {
                        i++;
                        System.out.print(i + ": ");
                        String respuesta = sc.nextLine();
                        // Comprueba si es fin para terminar o si es una respuesta.
                        switch (respuesta) {
                            case "fin":
                                // Si es fin y hay 2 respuestas o más, el programa sale al menú principal.
                                if (colaRespuestas.size() >= 2) {
                                    Pregunta newPregunta = new Pregunta(enunciado, colaRespuestas);
                                    cuestionario.añadir1preg(newPregunta);
                                    pedir = false;
                                }
                                // Si es fin y no hay las suficientes respuestas, se imprime lo dicho.
                                else {
                                    System.out.println("No hay sufcientes respuestas.");
                                }
                                break;
                            // En caso de ser una respuesta, esta se añade a la cola de respuestas.
                            default:
                                Respuesta resp = new Respuesta();
                                resp.setContenido(respuesta);
                                colaRespuestas.add(resp);
                                break;
                        }
                    }
                    break;

                case "b":
                    // Imprimir las respuestas de cada pregunta, yendo de una en una pregunta.
                    for (int j = 0; j < cuestionario.getCuestionario().size(); j++) {
                        mostrar1preg(j, cuestionario);
                        int opc = 0;
                        while (opc <= 0 || opc > cuestionario.getCuestionario().get(j).getResps().size() ) {
                            System.out.print("Selecciona una opción: ");
                            opc = sc.nextInt();
                            sc.nextLine();
                        }
                        cuestionario.getCuestionario().get(j).sumar1vezResp(opc);
                    }

                    // Se termina de responder al cuestionario.
                    System.out.println("Cuestionario finalizado.");
                    break;

                case "c":
                    int k = 0;
                    for (Pregunta pregunta : cuestionario.getCuestionario()) {
                        System.out.println((k + 1) + "-. " + pregunta.getEnunciado());
                        int l = 0;
                        for (Respuesta respuesta : pregunta.getResps()) {
                            System.out.print((l + 1) + ": "
                                    + dosDecimales.format((respuesta.getVeces() / pregunta.getRespTotales()) * 100)
                                    + "%\t");
                            l++;
                        }
                        k++;
                    }
                    System.out.println();
                    break;

                case "z":
                    activo = false;
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }

    public static void mostrar1preg(int indice, Cuestionario cuestionario) {
        System.out.println((indice + 1) + "-. " + cuestionario.getCuestionario().get(indice).getEnunciado());
        mostrarResps(cuestionario.getCuestionario().get(indice));
    }

    public static void mostrarResps(Pregunta pregunta) {
        int i = 1;
        for (Respuesta respuesta : pregunta.getResps()) {
            System.out.print(i + ": " + respuesta.getContenido() + "  ");
            i++;
        }
        System.out.println();
    }
}