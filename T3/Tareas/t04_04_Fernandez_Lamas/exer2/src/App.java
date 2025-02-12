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
            switch (opcion) {
                // Iniciar sesión
                case "a":
                    System.out.println("Usuario: ");
                    usu = sc.nextLine();
                    System.out.println("Contraseña: ");
                    con1 = sc.nextLine();

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
                            Usuario usuEntrada = new Usuario(usu, nomP, con2);
                            personal.add(usuEntrada);
                            registro = false;
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
        }

        sc.close();
    }
}
