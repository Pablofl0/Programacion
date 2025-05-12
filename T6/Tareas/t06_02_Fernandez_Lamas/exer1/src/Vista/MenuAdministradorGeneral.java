package Vista;

import Controlador.GestionGeneral;
import Excepciones.ExcepcionIdNoValido;
import Modelo.AdministradorGeneral;

public class MenuAdministradorGeneral extends Menu {

    @Override
    public void mostrar() {}

    public void mostrar(AdministradorGeneral adminGeneral) {
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
                        System.out.println(GestionGeneral.getInstance().verProductoSegunID(idProductoAVer));
                    } catch (ExcepcionIdNoValido e) {
                        printMessage(e.getMessage());;
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
                        GestionGeneral.getInstance().anhadirStockAUnProducto(idProductoAnhadirStock, stockAAnhadir);
                    } catch (ExcepcionIdNoValido e) {
                        printMessage(e.getMessage());
                    } 
                    break;
                case "e":
                    printMessage("Eliminando stock de un producto.");
                    int idProductoEliminarStock = this.getInt("Introduce el identificador del producto: ");
                    int cantidadStockAEliminar = this.getInt("Introduce la cantidad de stock a eliminar: ");
                    try {
                        GestionGeneral.getInstance().eliminarStockDeUnProducto(idProductoEliminarStock, cantidadStockAEliminar);
                    } catch (ExcepcionIdNoValido e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionEliminarStockDeMas e) {
                        printMessage(e.getMessage());
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
