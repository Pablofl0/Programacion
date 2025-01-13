import java.util.Scanner;
import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Integer numero = scanner.nextInt();


        Double raiz = (Math.pow(numero, (1/2)));

        if (numero==2 || numero==3 || numero==5 || numero==7) {
            System.out.println("Primo.");
        }
        else if (numero%2!=0 && numero%3!=0 && numero%5!=0 && numero%7!=0 && (raiz.getClass()!=double.class)) {
            System.out.println("Primo.");
        }
        else {
            System.out.println("No primo.");
        }


        scanner.close();
    }
}
