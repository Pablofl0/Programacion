import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<LocalDateTime> citas = new ArrayList<>();
        boolean activo = true;

        //Menú
        while (activo) {
            System.out.println("Selecciona una opción: ");
            System.out.println("\ta) Añadir cita.");
            System.out.println("\tb) Eliminar cita.");
            System.out.println("\tc) Seleccionar fecha.");
            System.out.println("\tz) Salir del programa.");
            System.out.print("\t> ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "a":
                    System.out.println("Introduzca su nombre: ");
                    String nombre = sc.nextLine();
                    boolean pedir = true;
                    LocalDateTime citafh = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
                    while (pedir) {
                        pedir = false;
                        System.out.println("Introduzca su cita (formato, HH:mm dd/MM/yyyy): ");
                        String cita = sc.nextLine();

                        citafh = LocalDateTime.parse(cita, formato);
            
                        
                        for (LocalDateTime localDateTime : citas) {
                            if (ChronoUnit.MINUTES.between(citafh, localDateTime) <= 30) {
                                pedir = true;
                                System.out.println("No se pudo realizar la cita.");
                            }
                            else if (citafh.getDayOfWeek().equals(DayOfWeek.SATURDAY) || citafh.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                                pedir = true;
                                System.out.println("No se pudo realizar la cita.");
                            }
                        }
                    }
                    
                    nombres.add(nombre);
                    citas.add(citafh);
                    
                    break;

                case "b":
                    System.out.println("Selecciona una cita (su índice): ");
                    for(int i=0; i < nombres.size(); i++) {
                        System.out.println("\t- " + i + ") " + nombres.get(i) + ": " + citas.get(i).format(formato2));
                    }
                    System.out.print("\t> ");
                    int indiceEliminar = sc.nextInt();
                    if (indiceEliminar >= 0 && indiceEliminar < nombres.size()){
                        nombres.remove(indiceEliminar);
                        citas.remove(indiceEliminar);
                    }
                    else{
                        System.out.println("Índice no válido.");
                    }
        
                    break;
                
                case "c":
                    System.out.println("Introduzca su cita (formato, dd-MM-yyyy): ");
                    String cita = sc.nextLine();

                    LocalDateTime citaf = LocalDateTime.parse(cita, formato3);

                    for (LocalDateTime localDateTime : citas) {
                        if (localDateTime.toLocalDate().equals(citaf)) {
                            System.out.println(localDateTime.toLocalTime().format(formato));
                        }
                    }

                    break;
                
                case "z":
                    activo = false;
                    break;
                default:
                    System.out.println("Introduza unha opción válida");
                    break;
            }
        }   
        
        sc.close();
    }
}
