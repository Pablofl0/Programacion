package Modelos;
import Excepciones.ExcepcionGeneral;

public class Flauta extends InstrumentoMusical {

    private boolean pieDeSI;

    public Flauta(double precio, int stock, String descripcion, String marca, String modelo, boolean  opcionPieDeSI) throws ExcepcionGeneral {
        this.setIdProducto();
        this.setPrecioSinIVE(precio);
        this.setPrecioConIVE();
        this.setStock(stock);
        this.setDescripcion(descripcion);
        this.setMarca(marca);
        this.setModelo(modelo);
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
