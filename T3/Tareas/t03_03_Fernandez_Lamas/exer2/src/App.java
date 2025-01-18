import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner Scanner = new Scanner(System.in);

        boolean seguir = true;
        while (seguir) {
            //Pidiendo número de pasajeros.
            System.out.println("Número de pasajeros en la parte superior: ");
            int arriba = Scanner.nextInt();
            System.out.println("Número de pasajeros en la parte inferior: ");
            int abajo = Scanner.nextInt();

            int datos[][] = new int[4][4];

            //Creando matriz con los posibles códigos de resultado.
            int limite = 0;
            int variable = 1;
            while (limite < datos.length) {
                for (int i = 0; i < datos.length; i++) {
                    for (int j = 0; j < datos.length; j++) {
                        if (i + j == limite) {
                            datos[i][j] = variable;
                            variable++;
                        }
                    }
                }
                limite++;
            }

            //Imprimiendo código.
            if (datos[arriba][abajo] == 0) {
                System.out.println("Número de pasajeros incorrectos.");
            }
            else{
                System.out.println("Código:" + datos[arriba][abajo]);
                seguir = false;
            }
        }

        Scanner.close();
    }
}
