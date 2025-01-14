import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int lista [] = {3,5,7,2,9};

        

        while (lista.length>0) {
            Integer indice = scanner.nextInt();


            if (indice<0 || indice>=lista.length) {
                System.out.println("Error.");
                continue;
            }
            
            int longitud = (lista.length-1);
            int listaNueva [] = new int[longitud];
            int j = 0;

            for (int i = 0; i < lista.length; i++) {
                
                if (i!= indice){
                    listaNueva[j] = lista[i];
                    j++;
                }
                
                
            }
            System.out.println(lista[indice]);


            lista = listaNueva;
        }
        


        scanner.close();
    }
}
