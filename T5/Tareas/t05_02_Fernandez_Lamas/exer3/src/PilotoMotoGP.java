public class PilotoMotoGP extends Piloto{
    private double puntos;

    /**
     * 
     * @param nomeCompleto do piloto de MotoGP
     * @param nomeDeportivo do piloto de MotoGP
     * @param dataNacemento do piloto de MotoGP no formato dd/MM/yyyy
     * @param nomeEquipo do piloto de MotoGP
     * @param puntos do piloto de MotoGP
     */
    public PilotoMotoGP(String nomeCompleto, String nomeDeportivo, String dataNacemento, String nomeEquipo, double puntos) {
        super(nomeCompleto, nomeDeportivo, dataNacemento, nomeEquipo);
        this.puntos = puntos;
    }

    public double getPuntos(){
        return this.puntos;
    }
    
}