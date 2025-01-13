import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Double precioManzana = 3.5;
        Double precioNaranja = 1.6;

        Scanner scanner = new Scanner(System.in);

        double kilosMan = scanner.nextDouble();
        double kilosNar = scanner.nextDouble();




        System.out.println((precioManzana * kilosMan) + (precioNaranja * kilosNar));
    }
}
