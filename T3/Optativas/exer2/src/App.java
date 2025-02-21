import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        int tirada = random.nextInt(6) + 1; // Obtemos un valor entre 1 e 6
        final int numeroDados = 3;

        System.out.print("Introduce el número de soldados: ");
        int soldados = sc.nextInt();
        sc.nextLine();

        int soldadosJugadorAtaque = soldados;
        int soldadosJugadorDefensa = soldados;

        boolean enjuego = true;
        int[] tiradasDefensa = new int[numeroDados];
        int[] tiradasAtaque = new int[numeroDados];
        while (enjuego) {
            int numeroDadosAtaque = soldadosJugadorAtaque;
            if (numeroDadosAtaque > numeroDados) {
                numeroDadosAtaque = numeroDados;
            }
            for (int i = 0; i < numeroDadosAtaque; i++) {
                tiradasAtaque[i] = tirada;
            }
            int numeroDadosDefensa = soldadosJugadorDefensa;
            if (numeroDadosDefensa > numeroDados) {
                numeroDadosDefensa = numeroDados;
            }
            for (int i = 0; i < numeroDadosDefensa; i++) {
                tiradasDefensa[i] = tirada;
            }

            // Método búrbuja.
            // Ordenandeo tiradasAtaque en el vector de menor a mayor.
            boolean modificado = true;
            while (modificado) {
                int i = 0;
                modificado = false;
                while (i < ((tiradasAtaque.length) - 1)) {
                    if (tiradasAtaque[i] == tiradasAtaque[i + 1]) {
                        i += 1;
                    } else if (tiradasAtaque[i] < tiradasAtaque[i + 1]) {
                        i += 1;
                    } else if (tiradasAtaque[i] > tiradasAtaque[i + 1]) {
                        int reemplazo = tiradasAtaque[i];
                        tiradasAtaque[i] = tiradasAtaque[i + 1];
                        tiradasAtaque[i + 1] = reemplazo;
                        i += 1;
                        modificado = true;
                    }
                }
            }

            boolean modificado2 = true;
            while (modificado2) {
                int i = 0;
                modificado2 = false;
                while (i < ((tiradasDefensa.length) - 1)) {
                    if (tiradasDefensa[i] == tiradasDefensa[i + 1]) {
                        i += 1;
                    } else if (tiradasDefensa[i] < tiradasDefensa[i + 1]) {
                        i += 1;
                    } else if (tiradasDefensa[i] > tiradasDefensa[i + 1]) {
                        int reemplazo = tiradasDefensa[i];
                        tiradasDefensa[i] = tiradasDefensa[i + 1];
                        tiradasDefensa[i + 1] = reemplazo;
                        i += 1;
                        modificado = true;
                    }
                }
            }
        }

        sc.close();
    }
}
