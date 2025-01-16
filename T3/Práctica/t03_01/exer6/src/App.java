import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Integer num = scanner.nextInt();
        String dia = "";
        
        switch (num) {
            case 1:
                dia = "Lunes";
                break;
            case 2:
                dia = "Martes";
                break;
            case 3:
                dia = "Miércoles";
                break;
            case 4:
                dia = "Jueves";
                break;
            case 5:
                dia = "Viernes";
                break;
            case 6:
                dia = "Sábado";
                break;
            case 7:
                dia = "Domingo";
                break;
            default:
                System.out.println("Fuera de rango");
                break;
        
        }
        System.out.println(dia);

        scanner.close();
    }
}
