
public class Saxofon extends InstrumentoMusical {

    private TipoSaxo tipoSaxo;

    public Saxofon(double precio, int stock, String descripcion, String marca, String modelo, TipoSaxo tipoSaxo) throws ExcepcionGeneral {
        this.setIdProducto();
        this.setPrecioSinIVE(precio);
        this.setPrecioConIVE();
        this.setStock(stock);
        this.setDescripcion(descripcion);
        this.setMarca(marca);
        this.setModelo(modelo);
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
