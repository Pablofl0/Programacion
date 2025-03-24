public class MemoriaRam extends Componente{
    private long memoriaBytesLong;
    private long velocidadMemoriaHzLong;

    

    public MemoriaRam(String marca, String modelo, double precio, long memoriaBytesLong, long velocidadMemoriaHzLong) {
        super(marca, modelo, precio);
        this.memoriaBytesLong = memoriaBytesLong;
        this.velocidadMemoriaHzLong = velocidadMemoriaHzLong;
    }

    public long getMemoriaBytesLong() {
        return memoriaBytesLong;
    }

    public long getVelocidadMemoriaHzLong() {
        return velocidadMemoriaHzLong;
    }

    @Override
    public String toString() {
        return "Memoria RAM " + super.toString() + " con " + this.memoriaBytesLong + " GB y velocidad " + this.velocidadMemoriaHzLong + " MHz";
    }

    
    
}
