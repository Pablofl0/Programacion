import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Tablero tableroJuego = new Tablero();

        while (true) {
            tableroJuego.mostrar();

            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
    
            tableroJuego.modificar(fila, columna);

            tableroJuego.comprobar();

            if (!tableroJuego.isEnjuego()) {
                break;
            }
        }
       

        /**
         * int tablero[][] = new int[3][3];
        

        boolean enjuego = true;
        boolean jugador = true;
        


            while (true) {
                boolean empate = true;
                System.out.println("   C1 C2 C3");
                for (int i = 0; i < tablero.length; i++) {
                    System.out.print("F" + (i+1) + " ");
                    for (int j = 0; j < tablero.length; j++) {
                        if (tablero[j][i]==0) {
                            System.out.print("-  ");
                            empate=false;
                        }
                        else if (tablero[j][i]==1) {
                            System.out.print("X  ");
                        }
                        else if (tablero[j][i]==2) {
                            System.out.print("0  ");
                        }
                    }
                    System.out.println();
                }

                if (empate) {
                    System.out.println("¡Empate!");
                    enjuego = false;
                }

                if (enjuego==false){
                    break;
                }

                if (jugador) {
                    int columna1 = scanner.nextInt();
                    int fila1 = scanner.nextInt();
                    if (columna1<1 || columna1>3 || fila1<0 || fila1>3) {
                        System.out.println("Introduce una posición del tablero.");
                        continue;
                    }
                    else if (tablero[columna1-1][fila1-1]!=0){
                        System.out.println("Esa posición ya está ocupada.");
                        continue;
                    }
                    tablero[columna1-1][fila1-1]=1;
                    jugador=!jugador;
                }
                else {
                    int columna2 = scanner.nextInt();
                    int fila2 = scanner.nextInt();
                    if (columna2<1 || columna2>3 || fila2<0 || fila2>3) {
                        System.out.println("Introduce una posición del tablero.");
                        continue;
                    }
                    else if (tablero[columna2-1][fila2-1]!=0){
                        System.out.println("Esa posición ya está ocupada.");
                        continue;
                    }
                    tablero[columna2-1][fila2-1]=2;
                    jugador=!jugador;
                }
    
                while (true) {
                    for (int i = 0; i < tablero.length; i++) {
                        int sumafila = 0;
                        for (int j = 0; j < tablero.length; j++) {
                            if (tablero[j][i]==2){
                                sumafila+=-1;
                            }
                            else{
                                sumafila += tablero[j][i];
                            }
                            if (sumafila==3) {
                                System.out.println("Ganador jugador 1(X).");
                                enjuego=!enjuego;
                                break;
                            }
                            else if (sumafila==-3) {
                                System.out.println("Ganador jugador 2(0).");
                                enjuego=!enjuego;
                                break;
                            }
                        }
                    }
                    for (int j = 0; j < tablero.length; j++) {
                        int sumacol = 0;
                        for (int i = 0; i < tablero.length; i++) {
                            if (tablero[j][i]==2){
                                sumacol+=-1;
                            }
                            else{
                                sumacol += tablero[j][i];
                            }
                            if (sumacol==3) {
                                System.out.println("Ganador jugador 1(X).");
                                enjuego=!enjuego;
                                break;
                            }
                            else if (sumacol==-3) {
                                System.out.println("Ganador jugador 2(0).");
                                enjuego=!enjuego;
                                break;
                            }
                        }
                    }
                    int i = 0;
                    int sumadiagonal = 0;
                    while (i<tablero.length){
                        if (tablero[i][i]==2){
                            sumadiagonal+=-1;
                        }
                        else{
                            sumadiagonal += tablero[i][i];
                        }
                        i++;
                    }
                    if (sumadiagonal==3) {
                        System.out.println("Ganador jugador 1(X).");
                        enjuego=!enjuego;
                    }
                    else if (sumadiagonal==-3) {
                        System.out.println("Ganador jugador 2(0).");
                        enjuego=!enjuego;
                    }
                    int a = 0;
                    int b = 2;
                    int sumadiagonal2 = 0;
                    while (a<tablero.length){
                        if (tablero[b][a]==2){
                            sumadiagonal2+=-1;
                        }
                        else{
                            sumadiagonal2 += tablero[b][a];
                        }
                        a++;
                        b--;
                    }
                    if (sumadiagonal2==3) {
                        System.out.println("Ganador jugador 1(X).");
                        enjuego=!enjuego;
                    }
                    else if (sumadiagonal2==-3) {
                        System.out.println("Ganador jugador 2(0).");
                        enjuego=!enjuego;
                    }
                    break;
                }


                
        }
         */
        
    scanner.close();
    }
}
