import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int cteKaprekar = 6174;
        boolean seguir = true;
        boolean mostrar = true;
        boolean cte = false;
        int num = 0;
        while (num <= 0 || num >= 10000) {
            System.out.println("Introduce un número de 4 cifras: ");
            num = scanner.nextInt();
            if (num == cteKaprekar) {
                seguir = false;
                cte = true;
                mostrar = false;
            }
        }
        int numeroEscribir = num;

        // Bucle buscando el número de iteraciones.
        int iteraciones = 0;
        while (seguir) {
            // Obteniendo cifras del número en un vector.
            int cifras[] = new int[4];
            for (int i = 0; i < cifras.length; i++) {
                if (num == 0) {
                    cifras[i] = 0;
                }
                int modulo = num % 10;
                num = num / 10;
                cifras[i] = modulo;
            }

            // Método búrbuja.
            // Ordenandeo cifras en el vector de menor a mayor.
            boolean modificado = true;
            while (modificado) {
                int i = 0;
                modificado = false;
                while (i < ((cifras.length) - 1)) {
                    if (cifras[i] == cifras[i + 1]) {
                        i += 1;
                    } else if (cifras[i] < cifras[i + 1]) {
                        i += 1;
                    } else if (cifras[i] > cifras[i + 1]) {
                        int reemplazo = cifras[i];
                        cifras[i] = cifras[i + 1];
                        cifras[i + 1] = reemplazo;
                        i += 1;
                        modificado = true;
                    }
                }
            }

            // Obteniendo número ascendente.
            int numascendente = 0;
            int multiplicador = 1000;
            int divisor = 10;
            for (int i = 0; i < cifras.length; i++) {
                numascendente += (cifras[i] * multiplicador);
                multiplicador = multiplicador / divisor;
            }

            // Obteniendo número descendente.
            int numdescendente = 0;
            int multiplicador2 = 1000;
            int divisor2 = 10;
            for (int i = (cifras.length - 1); i >= 0; i--) {
                numdescendente += (cifras[i] * multiplicador2);
                multiplicador2 = multiplicador2 / divisor2;
            }

            // Comparando números.
            if (numascendente == numdescendente) {
                seguir = false;
                mostrar = false;
            } else {
                int resto = 0;
                resto = numdescendente - numascendente;
                num = resto;
                iteraciones++;
                if (resto == cteKaprekar) {
                    seguir = false;
                }
            }

        }

        if (mostrar) {
            System.out.println("Número de iteraciones de " + numeroEscribir + ": " + iteraciones);
        }
        else{
            if (cte) {
                System.out.println("0");
            }
            else{
                System.out.println("-1");
            }
        }
        scanner.close();
    }
}
