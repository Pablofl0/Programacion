public class Estuche extends Complemento{
    private String marca;
    private TipoInstrumento instrumento;

    public Estuche(double precio, int stock, String descripcion, String marca, TipoInstrumento instrumento) throws ExcepcionGeneral {
        this.setIdProducto();
        this.setPrecioSinIVE(precio);
        this.setPrecioConIVE();
        this.setStock(stock);
        this.setDescripcion(descripcion);
        this.setMarca(marca);
        this.setInstrumento(instrumento);
        this.setTipoProducto(TipoProducto.estuche);
    }

    @Override
    public String toString() {
        return "Estuche" + super.toString();
    }

    public String getMarca() {
        return marca;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoInstrumento getInstrumento() {
        return instrumento;
    }

    private void setInstrumento(TipoInstrumento instrumento) {
        this.instrumento = instrumento;
    }

    
}
