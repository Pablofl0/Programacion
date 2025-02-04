public class Tablero {
    private int[][] tablero;

    public Tablero() {
        tablero = new int[3][3];
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
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }
    }

    private void modificar(int fila,int columna){
        if (jugador) {
            String valor = ;
        }
        else{
            String valor = "O";
        }
    }

}
