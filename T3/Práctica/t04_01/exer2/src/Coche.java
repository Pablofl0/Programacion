public class Coche {
    private String marca;
    private String modelo;
    private String color;
    private int pasajeros;

    /**
     * 
     * @param marca Marca del coche
     * @param modelo Modelo del coche
     * @param color Color del coche
     * @param pasajeros Número de pasajeros
     */
    public Coche(String marca, String modelo, String color, int pasajeros) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.pasajeros = pasajeros;
    }

    public Coche(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.pasajeros = 5;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getPasajeros() {
        return pasajeros;
    }
    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }
}
