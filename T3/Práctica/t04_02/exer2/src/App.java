import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Period;

public class App {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // Collemos os datos
        System.out.print("Engade o dia de nacemento no formato dd-mm-yyyy: ");
        String diaText = sc.nextLine();

        // Formato
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Creamos o obxecto dia
        LocalDate nacemento = LocalDate.parse(diaText, formato);

        // Collemos o díua de hoxe
        LocalDate agora = LocalDate.now();

        // Collemos a diferencia de dias e imprimimos a idade
        Period periodo = Period.between(nacemento, agora);
        System.out.println("Idade: " + periodo.getYears());

        // Collemos o cumporeanos neste ano
        int anoActual = agora.getYear();
        String cumpreText = diaText.substring(0, 5) + "-" + anoActual;
        LocalDate cumpreanos = LocalDate.parse(cumpreText, formato);

        // Miramos se xa foi o se pasou, inda falta ou e hoxe e collemos o proximo cumple
        LocalDate proximoCumple;
        if (cumpreanos.isBefore(agora)) {
            Period periodoCumpre = Period.between(cumpreanos, agora);
            System.out.println("O cumpreanos fai " + periodoCumpre.getMonths() + " dias que pasou");
            // Collemos enton o cumple do ano seguinte
            proximoCumple = cumpreanos.plus(1, ChronoUnit.YEARS);
        }
        else if (cumpreanos.isAfter(agora)) {
            Period periodoCumpre = Period.between(cumpreanos, agora);
            System.out.println("Faltan " + ChronoUnit.DAYS.between(cumpreanos, agora) + " dias para o cumpreanos");
            // O proximo cumpre e o actual
            proximoCumple = cumpreanos;
        }
        else {
            System.out.println("O teu cumpreanos é hoxe");
            // Collemos enton o cumple do ano seguinte
            proximoCumple = cumpreanos.plus(1, ChronoUnit.YEARS);
        }

        // imprimimos o dia da semana do proximo cumpreanos
        System.out.println(proximoCumple.getDayOfWeek());

        sc.close();
    }
}
