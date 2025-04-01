package Modelos;

import Excepciones.ExcepcionPrecioNegativo;
import Excepciones.ExcepcionStockNegativo;

public class Complemento extends Producto{
    public Complemento(double precio, int stock, String descripcion) throws ExcepcionStockNegativo,ExcepcionPrecioNegativo{
        super(precio,stock,descripcion);
    }
}
