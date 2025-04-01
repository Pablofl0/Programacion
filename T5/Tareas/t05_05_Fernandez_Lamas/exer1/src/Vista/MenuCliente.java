package Vista;

import Controlador.GestionGeneral;
import Excepciones.ExcepcionComprarProductoSinStock;
import Excepciones.ExcepcionIdNoValido;

public class MenuCliente extends Menu{

    @Override
    public void mostrar() {
        //Eligiendo lo que quiere hacer el cliente.
        boolean eligiendoQueHacer = true;

        while (eligiendoQueHacer) {
            printMessage("¿Qué desea hacer el cliente?");
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
                        GestionGeneral.getInstance().comprarUnaUnidadDeUnProducto(idProductoAComprar);
                    } catch (ExcepcionIdNoValido e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionComprarProductoSinStock e) {
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
