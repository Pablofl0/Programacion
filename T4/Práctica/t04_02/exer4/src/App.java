import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class App {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        boolean activo = true;
        HashMap<String, Double> produtos = new HashMap<>();

        //Menú
        while (activo) {
            System.out.println("Selecciona unha opción: ");
            System.out.println("\ta) Engadir produto");
            System.out.println("\tb) Eliminar produto");
            System.out.println("\tc) Mostrar produtos cun determinado prezo");
            System.out.println("\tz) Sair do programa");
            System.out.print("\t> ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "a":
                    System.out.print("Introduce o nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Introduce o prezo do produto ");
                    Double prezo = sc.nextDouble();
                    if (produtos.containsKey(nome)) {
                        System.out.println("O produto xa existe, desexa actualizar o prezo: s) si | n) non");
                        String actualizar = sc.nextLine();
                        if (actualizar == "s") {
                            produtos.put(nome, prezo);
                        }
                        else if (actualizar != "n") {
                            System.out.println("Introduciuse unha opción incorrecta, non se realizou ningunha operación.");
                        }
                    }
                    else {
                        produtos.put(nome, prezo);  
                    }       
                    break;

                case "b":
                    System.out.println("Selecciona un nome: ");
                    ArrayList<String> claves = new ArrayList<>(produtos.keySet());
                    for(int i=0; i < claves.size(); i++) {
                        System.out.println("\t- " + i + ") " + claves.get(i));
                    }
                    System.out.print("\t> ");
                    int indiceEliminar = sc.nextInt();
                    if (indiceEliminar >= && indiceEliminar < claves.size()){
                        produtos.remove(claves.get(indiceEliminar));
                    }
                    break;
                
                case "c":
                    System.out.print("Introduce un prezo máximo: ");
                    double prezoMaximo = sc.nextDouble();
                    System.out.print("Introduce un prezo minimo: ");
                    double prezoMinimo = sc.nextDouble();

                    for (Map.Entry<String, Double> entry : produtos.entrySet()) {
                        if (entry.getValue() >= prezoMinimo && entry.getValue() <= prezoMaximo) {
                            System.out.println(entry.getKey());
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