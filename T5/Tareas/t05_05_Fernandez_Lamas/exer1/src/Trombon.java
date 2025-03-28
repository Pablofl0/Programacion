
public class Trombon extends InstrumentoMusical {

    private boolean transpositor;

    public Trombon(double precio, int stock, String descripcion, String marca, String modelo, boolean  opcionTranspositor) throws ExcepcionGeneral {
        this.setIdProducto();
        this.setPrecioSinIVE(precio);
        this.setPrecioConIVE();
        this.setStock(stock);
        this.setDescripcion(descripcion);
        this.setMarca(marca);
        this.setModelo(modelo);
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
