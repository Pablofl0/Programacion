import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class App {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // Collemos os datos
        System.out.print("Engade unha hora de comezo no formato HH:mm: ");
        String horaText = sc.nextLine();
        System.out.print("Engade os minutos de duración do programa: ");
        int duracion = sc.nextInt();

        // Formato
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");

        // Creamos a clase coa hora
        LocalTime hora = LocalTime.parse(horaText, formato);

        // Engadimos os minutos
        LocalTime horaFinalizacion = hora.plus(duracion, ChronoUnit.MINUTES);

        // Collemos a hora resultante en texto
        String horaFinalizacionText = horaFinalizacion.format(formato);

        // Imprimimos a hora
        System.out.println(horaFinalizacionText);

        sc.close();
    }
}