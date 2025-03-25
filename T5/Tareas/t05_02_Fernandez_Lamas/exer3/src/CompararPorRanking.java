import java.util.Comparator;

public class CompararPorRanking implements Comparator<Tenista>{

    public int compare(Tenista ob1, Tenista ob2) {
        return ob1.getRanking().compareTo(ob2.getRanking());
    }
    
}