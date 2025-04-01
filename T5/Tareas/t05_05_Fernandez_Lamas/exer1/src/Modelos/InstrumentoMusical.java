package Modelos;

import Excepciones.ExcepcionPrecioNegativo;
import Excepciones.ExcepcionStockNegativo;

public abstract class InstrumentoMusical extends Producto {

    private String marca;
    private String modelo;

    public InstrumentoMusical() {
    }

    

    public InstrumentoMusical(double precio, int stock, String descripcion, String marca, String modelo) throws ExcepcionStockNegativo, ExcepcionPrecioNegativo {
        super(precio, stock, descripcion);
        this.marca = marca;
        this.modelo = modelo;
    }



    public InstrumentoMusical(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
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

}
