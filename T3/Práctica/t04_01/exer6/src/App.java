public class App {
    public static void main(String[] args) throws Exception {    
        
        Portatil portatil = new Portatil("iMac", "176234A", Cor.VERDE);

        String mensaxe = portatil.getModelo() + ", " + portatil.getCor().getNomeCor() + ": " + portatil.getNumSerie();
        System.out.println(mensaxe);

        portatil.setCor(Cor.NEGRO);

        mensaxe = portatil.getModelo() + ", " + portatil.getCor().getNomeCor() + ": " + portatil.getNumSerie();
        System.out.println(mensaxe);
        
    }

}