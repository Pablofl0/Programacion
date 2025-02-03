import dawutils.Calculadora;

public class App {
    public static void main(String[] args) throws Exception {      
        
        // Realizamos a suma e imprimimos o seu resultado
        Calculadora.sumar(6.0, 7.0);
        System.out.println(Calculadora.getMemoria());

        // Realizamos a multiplicacion e mostramolo por pantalla
        double multiplicacion = Calculadora.multiplica(5, Calculadora.getMemoria());
        System.out.println((multiplicacion));

        // Realizamos a potencia
        double potencia = Calculadora.potencia(5, 6);
        System.out.println(potencia);


    }

}