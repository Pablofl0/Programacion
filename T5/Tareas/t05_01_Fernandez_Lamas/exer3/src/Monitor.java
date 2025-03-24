public class Monitor extends Periferico{
    private double pulgadas;

    public Monitor(String marca, String modelo, double precio, double pulgadas) {
        super(marca, modelo, precio);
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return "Monitor " + super.toString() + " con " + this.pulgadas + " pulgadas y conectores: " + this.getConectoresString();
    }

    
}
