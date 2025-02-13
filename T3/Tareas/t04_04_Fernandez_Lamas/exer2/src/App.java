import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean encendido = true;
        ArrayList<Usuario> personal = new ArrayList<Usuario>();

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
            boolean registro = true;
            boolean dentro = false;
            Usuario usuNow = null;
            switch (opcion) {
                // Iniciar sesión
                case "a":
                    System.out.println("Usuario: ");
                    usu = sc.nextLine();
                    System.out.println("Contraseña: ");
                    con1 = sc.nextLine();
                    for (Usuario usuario : personal) {
                        if (usuario.getUsuario().equals(usu)
                                && usuario.getContrasenha().equals(HashPassword.hashPassword(con1))) {
                            usuNow = usuario;
                            System.out.println("¡Bienvenido " + usuNow.getNombrePila() + "!");
                            dentro = true;
                            break;
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
                        if (con1.equals(con2)) {
                            Usuario usuEntrada = new Usuario(usu, nomP, con1);
                            personal.add(usuEntrada);
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
                ArrayList<Tarea> listaTareaUsu = usuNow.getListaTareas();
                int i = 0;

                switch (accion) {
                    case "a":
                        System.out.print("Indica el nuevo nombre: ");
                        String newNombre = sc.nextLine();
                        usuNow.modificarNombre(newNombre);
                        break;
                    case "b":
                        System.out.print("Introduzca el título de la tarea: ");
                        String tit = sc.nextLine();
                        System.out.print("Introduzca la descripción de la tarea: ");
                        String desc = sc.nextLine();
                        System.out.print("Introduzca la fecha y hora límite de la tarea: ");
                        String fchlim = sc.nextLine();
                        Tarea newTarea = new Tarea(tit, desc, fchlim);
                        usuNow.getListaTareas().add(newTarea);
                        break;
                    case "c":
                        i = 0;
                        boolean select = true;
                        Tarea tareaEsc = null;
                        for (Tarea tarea : listaTareaUsu) {
                            if (tarea.isPendiente()) {
                                System.out.println((i + 1) + ": " + tarea.getTitulo());
                            }
                        }
                        while (select) {
                            System.out.println("¿Qué tarea quieres ver?");
                            int indice = sc.nextInt();
                            if (indice > 0 && indice <= listaTareaUsu.size()) {
                                tareaEsc = listaTareaUsu.get(indice - 1);
                                select = false;
                            } else {
                                System.out.println("Introduzca un índice válido.");
                            }
                        }
                        System.out.println("\tDescripción: " + tareaEsc.getDescripcion());
                        System.out.println("\tFecha límite: " + tareaEsc.getFechaLimiteStr());
                        System.out.println("\tFecha ingreso: " + tareaEsc.getFechaIngresoStr());
                        break;
                    case "d":
                        i = 0;
                        boolean select2 = true;
                        for (Tarea tarea : listaTareaUsu) {
                            if (tarea.isPendiente()) {
                                System.out.println((i + 1) + ": " + tarea.getTitulo());
                            }
                        }
                        while (select2) {
                            System.out.println("¿Qué tarea quieres marcar como realizada?");
                            int indice = sc.nextInt();
                            if (indice > 0 && indice <= listaTareaUsu.size()) {
                                tareaEsc = listaTareaUsu.get(indice - 1);
                                tareaEsc.marcarTarea();
                                select2 = false;
                            } else {
                                System.out.println("Introduzca un índice válido.");
                            }
                        }
                        break;
                    case "e":
                        i = 0;
                        for (Tarea tarea : listaTareaUsu) {
                            if (tarea.isPendiente()
                                    && tarea.getFechaLimite().until(LocalDateTime.now(), ChronoUnit.HOURS) <= 48) {
                                System.out.println((i + 1) + ": " + tarea.getTitulo());
                            }
                        }
                        break;
                    case "f":
                        i = 0;
                        for (Tarea tarea : listaTareaUsu) {
                            if (!tarea.isPendiente()) {
                                System.out.println((i + 1) + ": " + tarea.getTitulo());
                            }
                        }
                        break;
                    case "g":
                        i = 0;
                        for (Tarea tarea : listaTareaUsu) {
                            if (tarea.isPendiente() && LocalDateTime.now().isBefore(tarea.getFechaLimite())) {
                                System.out.println((i + 1) + ": " + tarea.getTitulo());
                            }
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
}
