package Modelos;
import Excepciones.ExcepcionPrecioNegativo;
import Excepciones.ExcepcionStockNegativo;

public class Saxofon extends InstrumentoMusical {

    private TipoSaxo tipoSaxo;

    public Saxofon(double precio, int stock, String descripcion, String marca, String modelo, TipoSaxo tipoSaxo) throws ExcepcionStockNegativo,ExcepcionPrecioNegativo {
        super(precio, stock, descripcion, marca, modelo);
        this.setTipoSaxo(tipoSaxo);
        this.setTipoProducto(TipoProducto.saxofon);
    }

    @Override
    public String toString() {
        return "Saxofón" + super.toString();
    }

    public TipoSaxo getTipoSaxo() {
        return tipoSaxo;
    }

    public void setTipoSaxo(TipoSaxo tipoSaxo) {
        this.tipoSaxo = tipoSaxo;
    }

}
