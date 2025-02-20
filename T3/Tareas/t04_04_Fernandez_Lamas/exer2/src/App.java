import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean encendido = true;
        HashMap<String, Usuario> personal = new HashMap<String, Usuario>();

        while (encendido) {
            // Menú de inicio.
            System.out.println("Selecciona una opción: ");
            System.out.println("\ta) Iniciar sesión.");
            System.out.println("\tb) Registrarse.");
            System.out.println("\tz) Salir.");
            System.out.print("\t> ");
            String opcion = sc.nextLine();

            // Inicializando variables.
            String usu;
            String con1;
            String con2;
            String nomP;
            boolean inicio = true;
            boolean registro = true;
            boolean dentro = false;
            Usuario usuNow = null;
            switch (opcion) {
                // Iniciar sesión
                case "a":
                    while (inicio) {
                        System.out.println("Usuario: ");
                        usu = sc.nextLine();
                        System.out.println("Contraseña: ");
                        con1 = sc.nextLine();
                        if (personal.containsKey(usu) && personal.get(usu).comprobarContrasenha(con1)) {
                            usuNow = personal.get(usu);
                            System.out.println("¡Bienvenido " + usuNow.getNombrePila() + "!");
                            dentro = true;
                            inicio = false;
                        } else {
                            System.out.println("Usuario o contraseña no válidos.");
                        }
                    }
                    break;

                // Registrarse
                case "b":
                    while (registro) {
                        System.out.println("Introduzca un nombre de usuario: ");
                        usu = sc.nextLine();
                        System.out.println("Introduzca un nombre de pila: ");
                        nomP = sc.nextLine();
                        System.out.println("Introduzca la contraseña: ");
                        con1 = sc.nextLine();
                        System.out.println("Introduzca la contraseña de nuevo: ");
                        con2 = sc.nextLine();
                        if (!personal.containsKey(usu) && con1.equals(con2) && comprobarContrasenhaRegistro(con1)) {
                            Usuario usuEntrada = new Usuario(usu, nomP, con1);
                            personal.put(usu, usuEntrada);
                            usuNow = usuEntrada;
                            registro = false;
                            dentro = true;
                        }
                    }
                    break;
                // Salir
                case "z":
                    encendido = false;
                    break;
                default:
                    System.out.println("Introduce una opción válida.");
                    break;
            }
            while (dentro) {
                // Menú de inicio.
                System.out.println("Selecciona una opción: ");
                System.out.println("\ta) Modificar nombre.");
                System.out.println("\tb) Ingresar tarea pendiente.");
                System.out.println("\tc) Mostrar tareas pendientes.");
                System.out.println("\td) Marcar tarea como realizada.");
                System.out.println("\te) Mostrar tareas pendientes en las próximas 48 horas.");
                System.out.println("\tf) Mostrar tareas realizadas.");
                System.out.println("\tg) Mostrar tareas pendientes fuera de entrega.");
                System.out.println("\tz) Cerrar sesión.");
                System.out.print("\t> ");
                String accion = sc.nextLine();

                boolean select = true;
                Tarea tareaEsc = null;

                switch (accion) {
                    // Modificar nombre.
                    case "a":
                        System.out.print("Indica el nuevo nombre: ");
                        String newNombre = sc.nextLine();
                        usuNow.modificarNombre(newNombre);
                        break;
                    // Ingresar tarea pendiente.
                    case "b":
                        System.out.print("Introduzca el título de la tarea: ");
                        String tit = sc.nextLine();
                        System.out.print("Introduzca la descripción de la tarea: ");
                        String desc = sc.nextLine();
                        System.out.print("Introduzca la fecha y hora límite de la tarea (dd/MM/yyyy HH:mm): ");
                        String fchlim = sc.nextLine();
                        usuNow.añadirTareaP(tit, desc, fchlim);
                        break;
                    // Mostrar tareas pendientes
                    case "c":
                        if (usuNow.sizeTareasP() == 0) {
                            System.out.println("No hay tareas pendientes.");
                        } else {
                            imprimirTareas(usuNow.getListaTareasP());
                            select = true;
                            while (select) {
                                System.out.println("¿Qué tarea quieres ver?");
                                int indice = sc.nextInt();
                                sc.nextLine();
                                if (indice > 0 && indice <= usuNow.sizeTareasP()) {
                                    tareaEsc = usuNow.escogerTarea(indice);
                                    select = false;
                                } else {
                                    System.out.println("Introduzca un índice válido.");
                                }
                            }
                            System.out.println("\tDescripción: " + tareaEsc.getDescripcion());
                            System.out.println("\tFecha límite: " + tareaEsc.getFechaLimiteStr());
                            System.out.println("\tFecha ingreso: " + tareaEsc.getFechaIngresoStr());
                        }

                        break;
                    // Marcar tarea como realizada.
                    case "d":
                        if (usuNow.sizeTareasP() == 0) {
                            System.out.println("No hay tareas pendientes.");
                        } else {
                            imprimirTareas(usuNow.getListaTareasP());
                            select = true;
                            while (select) {
                                System.out.println("¿Qué tarea quieres marcar como realizada?");
                                int indice = sc.nextInt();
                                Tarea tarea = usuNow.getListaTareasP().get(indice);
                                sc.nextLine();
                                if (indice > 0 && indice <= usuNow.sizeTareasP()) {
                                    usuNow.marcarTUsuario(tarea);
                                    select = false;
                                } else {
                                    System.out.println("Introduzca un índice válido.");
                                }
                            }
                        }
                        break;
                    // Mostrar tareas pendientes en las próximas 48 horas.
                    case "e":
                        if (usuNow.sizeTareasP48() == 0) {
                            System.out.println("No hay tareas pendientes en las próximas 48 horas.");
                        } else {
                            imprimirTareas(usuNow.getListaTareasP48());
                        }
                        break;
                    // Mostrar tareas realizadas.
                    case "f":
                        if (usuNow.sizeTareasM() == 0) {
                            System.out.println("No hay tareas realizadas.");
                        } else {
                            imprimirTareas(usuNow.getListaTareasM());
                        }
                        break;
                    // Mostrar tareas pendientes fuera de entrega.
                    case "g":
                        if (usuNow.sizeTareasPF() == 0) {
                            System.out.println("No hay tareas pendientes fuera de entrega.");
                        } else {
                            imprimirTareas(usuNow.getListaTareasPF());
                        }
                        break;
                    case "z":
                        dentro = false;
                        break;
                    default:
                        break;
                }
            }
        }

        sc.close();
    }

    // Método para imprimir tareas.
    public static void imprimirTareas(ArrayList<Tarea> lista) {
        int i = 1;
        for (Tarea tarea : lista) {
            System.out.println(i + ": " + tarea.getTitulo());
        }
    }

    public static boolean comprobarContrasenhaRegistro(String con1) {
        boolean valida = true;
        for (char c : con1.toCharArray()) {
            if (Character.isUpperCase(c)) {
                valida = false;
            } else if (Character.isLowerCase(c)) {
                valida = false;
            } else if (Character.isDigit(c)) {
                valida = false;
            }
        }
        return valida;
    }
}
