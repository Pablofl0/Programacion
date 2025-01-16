import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner =new Scanner(System.in);


        Integer seg = scanner.nextInt();
        
        Integer horas = (seg/3600);
        
        Integer minutos = ((seg%3600) /60);
        
        Integer segRestantes = ((seg%3600)%60);
        



        System.out.println(horas + " hora/s.");
        System.out.println(minutos + " minuto/s");
        System.out.println(segRestantes + " segundo/s");

        scanner.close();
    }
}
