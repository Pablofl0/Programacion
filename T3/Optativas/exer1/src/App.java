import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Estableciendo el tamaño del tablero.
        System.out.println("Indica el tamaño del tablero: ");
        int tamaño = scanner.nextInt();

        // Creando tablero.
        int tablero[][] = new int[tamaño][tamaño];

        // Asignando las minas(tantas como el número de filas del tablero) de manera
        // aleatoria.
        Random random = new Random();
        for (int i = 0; i < tablero.length + 1; i++) {
            int filaAleatoria = random.nextInt(0, tablero.length);
            int columnaAleatoria = random.nextInt(0, tablero.length);
            tablero[columnaAleatoria][filaAleatoria] = 1;
        }

        // Creando bucle de juego.
        boolean enjuego = true;
        boolean pedir = false;
        boolean ganar = true;
        boolean revelar = true;
        while (enjuego) {
            while (pedir) {
                // Pidiendo destapar celda o marcar bomba.
                System.out.println("Elige una de las siguientes opciones: ");
                System.out.println("\t1)Revelar celdas.");
                System.out.println("\t2)Marcar bomba.");
                int opcion = scanner.nextInt();
                if (opcion == 1) {
                    revelar = true;
                }
                else if (opcion == 2) {
                    revelar = false;
                }
                // Pidiendo fila y columna al jugador.
                System.out.println("F: ");
                int filaJugador = scanner.nextInt();
                System.out.println("C: ");
                int columnaJugador = scanner.nextInt();

                if (revelar) {
                    // Modificando tablero por "detrás".
                    if (tablero[columnaJugador][filaJugador] == 1) {
                        tablero[columnaJugador][filaJugador] = 2;
                        enjuego = false;
                    } else if (tablero[columnaJugador][filaJugador] == 0) {
                        tablero[columnaJugador][filaJugador] = 3;
                    }
                }
                else if (!revelar) {
                    tablero[columnaJugador][filaJugador] = 4;
                }
                pedir = false;
            }

            // Habilitando la petición al jugador.
            pedir = true;

            // Mostrando tablero.
            System.out.print("   ");
            for (int i = 0; i < tamaño; i++) {
                System.out.print("C" + i + " ");
            }
            System.out.println();
            for (int i = 0; i < tamaño; i++) {
                System.out.print("F" + (i) + " ");
                // "-"=sin destapar, "X"=bomba, "0"=vacío
                for (int j = 0; j < tamaño; j++) {
                    if (tablero[j][i] == 0) {
                        System.out.print("-  ");
                        ganar = false;
                    } else if (tablero[j][i] == 1) {
                        System.out.print("-  ");
                    } else if (tablero[j][i] == 2) {
                        System.out.print("X  ");
                    } else if (tablero[j][i] == 4) {
                        System.out.println("B  ");
                    } else if (tablero[j][i] == 3) {
                        int bombas = 0;
                        // Evitando la fila -1.
                        int k = i - 1;
                        int kmax = i + 2;
                        if (k < 0) {
                            k = 0;
                        } else if (k == tamaño - 2) {
                            kmax = tamaño;
                        }
                        // Evitando la columna tamaño+1.
                        int l = j - 1;
                        int lmax = j + 2;
                        if (l < 0) {
                            l = 0;
                        } else if (l == tamaño - 2) {
                            lmax = tamaño;
                        }
                        int auxiliar = l;
                        // Calculando el número de bombas alrededor de la celda.
                        while (k < kmax) {
                            while (l < lmax) {
                                if (tablero[l][k] == 1 || tablero[l][k] == 4) {
                                    bombas++;
                                }
                                l++;
                            }
                            l = auxiliar;
                            k++;
                        }
                        System.out.print(bombas + "  ");
                    }
                }
                System.out.println();
            }
        }

        for (int index = 0; index < tablero.length; index++) {
            for (int i = 0; i < tablero.length; i++) {
                System.out.print(tablero[i][index]);
            }
            System.out.println();
        }

        if (!ganar) {
            // Derrota.
            if (!enjuego) {
                System.out.println("¡Has perdido!");
            }
        }
        // Victoria.
        else if (ganar) {
            System.out.println("¡Has ganado!");
        }

        scanner.close();
    }
}
