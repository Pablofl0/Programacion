
public class MenuCliente extends Menu{

    @Override
    public void mostrar() {
        //Eligiendo lo que quiere hacer el cliente.
        boolean eligiendoQueHacer = true;

        while (eligiendoQueHacer) {
            printMessage("¿Qué quiere hacer el administrador?");
            printMessage("a) Ver productos.");
            printMessage("b) Comprar una unidad de un producto.");
            printMessage("s) Salir.");
            String opcionHacer = this.getString("> ");

            switch (opcionHacer) {
                case "a":
                    new MenuVerProductos().mostrar();
                    break;
                case "b":
                    printMessage("Comprando una unidad de un producto.");
                    int idProductoAComprar = this.getInt("Introduce el identificador del producto: ");
                    try {
                        GestionProductos.comprarUnaUnidadDeUnProducto(idProductoAComprar);
                    } catch (ExcepcionGeneral e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    eligiendoQueHacer = false;
                    break;
                default:
                    printMessage("Opción no válida.");
            }
        }
    }
}
