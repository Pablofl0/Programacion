
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        return Objects.equals(this.modelo, other.modelo);
    }    
}
