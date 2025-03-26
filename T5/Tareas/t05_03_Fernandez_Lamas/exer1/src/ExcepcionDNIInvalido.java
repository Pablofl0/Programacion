public class ExcepcionDNIInvalido extends Exception{
    public ExcepcionDNIInvalido(String mensaje){
        super(mensaje);
    }

    public static boolean comprobarDNI(String DNI){
        if (DNI.length() != 9) {
            return false;
        }

        // Collemos os números é a letra
        String numeros = DNI.substring(0, 8);
        char letra = DNI.charAt(8);

        // Comprobamos que todolos dixitos son números
        for (int i = 0; i < numeros.length(); i++) {
            if (!((int) numeros.charAt(i) >= (int) '0' && (int) numeros.charAt(i) <= (int) '9')) {
                return false;
            }
        }

        // Comprobamos que a letra sexa minúcula
        if (!((int) letra >= (int) 'A' && (int) letra <= (int) 'Z')) {
            return false;
        }

        // Collemos os numeros como un enteiro
        int numero = Integer.parseInt(numeros);

        // Calculamos o resto
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numero % letras.length();

        // Collemos a letra real
        char letraReal = letras.charAt(resto);

        // Se as letras son diferentes
        if (letra != letraReal) {
            return false;
        }

        // Si todo está correcto que devuelva true.
        return true;
    }
}
