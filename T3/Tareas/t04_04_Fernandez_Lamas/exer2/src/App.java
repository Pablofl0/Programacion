import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean encendido = true;
        ArrayList<Usuario> Personal = new ArrayList<Usuario>();

        while (encendido) {
            //Menú de inicio.
            System.out.println("Selecciona una opción: ");
            System.out.println("\ta) Iniciar sesión.");
            System.out.println("\tb) Registrarse.");
            System.out.println("\tz) Salir.");
            System.out.print("\t> ");
            String opcion = sc.nextLine();

            switch (opcion) {
                String usu;
                String con;
                String nomP;
                //Iniciar sesión
                case "a":
                    System.out.println("Usuario: ");
                    usu = sc.nextLine();
                    System.out.println("Contraseña: ");
                    con = sc.nextLine();

                    break;

                //Registrarse
                case "b":
                    System.out.println("Introduzca un nombre de usuario: ");
                    usu = sc.nextLine();
                    System.out.println("Introduzca un nombre de pila: ");
                    nomP = sc.nextLine();
                    System.out.println("Introduzca la contraseña: ");
                    con = sc.nextLine();
                    System.out.println("Introduzca la contraseña de nuevo: ");
                    con = sc.nextLine();
                    break;
                //Salir
                case "z":

                    break;
                default:
                    break;
            }
        }

        sc.close();
    }
}
