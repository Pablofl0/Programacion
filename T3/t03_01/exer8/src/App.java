import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Integer i = 0;
        Integer raiz;
        Integer numero = scanner.nextInt();


        while (true) {
            if (i*i <= numero) {
                i++;
            }
            else {
                raiz = i-1;
                break;
            }
        }

        System.out.println(raiz);

        scanner.close();

    }
}
