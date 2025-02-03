package dawutils;

public class Calculadora {
    private static double ultimoResultado;

    /**
     * Realiza a suma de dous números e almacena en memoria
     * @param a
     * @param b
     */
    public static void sumar(double a, double b) {
        Calculadora.ultimoResultado = a + b;
    }

    /**
     * MUltiplica dous números
     * @param a
     * @param b
     * @return o resultado da multiplicación
     */
    public static double multiplica(double a, double b) {
        Calculadora.ultimoResultado = a * b;
        return Calculadora.ultimoResultado;
    }

    /**
     * Calcula a potencia dun número
     * @param base a base
     * @param exp o expoñente
     * @return o resultado
     */
    public static int potencia(int base, int exp) {
        // Se o expoñente é 0, o resultado sempre é 1
        if (exp == 0) {
            Calculadora.ultimoResultado = 1.0;
            return 1;
        }
        // O expoñente e negativo
        else if (exp < 0) {
            // Neste caso 2^-4 por exemplo é igual a 1/(2^4)
            // Pasamos o expoñente a positivo
            exp = exp * (-1);

            // Calculamos a potencia
            int aux = 1;
            for(int i=1 ; i <= exp; i++) {
                aux = aux * base;
            }
            // necesitamos facer o 1/potencia
            Calculadora.ultimoResultado = 1 / aux;
            return 1 / aux;
        }
        else {
            // Calculamos a potencia
            int aux = 1;
            for(int i=1 ; i <= exp; i++) {
                aux = aux * base;
            }
            Calculadora.ultimoResultado = aux;
            return aux;
        }
    }

    /**
     * Devolve o ultimo resultado alamcenado na clase 
     * @return o número gardado en memoria
     */
    public static double getMemoria(){
        return Calculadora.ultimoResultado;
    }
}
