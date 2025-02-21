import java.util.Scanner;
import java.util.ArrayList;


public class App {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        boolean activo = true;
        ArrayList<String> nomes = new ArrayList<>();

        //Menú
        while (activo) {
            System.out.println("Selecciona unha opción: ");
            System.out.println("\ta) Engadir un nome");
            System.out.println("\tb) Mostrar nomes");
            System.out.println("\tc) Eliminar nome");
            System.out.println("\tz) Sair do programa");
            System.out.print("\t> ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "a":
                    System.out.println("Introduce un nome: ");
                    String nome = sc.nextLine();
                    nomes.add(nome);                
                    break;
                
                case "b":
                    System.out.println("Lista de nomes: ");
                    for(String nomeLista: nomes) {
                        System.out.println("\t- " + nomeLista);
                    }
                    break;
                case "c":
                    System.out.println("Selecciona un nome: ");
                    for(int i=0; i < nomes.size(); i++) {
                        System.out.println("\t- " + i + ") " + nomes.get(i));
                    }
                    System.out.print("\t> ");
                    int indiceEliminar = sc.nextInt();
                    if (indiceEliminar >= 0 && indiceEliminar < nomes.size()){
                        nomes.remove(indiceEliminar);
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
