public class PilotoF1 extends Piloto{
    private int victorias;
    private int voltasRapidas;
    private int poles;
    private static final int puntuacionVictorias = 25;
    private static final int puntuacionVoltasRapidas = 1;
    private static final int puntuacionPoles = 5;

    /**
     * Construtor de piloto de F1
     * @param nomeCompleto do piloto de F1
     * @param nomeDeportivo do piloto de F1
     * @param dataNacemento do piloto de F1 no formato dd/MM/yyyy
     * @param nomeEquipo do piloto de F1
     * @param victorias do piloto de F1
     * @param voltasRapidas do piloto de F1
     * @param poles do piloto de F1
     */
    public PilotoF1(String nomeCompleto, String nomeDeportivo, String dataNacemento, String nomeEquipo, int victorias, int voltasRapidas, int poles) {
        super(nomeCompleto, nomeDeportivo, dataNacemento, nomeEquipo);
        this.setVictorias(victorias);
        this.setVoltasRapidas(voltasRapidas);
        this.setPoles(poles);
    }

    public double getPuntos(){
        return (double)
            (
                this.victorias * PilotoF1.puntuacionVictorias + 
                this.voltasRapidas * PilotoF1.puntuacionVoltasRapidas + 
                this.poles * PilotoF1.puntuacionPoles
            );
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getVoltasRapidas() {
        return voltasRapidas;
    }

    public void setVoltasRapidas(int voltasRapidas) {
        this.voltasRapidas = voltasRapidas;
    }

    public int getPoles() {
        return poles;
    }

    public void setPoles(int poles) {
        this.poles = poles;
    }

}