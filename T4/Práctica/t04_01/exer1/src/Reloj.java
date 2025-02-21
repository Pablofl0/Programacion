public class Reloj {
    private String modelo;
    private String marca;
    private double precio;
    private boolean digital;

    /**
     *  
     * @param modelo Modelo del reloj
     * @param marca Marca del reloj
     * @param precio Precio del reloj
     * @param digital Digital=true Analógico=false
     */
    public Reloj(String modelo, String marca, double precio, boolean digital) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.digital = digital;
    }
}
