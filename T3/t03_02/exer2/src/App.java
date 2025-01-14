import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int lista [] = {3,5,7,2,9};

        Integer indice = scanner.nextInt();

        if (indice<0 || indice>=lista.length) {
            System.out.println("Error.");
        }

        


        System.out.println("Hello, World!");


        scanner.close();
    }
}
