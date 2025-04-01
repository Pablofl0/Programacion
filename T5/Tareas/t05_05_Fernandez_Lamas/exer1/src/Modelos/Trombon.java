package Modelos;
import Excepciones.ExcepcionPrecioNegativo;
import Excepciones.ExcepcionStockNegativo;

public class Trombon extends InstrumentoMusical {

    private boolean transpositor;

    public Trombon(double precio, int stock, String descripcion, String marca, String modelo, boolean  opcionTranspositor) throws ExcepcionStockNegativo,ExcepcionPrecioNegativo {
        super(precio, stock, descripcion, marca, modelo);
        this.setTranspositor(opcionTranspositor);
        this.setTipoProducto(TipoProducto.trombon);
    }

    @Override
    public String toString() {
        return "Trombón" + super.toString();
    }

    public boolean isTranspositor() {
        return transpositor;
    }

    public void setTranspositor(boolean  opcionTranspositor) {
        this.transpositor = opcionTranspositor;
    }

}
