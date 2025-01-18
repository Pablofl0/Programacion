import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Número de pasajeros en la parte superior: ");
        int arriba = Scanner.nextInt();
        System.out.println("Número de pasajeros en la parte inferior: ");
        int abajo = Scanner.nextInt();

        int datos[][] = new int[4][4];

        int limite = 0;
        int variable = 1;
        while (limite<datos.length) {
            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos.length; j++) {
                    if (i+j == limite) {
                        datos[i][j] = variable;
                        variable++;
                    }
                }
            }
            limite++;
        }

        System.out.println("Código:" + datos[arriba][abajo]);
   
        Scanner.close();
    }
}
