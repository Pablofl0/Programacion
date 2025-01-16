import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Integer numero1 = scanner.nextInt();
        Integer numero2 = scanner.nextInt();
        Integer numero3 = scanner.nextInt();

        Integer primero;
        Integer segundo;
        Integer tercero;

        if (numero1<numero2 && numero1<numero3) {
            primero = numero1;
            if (numero2<numero3) {
                segundo = numero2;
                tercero = numero3;
            }
            else {
                segundo = numero3;
                tercero = numero2;
            }
        }
        else if (numero2<numero1 && numero2<numero3) {
            primero = numero2;
            if (numero1<numero3) {
                segundo = numero1;
                tercero = numero3;
            }
            else {
                segundo = numero3;
                tercero = numero1;
            }
        }
        else {
            primero = numero3;
            if (numero1<numero2) {
                segundo = numero1;
                tercero = numero2;
            }
            else {
                segundo = numero2;
                tercero = numero1;
            }
        }


        System.out.println(primero);
        System.out.println(segundo);
        System.out.println(tercero);

        scanner.close();
    }
}
