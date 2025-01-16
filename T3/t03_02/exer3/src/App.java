import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int columnas = scanner.nextInt();
        int filas = scanner.nextInt();
        

        int matriz[][] = new int [columnas][filas];

        for (int j = 0; j < columnas; j++){
            for (int i = 0; i < filas; i++) {
                int valorColumna = scanner.nextInt();
                matriz[j][i] = valorColumna;
            }
        }

        

        for (int j = 0; j < columnas; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < filas; i++) {
                sumaColumna += matriz[j][i];
            }
            System.out.println(sumaColumna);
        }
        
        

        for (int i = 0; i < filas; i++) {
            int sumaFila = 0;
            for (int j = 0; j < columnas; j++) {
                sumaFila += matriz[j][i];
            }
            System.out.println(sumaFila);
        }

        

        scanner.close();
    }
}
