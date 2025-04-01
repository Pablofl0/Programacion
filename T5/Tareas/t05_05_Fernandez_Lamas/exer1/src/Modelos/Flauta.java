package Modelos;
import Excepciones.ExcepcionPrecioNegativo;
import Excepciones.ExcepcionStockNegativo;

public class Flauta extends InstrumentoMusical {

    private boolean pieDeSI;

    public Flauta(double precio, int stock, String descripcion, String marca, String modelo, boolean  opcionPieDeSI) throws ExcepcionStockNegativo,ExcepcionPrecioNegativo {
        super(precio, stock, descripcion, marca, modelo);
        this.setPieDeSI(opcionPieDeSI);
        this.setTipoProducto(TipoProducto.flauta);
    }

    @Override
    public String toString() {
        return "Flauta" + super.toString();
    }

    public boolean isPieDeSI() {
        return pieDeSI;
    }

    private void setPieDeSI(boolean  opcionPieDeSI) {
        this.pieDeSI = opcionPieDeSI;
    }

}
