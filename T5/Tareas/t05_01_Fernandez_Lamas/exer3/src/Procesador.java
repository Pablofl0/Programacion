public class Procesador extends Componente{
    private Zocalo zocalo;
    private int numeroCores;

    
    public Procesador(String marca, String modelo, double precio, Zocalo zocalo, int numeroCores) {
        super(marca, modelo, precio);
        this.zocalo = zocalo;
        this.numeroCores = numeroCores;
    }


    @Override
    public String toString() {
        return "Procesador" + super.toString() + " con " + numeroCores + " y socket " + this.zocalo;
    }
}
