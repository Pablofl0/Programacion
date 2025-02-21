public class App {
    public static void main(String[] args) throws Exception {
        Coche coche1 = new Coche("Seat", "Ibiza", "Rojo");
        Coche coche2 = new Coche("Seat", "León", "Negro", 3);

        System.out.println(coche1.getMarca() + " " + coche1.getModelo() + ": " + coche1.getColor() + "€");
        System.out.println(coche2.getMarca() + " " + coche2.getModelo() + ": " + coche2.getColor() + "€");

        coche2.setColor("Azul");

        System.out.println(coche2.getMarca() + " " + coche2.getModelo() + ": " + coche2.getColor());
    }
}
