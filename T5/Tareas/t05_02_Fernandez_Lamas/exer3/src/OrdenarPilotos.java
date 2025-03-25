import java.util.Comparator;

public class OrdenarPilotos implements Comparator<Piloto>{

    @Override
    public int compare(Piloto ob1, Piloto ob2) {
        return Double.compare(ob2.getPuntos(), ob1.getPuntos());
    }
    
}