import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int numEstudiantes = scanner.nextInt();
        int numModulos = scanner.nextInt();

        double notas[][] = new double[numModulos][numEstudiantes];

        for (int i = 0; i < numEstudiantes; i++) {
            for (int j = 0; j < numModulos; j++) {
                double nota = scanner.nextInt();
                notas[j][i] = nota;
            }
        }


        boolean seguir = true;
        while (seguir) {
            System.out.println("Elige una opción:");
            System.out.println("\ta)Media de las notas de un alumno.");
            System.out.println("\tb)Porcentaje de aprobados del módulo.");
            System.out.println("\tc)Salir.");
            String opcion = scanner.next();

            switch (opcion) {
                case "a":
                    System.out.println("Indica el índice del alumno:");
                    int indiceAlumno = scanner.nextInt();
                    double sumaAlumno = 0;
                    for (int j = 0; j < numModulos; j++) {
                        sumaAlumno += notas[j][indiceAlumno];
                    }
                    double media = sumaAlumno/numModulos;
                    System.out.println(media);
                    break;
                case "b":
                    System.out.println("Indica el índice del módulo:");
                    int indiceModulo = scanner.nextInt();
                    int aprobados = 0;
                    for (int i = 0; i < numEstudiantes; i++) {
                        if (notas[indiceModulo][i]>=5.0){
                            aprobados++;
                        }
                    }
                    double porcentaje = (aprobados/numEstudiantes)*100;
                    System.out.println(porcentaje + "%");
                    break;
                case "c":
                    seguir = false;
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
            
        }
        scanner.close();
        
    }
}
