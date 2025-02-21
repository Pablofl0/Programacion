import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        final int numeroDados = 3;

        System.out.print("Introduce el número de soldados: ");
        int soldados = sc.nextInt();
        sc.nextLine();
        System.out.println("Atacante: " + soldados + " soldados.");
        System.out.print("Defensor: " + soldados + " soldados.");
        sc.nextLine();

        int soldadosJugadorAtaque = soldados;
        int soldadosJugadorDefensa = soldados;

        boolean enjuego = true;
        while (enjuego) {
            int numeroDadosAtaque = soldadosJugadorAtaque;
            if (numeroDadosAtaque > numeroDados) {
                numeroDadosAtaque = numeroDados;
            }
            int[] tiradasAtaque = new int[numeroDadosAtaque];
            for (int i = 0; i < numeroDadosAtaque; i++) {
                int tirada = random.nextInt(6) + 1; // Obtemos un valor entre 1 e 6
                tiradasAtaque[i] = tirada;
            }
            int numeroDadosDefensa = soldadosJugadorDefensa;
            if (numeroDadosDefensa > numeroDados) {
                numeroDadosDefensa = numeroDados;
            }
            int[] tiradasDefensa = new int[numeroDadosDefensa];
            for (int i = 0; i < numeroDadosDefensa; i++) {
                int tirada = random.nextInt(6) + 1; // Obtemos un valor entre 1 e 6
                tiradasDefensa[i] = tirada;
            }

            // Método búrbuja.
            // Ordenandeo tiradasAtaque en el vector de mayor a menor.
            boolean modificado = true;
            while (modificado) {
                int i = 0;
                modificado = false;
                while (i < ((tiradasAtaque.length) - 1)) {
                    if (tiradasAtaque[i] == tiradasAtaque[i + 1]) {
                        i += 1;
                    } else if (tiradasAtaque[i] > tiradasAtaque[i + 1]) {
                        i += 1;
                    } else if (tiradasAtaque[i] < tiradasAtaque[i + 1]) {
                        int reemplazo = tiradasAtaque[i];
                        tiradasAtaque[i] = tiradasAtaque[i + 1];
                        tiradasAtaque[i + 1] = reemplazo;
                        i += 1;
                        modificado = true;
                    }
                }
            }
            // Ordenandeo tiradasAtaque en el vector de mayor a menor.
            boolean modificado2 = true;
            while (modificado2) {
                int i = 0;
                modificado2 = false;
                while (i < ((tiradasDefensa.length) - 1)) {
                    if (tiradasDefensa[i] == tiradasDefensa[i + 1]) {
                        i += 1;
                    } else if (tiradasDefensa[i] > tiradasDefensa[i + 1]) {
                        i += 1;
                    } else if (tiradasDefensa[i] < tiradasDefensa[i + 1]) {
                        int reemplazo = tiradasDefensa[i];
                        tiradasDefensa[i] = tiradasDefensa[i + 1];
                        tiradasDefensa[i + 1] = reemplazo;
                        i += 1;
                        modificado2 = true;
                    }
                }
            }

            System.out.print("Tiradas Atacante: ");
            for (int i = 0; i < numeroDadosAtaque; i++) {
                System.out.print(tiradasAtaque[i] + " ");
            }
            System.out.println();
            System.out.print("Tiradas Defensor: ");
            for (int i = 0; i < numeroDadosDefensa; i++) {
                System.out.print(tiradasDefensa[i] + " ");
            }
            System.out.println();
            sc.nextLine();

            // Comprobando tirada a tirada.
            int i = 0;
            while (i < tiradasAtaque.length && i < tiradasDefensa.length) {
                if (tiradasAtaque[i] <= tiradasDefensa[i]) {
                    soldadosJugadorAtaque -= 1;
                } else {
                    soldadosJugadorDefensa -= 1;
                }
                i++;
            }
            System.out.println("Atacante: " + soldadosJugadorAtaque + " soldados.");
            System.out.print("Defensor: " + soldadosJugadorDefensa + " soldados.");
            sc.nextLine();

            // Comprobando si hay perdedor.
            if (soldadosJugadorAtaque == 0) {
                System.out.println("Gana Defensor.");
                enjuego = false;
            }
            if (soldadosJugadorDefensa == 0) {
                System.out.println("Gana Atacante.");
                enjuego = false;
            }
        }

        sc.close();
    }
}
