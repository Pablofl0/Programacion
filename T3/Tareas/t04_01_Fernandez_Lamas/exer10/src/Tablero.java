import java.util.Scanner;

public class Tablero {
    Scanner scanner = new Scanner(System.in);
    private int[][] tablero;
    private boolean jugador;
    private boolean enjuego = true;
    private int fila;
    private int columna;
    private int estado = 0;


    public Tablero() {
        tablero = new int[3][3];
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isEnjuego() {
        return enjuego;
    }

    public void pedir() {
        while (true) {
            System.out.print("Fila: ");
            fila = scanner.nextInt();
            System.out.print("Columna: ");
            columna = scanner.nextInt();
            if (fila < tablero.length && fila >= 0 && columna < tablero.length && columna >= 0) {
                if (tablero[columna][fila]  == 0) {
                    modificar(fila, columna);
                    break;
                }              
            }         
        }
    }

    public void mostrar() {
        System.out.println("   C0 C1 C2");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("F" + (i) + " ");
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
            int multi = 1;
            for (int j = 0; j < tablero.length; j++) {
                multi *= tablero[j][i];
            }
            if (multi == 0) {
                estado = -1;
            }
        }

        for (int i = 0; i < tablero.length; i++) {
            int sumafila = 0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[j][i] == 2) {
                    sumafila += -1;
                } else {
                    sumafila += tablero[j][i];
                }
                if (sumafila == 3) {
                    estado = 1;
                    enjuego = !enjuego;
                    break;
                } else if (sumafila == -3) {
                    estado = 2;
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
                    estado = 1;
                    enjuego = !enjuego;
                    break;
                } else if (sumacol == -3) {
                    estado = 2;
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
            estado = 1;
            enjuego = !enjuego;
        } else if (sumadiagonal == -3) {
            estado = 2;
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
            estado = 1;
            enjuego = !enjuego;
        } else if (sumadiagonal2 == -3) {
            estado = 2;
            enjuego = !enjuego;
        }

    }

    public void estado(){
        if (estado == 0) {
            System.out.println("¡Empate!");
        }
        else if (estado == 1) {
            System.out.println("Ha ganado el jugador 1(X).");
        }
        else if (estado == 2) {
            System.out.println("Ha ganado el jugador 2(O).");
        }
    }

}
