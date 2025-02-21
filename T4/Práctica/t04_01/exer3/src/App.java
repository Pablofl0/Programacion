public class App {
    public static void main(String[] args) throws Exception {
        Rectangulo rec1 = new Rectangulo(7.5, 3);
        Rectangulo rec2 = new Rectangulo(10, 5);

        System.out.println(rec1.perimetro());
        System.out.println(rec1.area());
        System.out.println(rec2.perimetro());
        System.out.println(rec2.area());


    }
}
