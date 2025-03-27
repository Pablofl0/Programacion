
public class Saxofon extends InstrumentoMusical {

    private TipoSaxo tipoSaxo;

    public Saxofon(int idProducto, double precio, int stock, String descripcion, String marca, String modelo, int opcionTipoSaxo) throws ExcepcionGeneral {
        this.setIdProducto(idProducto);
        this.setPrecioSinIVE(precio);
        this.setPrecioConIVE();
        this.setStock(stock);
        this.setDescripcion(descripcion);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setTipoSaxo(opcionTipoSaxo);
    }

    @Override
    public String toString() {
        return "Saxofón" + super.toString();
    }

    public TipoSaxo getTipoSaxo() {
        return tipoSaxo;
    }

    public void setTipoSaxo(int tipoSaxo) {
        switch (tipoSaxo) {
            case 1:
                this.tipoSaxo = TipoSaxo.soprano;
                break;
            case 2:
                this.tipoSaxo = TipoSaxo.alto;
                break;
            case 3:
                this.tipoSaxo = TipoSaxo.tenor;
                break;
            case 4:
                this.tipoSaxo = TipoSaxo.baritono;
                break;
        }
    }

    public boolean opcionTipoSaxoValida(int opcionPieDeSI){
        return (opcionPieDeSI > 0 && opcionPieDeSI < 5);
    }

}
