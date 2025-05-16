package arbore;

import java.util.List;

/**
 * Hello world!
 */
public final class App {
    public static void main(String[] args) {
        ArboreBinariaBusca<Xogador> abb = new ArboreBinariaBusca<>();

        
        Xogador xog1 = new Xogador("Lionel Messi", 10);
        Xogador xog2 = new Xogador("Cristiano Ronaldo", 7);
        Xogador xog3 = new Xogador("Neymar Jr.",11);
        Xogador xog4 = new Xogador("Kylian Mbappé", 19);
        Xogador xog5 = new Xogador("Zlatan Ibrahimovic", 8);
        Xogador xog6 = new Xogador("Robert Lewandowski", 9);
        Xogador xog7 = new Xogador("Sergio Ramos", 4);
        Xogador xog8 = new Xogador("Kevin De Bruyne", 17);
        Xogador xog9 = new Xogador("Mohamed Salah", 21);
        Xogador xog10 = new Xogador("Erling Haaland", 99);


        abb.anhadirElemento(xog1);
        abb.anhadirElemento(xog2);
        abb.anhadirElemento(xog3);
        abb.anhadirElemento(xog4);
        abb.anhadirElemento(xog5);
        abb.anhadirElemento(xog6);
        abb.anhadirElemento(xog7);
        abb.anhadirElemento(xog8);
        abb.anhadirElemento(xog9);
        abb.anhadirElemento(xog10);

        List<Xogador> listaXogadores = abb.recorridoInOrde();
        for (Xogador xog : listaXogadores) {
            System.out.println(xog);
        }

        for (Xogador xogador : abb) {
            System.out.println(xogador);
        }
    }
}
