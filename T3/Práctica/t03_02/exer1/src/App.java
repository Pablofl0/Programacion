import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Integer cantidad = scanner.nextInt();
        int lista [] = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            Integer numero = scanner.nextInt();
            lista[i] = numero;

        }

        for (int i = (cantidad-1); i >= 0 ; i--) {
            System.out.println(lista[i]);
        }
        

        scanner.close();
    }
}
