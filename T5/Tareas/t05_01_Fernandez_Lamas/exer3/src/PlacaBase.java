public class PlacaBase extends Componente{
    private Zocalo zocalo;

    public PlacaBase(String marca, String modelo, double precio, Zocalo zocalo) {
        super(marca, modelo, precio);
        this.zocalo = zocalo;
    }

    @Override
    public String toString() {
        return "Placa Base" + super.toString() + " con socket " + this.zocalo;
        }
}
