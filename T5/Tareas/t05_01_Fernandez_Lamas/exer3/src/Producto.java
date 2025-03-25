
import java.util.Objects;

public abstract class Producto {
    private String marca;
    private String modelo;
    private double precio;
    
    @Override
    public String toString() {
        return marca + modelo + ": " + precio ;
    }
    public Producto(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object obj) {
        Producto other = (Producto) obj;
        if (this.marca.equals(other.marca)) {
            return false;
        }
        return this.modelo.equals(other.modelo);
    }    
}
