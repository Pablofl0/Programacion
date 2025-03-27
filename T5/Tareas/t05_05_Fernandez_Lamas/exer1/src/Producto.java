
public abstract class Producto {

    private int idProducto;
    private double precioConIVE;
    private double precioSinIVE;
    private int stock;
    private String descripcion;

    private final static double IVE = 21;
    private final static double IVEcalculado = 0.21;
    private static int contadorID = 1;

    

    public Producto() {
    }


    @Override
    public String toString() {
        return ". : " + idProducto + ". Precion con IVE: " + precioConIVE + " euros; Precio sin IVE: " + precioSinIVE + " euros; Stock: " + stock + " unidades; Descripción: " + descripcion + ".";
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = contadorID;
        contadorID++;
    }

    public double getPrecioConIVE() {
        return precioConIVE;
    }

    public void setPrecioConIVE() {
        this.precioConIVE = (this.precioSinIVE - (this.precioSinIVE * IVEcalculado));
    }

    public double getPrecioSinIVE() {
        return precioSinIVE;
    }

    public void setPrecioSinIVE(double precio) throws ExcepcionGeneral{
        if (precio < 0) {
            throw new ExcepcionGeneral("No se puede introducir un precio negativo.");
        }
        this.precioSinIVE = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws ExcepcionGeneral{
        if (stock < 0) {
            throw new ExcepcionGeneral("No se puede introducir un stock negativo.");
        }
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
