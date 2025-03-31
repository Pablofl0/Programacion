import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    private Scanner scanner;

    /**
     * Construtor de menú
     */
    public Menu(){
        scanner = new Scanner(System.in);
    }

    /**
     * Método abstracto, que é necesario implantar para mostrar por terminal
     */
    protected abstract void mostrar();

    /**
     * Pide por teclado unha cadea de texto
     * @param frase que se mostra ao usuario
     * @return
     */
    protected String getString(String frase) {
        System.out.print(frase);
        String mensaxe = this.scanner.nextLine();
        return mensaxe;
    }

    /**
     * Pide por teclado un double
     * @param frase que se mostra ao usuario
     * @return
     */
    protected double getDouble(String frase) {
        System.out.print(frase);
        double mensaxe = this.scanner.nextDouble();
        return mensaxe;
    }

    /**
     * Pie por teclado unha frase
     * @param frase que se mostra ao usuario
     * @return
     */
    protected int getInt(String frase) {
        System.out.print(frase);
        int mensaxe = this.scanner.nextInt();
        this.scanner.nextLine(); // Limpiar buffer
        return mensaxe;
    }

    /**
     * Imprime unha frase por pantalla engadindo unha nova liña
     * @param frase
     */
    protected static void printMessage(String frase) {
        System.out.println(frase);
    }

    /**
     * Imprime unha lista de elementos
     * @param <T> Clase xenérica para poder realizalo cunha lista de calquera tipo
     * @param lista
     */
    protected <T> void printList(List<T> lista) {
        for(T elemento: lista) {
            printMessage(elemento.toString());
        }
    }


}