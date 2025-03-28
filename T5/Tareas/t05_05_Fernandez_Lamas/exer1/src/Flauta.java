
public class Flauta extends InstrumentoMusical {

    private boolean pieDeSI;

    public Flauta(int idProducto, double precio, int stock, String descripcion, String marca, String modelo, int opcionPieDeSI) throws ExcepcionGeneral {
        this.setIdProducto(idProducto);
        this.setPrecioSinIVE(precio);
        this.setPrecioConIVE();
        this.setStock(stock);
        this.setDescripcion(descripcion);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPieDeSI(opcionPieDeSI);
    }

    @Override
    public String toString() {
        return "Flauta" + super.toString();
    }

    public boolean isPieDeSI() {
        return pieDeSI;
    }

    private void setPieDeSI(int opcionPieDeSI) {
        if (opcionPieDeSI == 1) {
            this.pieDeSI = true;
        }
        else if (opcionPieDeSI == 2) {
            this.pieDeSI = false;
        }
    }

    public boolean opcionPieDeSIValida(int opcionPieDeSI){
        return (opcionPieDeSI > 0 && opcionPieDeSI < 3);
    }

}
