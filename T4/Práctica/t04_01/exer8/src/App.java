public class App {
    public static void main(String[] args) throws Exception {     
        
        // Creamos os cadrados
        Cadrado c1 = new Cadrado(9.3, UnidadeDistancia.KM);
        Cadrado c2 = new Cadrado(1.5);

        // Calculamos os perimetros
        System.out.println(c1.getPerimetro(UnidadeDistancia.DM));
        System.out.println(c2.getPerimetro(UnidadeDistancia.DM));

        // Calculamos as áreas
        System.out.println(c1.getArea(UnidadeDistancia.CM));
        System.out.println(c2.getArea(UnidadeDistancia.CM));

    }
}