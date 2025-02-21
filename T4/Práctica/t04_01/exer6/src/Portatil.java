public class Portatil {
    private String modelo;
    private String numSerie;
    private Cor cor;

    /**
     * Construtor de Portátil
     * @param modelo do partatil
     * @param numSerie do protatil
     * @param cor cor do protatil
     */
    public Portatil(String modelo, String numSerie, Cor cor) {
        this.setModelo(modelo);
        this.setNumSerie(numSerie);
        this.setCor(cor);
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public Cor getCor() {
        return cor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
    
}
