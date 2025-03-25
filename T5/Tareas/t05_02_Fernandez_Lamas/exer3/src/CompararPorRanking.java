import java.util.Comparator;

public class CompararPorRanking implements Comparator<Tenista>{

    @Override
    public int compare(Tenista ob1, Tenista ob2) {
        return ((ob1.getRanking()) - (ob2.getRanking()));
    }
    
}