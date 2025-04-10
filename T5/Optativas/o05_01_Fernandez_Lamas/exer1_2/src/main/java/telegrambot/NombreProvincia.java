package telegrambot;

public enum NombreProvincia {
    LUGO("Lugo"),
    CORUÑA("A Coruña"),
    PONTEVEDRA("Pontevedra"),
    OURENSE("Ourense");

    private String provincia;

    private NombreProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }
}
