public class Tablero {
    private int[][] tablero;
    private boolean jugador;
    private boolean enjuego = true;

    public Tablero() {
        tablero = new int[3][3];
    }

    public boolean isEnjuego() {
        return enjuego;
    }

    public void mostrar() {
        System.out.println("   C1 C2 C3");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("F" + (i + 1) + " ");
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[j][i] == 0) {
                    System.out.print("-  ");
                } else if (tablero[j][i] == 1) {
                    System.out.print("X  ");
                } else if (tablero[j][i] == 2) {
                    System.out.print("O  ");
                }
            }
            System.out.println();
        }
    }

    public void modificar(int fila, int columna) {
        if (jugador) {
            tablero[columna][fila] = 1;
        } else {
            tablero[columna][fila] = 2;
        }
        jugador = !jugador;
    }

    public void comprobar() {

        for (int i = 0; i < tablero.length; i++) {
            int sumafila = 0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[j][i] == 2) {
                    sumafila += -1;
                } else {
                    sumafila += tablero[j][i];
                }
                if (sumafila == 3) {
                    System.out.println("Ganador jugador 1(X).");
                    enjuego = !enjuego;
                    break;
                } else if (sumafila == -3) {
                    System.out.println("Ganador jugador 2(O).");
                    enjuego = !enjuego;
                    break;
                }
            }
        }
        for (int j = 0; j < tablero.length; j++) {
            int sumacol = 0;
            for (int i = 0; i < tablero.length; i++) {
                if (tablero[j][i] == 2) {
                    sumacol += -1;
                } else {
                    sumacol += tablero[j][i];
                }
                if (sumacol == 3) {
                    System.out.println("Ganador jugador 1(X).");
                    enjuego = !enjuego;
                    break;
                } else if (sumacol == -3) {
                    System.out.println("Ganador jugador 2(O).");
                    enjuego = !enjuego;
                    break;
                }
            }
        }
        int i = 0;
        int sumadiagonal = 0;
        while (i < tablero.length) {
            if (tablero[i][i] == 2) {
                sumadiagonal += -1;
            } else {
                sumadiagonal += tablero[i][i];
            }
            i++;
        }
        if (sumadiagonal == 3) {
            System.out.println("Ganador jugador 1(X).");
            enjuego = !enjuego;
        } else if (sumadiagonal == -3) {
            System.out.println("Ganador jugador 2(O).");
            enjuego = !enjuego;
        }
        int a = 0;
        int b = 2;
        int sumadiagonal2 = 0;
        while (a < tablero.length) {
            if (tablero[b][a] == 2) {
                sumadiagonal2 += -1;
            } else {
                sumadiagonal2 += tablero[b][a];
            }
            a++;
            b--;
        }
        if (sumadiagonal2 == 3) {
            System.out.println("Ganador jugador 1(X).");
            enjuego = !enjuego;
        } else if (sumadiagonal2 == -3) {
            System.out.println("Ganador jugador 2(O).");
            enjuego = !enjuego;
        }

    }
}
