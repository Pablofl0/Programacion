import java.util.Scanner;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean activo = true;
        HashMap<String, ArrayList<LocalDateTime>> fichas = new HashMap<>();

        // Menú
        while (activo) {
            System.out.println("Selecciona unha opción: ");
            System.out.println("\ta) Fichar entrada/saída.");
            System.out.println("\tb) Comprobar salario.");
            System.out.println("\tz) Sair do programa");
            System.out.print("\t> ");
            String opcion = sc.nextLine();
            String DNI = new String();
            boolean pedir = true;

            switch (opcion) {
                case "a":
                    while (pedir) {
                        pedir = false;
                        System.out.print("Introduce el DNI: ");
                        DNI = sc.nextLine();
                        if (DNI.length() != 9) {
                            pedir = true;
                        }

                        // Collemos os números é a letra
                        String numeros = DNI.substring(0, 8);
                        char letra = DNI.charAt(8);

                        // Comprobamos que todolos dixitos son números
                        for (int i = 0; i < numeros.length(); i++) {
                            if (!((int) numeros.charAt(i) >= (int) '0' && (int) numeros.charAt(i) <= (int) '9')) {
                                pedir = true;
                            }
                        }

                        // Comprobamos que a letra sexa minúcula
                        if (!((int) letra >= (int) 'A' && (int) letra <= (int) 'Z')) {
                            pedir = true;
                        }

                        // Collemos os numeros como un enteiro
                        int numero = Integer.valueOf(numeros);

                        // Calculamos o resto
                        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
                        int resto = numero % letras.length();

                        // Collemos a letra real
                        char letraReal = letras.charAt(resto);

                        // Se as letras son diferentes
                        if (letra != letraReal) {
                            pedir = true;
                        }
                    }

                    if (fichas.containsKey(DNI)) {
                        fichas.get(DNI).add(LocalDateTime.now());
                    } else {
                        ArrayList<LocalDateTime> listavacia = new ArrayList<>();
                        fichas.put(DNI, listavacia);
                        fichas.get(DNI).add(LocalDateTime.now());
                    }
                    break;

                case "b":
                    while (true) {
                        System.out.println("Introduce un DNI: ");
                        DNI = sc.nextLine();
                        if (fichas.containsKey(DNI)) {
                            ArrayList<LocalDateTime> entradaSalida = fichas.get(DNI);
                            int i = 0;
                            int j = 1;
                            double salario = 0;
                            double eurosPorMinuto = 0.20;
                            while (j < entradaSalida.size()) {
                                salario += (ChronoUnit.MINUTES.between(entradaSalida.get(i), entradaSalida.get(j))
                                        * eurosPorMinuto);
                                i += 2;
                                j += 2;
                            }

                            String salariostr = String.valueOf(salario) + "0";
                            System.out.println("El salario de " + DNI + " es de " + salariostr + " euros.");
                            break;
                        }
                        else{
                            System.out.println("DNI no encontrado.");
                        }
                    }
                    break;

                case "z":
                    activo = false;
                    break;
                default:
                    System.out.println("Introduzca una opción válida");
                    break;
            }
        }

        sc.close();
    }
}
