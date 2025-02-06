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

            tableroJuego.pedir();

            tableroJuego.comprobar();

            tableroJuego.estado();   
            
            scanner.close();
        }
    }
}
