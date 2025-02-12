import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Pregunta cuestionario = new Pregunta();
        boolean activo = true;



        //Bucle que imprime el menú.
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
                    //Se introduce la pregunta.
                    System.out.println("Introduce una pregunta:");
                    String enunciado = sc.nextLine();
                    cuestionario.añadirPregunta(enunciado);
                    //Se preparan las variables.
                    ArrayList<Respuesta> colaRespuestas = new ArrayList<>();
                    boolean pedir = true;
                    int i = 0;
                    System.out.println("Intrdoduce al menos dos posibles respuestas (pulsa fin para salir):");
                    //Se piden respuestas hasta que se tengan dos o más.
                    while (pedir) {
                        i++;
                        System.out.print(i + ": ");
                        String respuesta = sc.nextLine();
                        //Comprueba si es z para terminar o si es una respuesta.
                        switch (respuesta) {
                            case "fin":
                                //Si es fin y hay 2 respuestas o más, el programa sale al menú principal.
                                if (colaRespuestas.size() >= 2) {
                                    cuestionario.añadirCola(enunciado, colaRespuestas);
                                    pedir = false;
                                }
                                //Si es fin y no hay las suficientes respuestas, se imprime lo dicho.
                                else{
                                    System.out.println("No hay sufcientes respuestas.");
                                }
                                break;
                            //En caso de ser una respuesta, esta se añade a la cola de respuestas.
                            default:
                                Respuesta resp = new Respuesta();
                                resp.setContenido(respuesta);
                                colaRespuestas.add(resp);
                                break;
                        }
                    }
                    break;
        
                case "b":
                    //Imprimir las respuestas de cada pregunta, yendo de una en una pregunta.       
                    int j = 0;
                    ArrayList<String> Preguntas = cuestionario.getPreguntas();
                    for (String clave : Preguntas) {
                        j++;
                        cuestionario.imprimir1Preg(clave, j);

                        //Sumar 1 a la respuesta.
                        System.out.print("\nSelecciona una opción: ");
                        int opc = sc.nextInt();
                        sc.nextLine();
                        cuestionario.sumar1vezCuestionario(clave, opc);
                    }

                    //Se termina de responder al cuestionario.
                    System.out.println("Cuestionario finalizado.");
                    break;

                case "c":
                    cuestionario.getPorcentajes();
                    break;




                    /**ArrayList<String> Preguntas = cuestionario.getPreguntas();
                    for (String preg : cuestionario.keySet()) {
                        System.out.println(preg);

                        ArrayList<Respuesta> Respuestas = cuestionario.getRespuestas();
                        for (Respuesta resp : Respuestas) {
                            System.out.print((Respuestas.indexOf(resp) + 1) + ": " + resp + "\t");


                            System.out.print("Selecciona una opción: ");
                            int opc = sc.nextInt();
                            Respuestas.get(opc).sumar1vez();
                            cuestionario.put(preg,Respuestas);
                            switch (opc) {
                                case 1:
                                    cuestionario.put(preg,opc);
                                    break;
                            
                                default:
                                    break;
                            }
                            }
                    }
                    */
                case "z":
                    activo = false;
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}