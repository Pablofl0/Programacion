import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner Scanner = new Scanner(System.in);

        boolean seguir = true;
        boolean activo = true;
        while (seguir) {
            // Pidiendo número de pasajeros.
            System.out.println("Número de pasajeros en la parte superior: ");
            int arriba = Scanner.nextInt();
            //Número negativo arriba.
            if (arriba<0) {
                activo = false;
            }
            System.out.println("Número de pasajeros en la parte inferior: ");
            int abajo = Scanner.nextInt();
            //Número negativo abajo.
            if (abajo<0) {
                activo = false;
            }

            //Calculando código.
            while (activo) {
                int codigo = 0;
                int numeroBase = 1;
                int totalP = arriba + abajo;
                for (int i = 1; i <= totalP; i++) {
                    numeroBase += i;
                }
                codigo = numeroBase + arriba;
                System.out.println("Código:" + codigo);
                activo = false;
                seguir = false;
            }
        }

        Scanner.close();
    }
}
