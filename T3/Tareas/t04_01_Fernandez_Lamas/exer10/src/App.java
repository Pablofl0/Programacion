import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Tablero tableroJuego = new Tablero();

        while (true) {
            tableroJuego.mostrar();

            if (!tableroJuego.isEnjuego()) {
                break;
            }

            while (tableroJuego.isPeticion()) {
                System.out.print("Fila: ");
                int fila = scanner.nextInt();
                System.out.print("Columna: ");
                int columna = scanner.nextInt();
                tableroJuego.pedir(fila, columna);
            }
            

            tableroJuego.comprobar();

            tableroJuego.estado();

            tableroJuego.setPeticion();

            
        }
        scanner.close();
    }
}
