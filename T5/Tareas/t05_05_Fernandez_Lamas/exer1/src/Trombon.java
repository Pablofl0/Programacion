
public class Trombon extends InstrumentoMusical {

    private boolean transpositor;

    public Trombon(int idProducto, double precio, int stock, String descripcion, String marca, String modelo, int opcionTranspositor) throws ExcepcionGeneral {
        this.setIdProducto(idProducto);
        this.setPrecioSinIVE(precio);
        this.setPrecioConIVE();
        this.setStock(stock);
        this.setDescripcion(descripcion);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setTranspositor(opcionTranspositor);
    }

    @Override
    public String toString() {
        return "Trombón" + super.toString();
    }

    public boolean isTranspositor() {
        return transpositor;
    }

    public void setTranspositor(int opcionTranspositor) {
        if (opcionTranspositor == 1) {
            this.transpositor = true;
        }
        else if (opcionTranspositor == 2) {
            this.transpositor = false;
        }
    }

    public boolean opcionTranspositorValida(int opcionTranspositor){
        return (opcionTranspositor > 0 && opcionTranspositor < 3);
    }

}
