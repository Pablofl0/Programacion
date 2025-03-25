public abstract class Piloto extends Deportista {
    private String nomeEquipo;

    /**
     * 
     * @param nomeCompleto do piloto
     * @param nomeDeportivo do piloto
     * @param dataNacemento do piloto no formato dd/MM/yyyy
     * @param nomeEquipo do piloto
     */
    public Piloto(String nomeCompleto, String nomeDeportivo, String dataNacemento, String nomeEquipo) {
        super(nomeCompleto, nomeDeportivo, dataNacemento);
        this.setNomeEquipo(nomeEquipo);
    }

    /**
     * Devolve o número de puntos do piloto
     * @return os puntos do piloto
     */
    abstract double getPuntos();

    @Override
    public String toString(){
        return super.toString() + " Equipo: " + this.nomeEquipo + " Puntos: " + this.getPuntos() + ".";
    }

    public String getNomeEquipo() {
        return nomeEquipo;
    }

    public void setNomeEquipo(String nomeEquipo) {
        this.nomeEquipo = nomeEquipo;
    }

}