import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Estableciendo el tamaño del tablero.
        int tamaño = 1;
        while (tamaño <= 1) {
            System.out.println("Indica el tamaño del tablero: ");
            tamaño = scanner.nextInt();
        }

        // Creando tablero de "detrás".
        int tablero[][] = new int[tamaño][tamaño];
        // Creando tabla de muestra.
        int tmuestra[][] = new int[tamaño][tamaño];

        // Inicializando variables para el reparto de minas.
        Random random = new Random();
        int minasPuestas = 0;

        // Creando bucle de juego.
        boolean leer = false;
        boolean crear = false;
        boolean enjuego = true;
        boolean pedir = false;
        boolean ganar = true;
        boolean elegir = true;
        int revelar = 0;
        while (enjuego) {
            while (pedir) {
                while (elegir) {
                    // Pidiendo destapar celda o marcar bomba.
                    System.out.println("Elige una de las siguientes opciones: ");
                    System.out.println("\t1)Revelar celdas.");
                    System.out.println("\t2)Marcar bomba.");
                    int opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            revelar = 1;
                            elegir = false;
                            break;
                        case 2:
                            revelar = 2;
                            elegir = false;
                            break;
                        default:
                            break;
                    }
                }
                elegir = true;

                // Pidiendo fila y columna al jugador.
                int filaJugador = -1;
                int columnaJugador = -1;
                // Mientras el valor no sea válido sigue pidiendo la fila.
                while (filaJugador < 0 || filaJugador >= tablero.length) {
                    System.out.print("F: ");
                    filaJugador = scanner.nextInt();
                }
                // Mientras el valor no sea válido sigue pidiendo la columna.
                while (columnaJugador < 0 || columnaJugador >= tablero.length) {
                    System.out.print("C: ");
                    columnaJugador = scanner.nextInt();
                }

                // Asignando las minas(tantas como el número de filas del tablero) de manera
                // aleatoria después de revelar la primera casilla.
                while (minasPuestas < tablero.length) {
                    int filaAleatoria = random.nextInt(0, tablero.length);
                    int columnaAleatoria = random.nextInt(0, tablero.length);
                    if (tablero[columnaAleatoria][filaAleatoria] != -2
                            && (columnaAleatoria != columnaJugador || filaAleatoria != filaJugador)) {
                        tablero[columnaAleatoria][filaAleatoria] = -2;
                        minasPuestas++;
                    }
                    crear = true;
                }

                // Mostrando tabla de "detrás".
                for (int index = 0; index < tablero.length; index++) {
                    for (int i = 0; i < tablero.length; i++) {
                        System.out.print(tablero[i][index]);
                    }
                    System.out.println();
                }
                //
                // Mostrando tabla de muestra.
                for (int index = 0; index < tmuestra.length; index++) {
                    for (int i = 0; i < tmuestra.length; i++) {
                        System.out.print(tmuestra[i][index]);
                    }
                    System.out.println();
                }

                // Rellenando tablero por detrás y creando tablero auxiliar.
                while (crear) {
                    // Construyendo tablero de detrás con las minas y las bombas que tiene cada
                    // casilla alrededor.
                    for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero.length; j++) {
                            if (tablero[j][i] == 0) {
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
                                        if (tablero[l][k] == -2) {
                                            bombas++;
                                        }
                                        l++;
                                    }
                                    l = auxiliar;
                                    k++;
                                }
                                if (bombas == 0) {
                                    tablero[j][i] = -3;
                                } else {
                                    tablero[j][i] = bombas;
                                }
                            }
                        }
                    }
                    crear = false;
                }

                // Modificando tablero por "detrás".
                if (revelar == 1) {
                    // Revelas en una bomba(1); te explota(2) y pierdes.
                    if (tablero[columnaJugador][filaJugador] == -2) {
                        tmuestra[columnaJugador][filaJugador] = tablero[columnaJugador][filaJugador];
                        ganar = false;
                        enjuego = false;
                        leer = false;
                    }
                    // Revelas una casilla vacía(0), te indica cuantas bombas hay alrededor(3).
                    else if (tablero[columnaJugador][filaJugador] == -3) {
                        leer = true;
                        tmuestra[columnaJugador][filaJugador] = tablero[columnaJugador][filaJugador];
                    } else {
                        leer = true;
                        tmuestra[columnaJugador][filaJugador] = tablero[columnaJugador][filaJugador];
                    }
                }
                // Marcando una bomba.
                else if (revelar == 2) {
                    // Desmarcando bomba(quitando B) y recuperando valor primitivo con tablero
                    // auxiliar.
                    if (tmuestra[columnaJugador][filaJugador] == -1) {
                        tmuestra[columnaJugador][filaJugador] = 0;
                    } else if (tmuestra[columnaJugador][filaJugador] == 0) {
                        tmuestra[columnaJugador][filaJugador] = -1;
                    }
                }
                // El jugador escoge una casilla válida y se para el bucle.
                pedir = false;
            }

            // Comprobando si ya no hay más huecos sin bomba por abrir y desvelando casillas
            // en cadena.
            while (leer) {
                leer = false;
                enjuego = false;
                for (int i = 0; i < tmuestra.length; i++) {
                    for (int j = 0; j < tmuestra.length; j++) {
                        if (tmuestra[j][i] == -3) {
                            tmuestra[j][i] = -5;
                            tablero[j][i] = -5;
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
                                    if (tablero[l][k] == -3) {
                                        leer = true;
                                        tmuestra[l][k] = tablero[l][k];
                                    } else {
                                        tmuestra[l][k] = tablero[l][k];
                                    }
                                    l++;
                                }
                                l = auxiliar;
                                k++;
                            }
                        }
                        // Comprobando si hay ganador.
                        if (tmuestra[j][i] == 0 && tablero[j][i] != -2) {
                            enjuego = true;
                        }
                    }
                }
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
                    if (tmuestra[j][i] == 0) {
                        System.out.print("-  ");
                    } else if (tmuestra[j][i] == -5) {
                        System.out.print("0  ");
                    } else if (tmuestra[j][i] == -2) {
                        System.out.print("X  ");
                    } else if (tmuestra[j][i] == -1) {
                        System.out.print("B  ");
                    } else {
                        System.out.print(tmuestra[j][i] + "  ");
                    }
                }
                System.out.println();
            }
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
