public class Teclado extends Periferico{

    public Teclado(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public String toString() {
        return "Teclado " + super.toString() + " con conectores: " + this.getConectoresString();

    }


    
}
