

public class MenuAdministrador extends Menu {

    @Override
    public void mostrar() {
        //Eligiendo lo que quiere hacer el administrador.
        boolean eligiendoQueHacer = true;

        while (eligiendoQueHacer) {
            printMessage("¿Qué quiere hacer el administrador?");
            printMessage("a) Añadir un producto.");
            printMessage("b) Ver productos.");
            printMessage("c) Ver información de un producto.");
            printMessage("d) Añadir stock a un producto.");
            printMessage("e) Eliminar stock de un prodcuto.");
            printMessage("s) Salir.");
            String opcionHacer = this.getString("> ");

            switch (opcionHacer) {
                case "a":
                    new MenuAnhadirProducto().mostrar();
                    break;
                case "b":
                    new MenuVerProductos().mostrar();
                    break;
                case "c":
                    printMessage("Viendo información de un producto.");
                    int idProductoAVer = this.getInt("Introduce el identificador del producto: ");
                    try {
                        GestionProductos.verProductoSegunID(idProductoAVer);
                    } catch (ExcepcionGeneral e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "d":
                    printMessage("Añadiendo stock a un producto.");
                    int idProductoAnhadirStock = this.getInt("Introduce el identificador del producto: ");
                    int stockAAnhadir = 0;
                    while (stockAAnhadir <= 0) {
                        stockAAnhadir = this.getInt("Introduce la cantidad (mayor que 0) de stock a añadir: ");
                    }
                    try {
                        GestionProductos.anhadirStockAUnProducto(idProductoAnhadirStock, stockAAnhadir);
                    } catch (ExcepcionGeneral e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    printMessage("Eliminando stock de un producto.");
                    int idProductoEliminarStock = this.getInt("Introduce el identificador del producto: ");
                    int cantidadStockAEliminar = this.getInt("Introduce la cantidad de stock a eliminar: ");
                    try {
                        GestionProductos.eliminarStockDeUnProducto(idProductoEliminarStock, cantidadStockAEliminar);
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
