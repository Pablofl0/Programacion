public class MemoriaRam extends Componente{
    private long memoriaBytesLong;
    private long velocidadMemoriaHzLong;

    

    public MemoriaRam(String marca, String modelo, double precio, double velocidadMemoriaGz, double memoriaGB) {
        super(marca, modelo, precio);
        this.memoriaBytesLong = gigaBytesToBytes(memoriaGB);
        this.velocidadMemoriaHzLong = gigaHzToHz(velocidadMemoriaGz);
    }

    public double getMemoriaBytesLong() {
        return bytesToGigaBytes(memoriaBytesLong);
    }

    public double getVelocidadMemoriaHzLong() {
        return hzToMhz(velocidadMemoriaHzLong);
    }

    @Override
    public String toString() {
        return "Memoria RAM " + super.toString() + " con " + this.memoriaBytesLong + " GB y velocidad " + this.velocidadMemoriaHzLong + " MHz";
    }

    
    
}
