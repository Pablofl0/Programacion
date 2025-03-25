public class Tenista extends Deportista{
    private int ranking;

    /**
     * Construtor de tenista
     * @param nomeCompleto do tenista
     * @param nomeDeportivo do tenista
     * @param dataNacemento do tenista no formato dd/MM/yyyy
     * @param ranking mundial do tenista
     */
    public Tenista(String nomeCompleto, String nomeDeportivo, String dataNacemento, int ranking) {
        super(nomeCompleto, nomeDeportivo, dataNacemento);
        this.setRanking(ranking);
    }

    @Override
    public String toString(){
        return super.toString() + " Nº " + this.ranking + " do mundo.";
    }


    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
 
}