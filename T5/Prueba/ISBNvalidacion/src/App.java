public class App {
    public static void main(String[] args) throws Exception {
        String numeros = "123456789";

        int sumatorio = 0;
        for (int i = 0; i < numeros.length(); i++) {
            sumatorio += ((i+1) * Integer.valueOf(numeros.substring(i, i+1)));
            System.out.println(sumatorio);
            System.out.println(sumatorio % 11);
        }
    }
}
