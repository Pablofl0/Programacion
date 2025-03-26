public class Factura {
    private int numFactura;
    private String dniCliente;
    private double cantidad;
    private static int contadorFacturas = 1;

    /**
     * Crea un objeto de la clase Factura.
     * @param dniCliente DNI del cliente que requiere la factura.
     * @param cantidad Cantidad de la factura.
     */
    public Factura(String dniCliente, double cantidad) throws ExcepcionDNIInvalido,ExcepcionNumeroNegativo{
        this.setDniCliente(dniCliente);
        this.setCantidad(cantidad);
        this.setNumFactura();
        // try {
        //     this.setDniCliente(dniCliente);
        //     this.setCantidad(cantidad);
        //     this.setNumFactura();
        // } catch (ExcepcionDNIInvalido excepcionDNIInvalido) {
        //     System.out.println((excepcionDNIInvalido.getMessage()));
        // } catch (ExcepcionNumeroNegativo excepcionNumeroNegativo) {
        //     System.out.println((excepcionNumeroNegativo.getMessage()));
        // } 
    }

    

    @Override
    public String toString() {
        return numFactura + ": " + dniCliente + " -> " + cantidad + " euros.";
    }



    public int getNumFactura() {
        return numFactura;
    }
    public void setNumFactura() {
        this.numFactura = contadorFacturas;
        contadorFacturas++;
    }
    public String getDniCliente() {
        return dniCliente;
    }
    public void setDniCliente(String dniCliente) throws ExcepcionDNIInvalido{
        if (!ExcepcionDNIInvalido.comprobarDNI(dniCliente)) {
            throw new ExcepcionDNIInvalido("El DNI no es válido.");
        }
        else{
            this.dniCliente = dniCliente;
        }
    }
    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) throws ExcepcionNumeroNegativo{
        if (cantidad < 0) {
            throw new ExcepcionNumeroNegativo("La cantidad no puede ser negativa.");
        }
        else{
            this.cantidad = cantidad; 
        }
    }


}
