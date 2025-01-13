import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        

        Scanner scanner = new Scanner(System.in);

        int edad = scanner.nextInt();    
        
        System.out.println(2025 - edad);

        scanner.close();
    }
}
