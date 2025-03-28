public class Estuche extends Complemento{
    private String marca;
    private TipoInstrumento Instrumento;

    public Estuche(int idProducto, double precio, int stock, String descripcion, String marca, int opcionIntrumento) throws ExcepcionGeneral {
        this.setIdProducto(idProducto);
        this.setPrecioSinIVE(precio);
        this.setPrecioConIVE();
        this.setStock(stock);
        this.setDescripcion(descripcion);
        this.setMarca(marca);
        this.setInstrumento(opcionIntrumento);
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
        return Instrumento;
    }

    private void setInstrumento(int opcionIntrumento) {
        switch (opcionIntrumento) {
            case 1:
                this.Instrumento = TipoInstrumento.flauta;
                break;
            case 2:
                this.Instrumento = TipoInstrumento.saxofon;
                break;
            case 3:
                this.Instrumento = TipoInstrumento.trombon;
                break;
        }
    }

    public boolean opcionTipoInstrumentoValida(int opcionIntrumento){
        return (opcionIntrumento > 0 && opcionIntrumento < 4);
    }

    
}
