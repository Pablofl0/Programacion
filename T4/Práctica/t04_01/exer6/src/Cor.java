public enum Cor {
    NEGRO("Negro"),
    BRANCO("Branco"),
    AZUL("Azul"),
    VERMELLO("Vermello"),
    VERDE("Verde");

    private final String nomeCor;

    Cor(String nomeCor) {
        this.nomeCor = nomeCor;
    }

    public String getNomeCor() {
        return nomeCor;
    }
}
