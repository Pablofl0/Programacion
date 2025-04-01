package Modelos;
import Excepciones.ExcepcionComprarProductoSinStock;
import Excepciones.ExcepcionEliminarStockDeMas;
import Excepciones.ExcepcionPrecioNegativo;
import Excepciones.ExcepcionStockNegativo;

public abstract class Producto {

    private int idProducto;
    private double precioConIVE;
    private double precioSinIVE;
    private int stock;
    private String descripcion;
    private TipoProducto tipoProducto;

    // private final static double IVE = 21;
    private final static double IVEcalculado = 0.21;
    private static int contadorID = 1;

    

    public Producto() {
    }


    public Producto(double precio, int stock, String descripcion) throws ExcepcionStockNegativo,ExcepcionPrecioNegativo{
        this.setIdProducto();
        this.setPrecioSinIVE(precio);
        this.setPrecioConIVE();
        this.setStock(stock);
        this.setDescripcion(descripcion);
    }




    @Override
    public String toString() {
        return ". : " + idProducto + ". Precion con IVE: " + precioConIVE + " euros; Precio sin IVE: " + precioSinIVE + " euros; Stock: " + stock + " unidades; Descripción: " + descripcion + ".";
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto() {
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

    public void setPrecioSinIVE(double precio) throws ExcepcionPrecioNegativo{
        if (precio < 0) {
            throw new ExcepcionPrecioNegativo();
        }
        this.precioSinIVE = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws ExcepcionStockNegativo{
        if (stock < 0) {
            throw new ExcepcionStockNegativo();
        }
        this.stock = stock;
    }

    public void anhadirStock(int stock) {
        this.stock += stock;
    }

    public void eliminarStock(int stock) throws ExcepcionEliminarStockDeMas{
        if (this.stock < stock) {
            throw new ExcepcionEliminarStockDeMas();
        }
        this.stock -= stock;
    }

    public void comprarUnaUnidad() throws ExcepcionComprarProductoSinStock{
        if (this.stock == 0) {
            throw new ExcepcionComprarProductoSinStock();
        }
        this.stock -= 1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    

}
