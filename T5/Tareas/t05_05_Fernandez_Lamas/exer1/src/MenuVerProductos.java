
import java.util.ArrayList;

public class MenuVerProductos extends Menu {

    @Override
    public void mostrar() {
        //Eligiendo lo que quiere ver el cliente.
        boolean eligiendoQueVer = true;

        while (eligiendoQueVer) {
            printMessage("Elige una opción: ");
            printMessage("a) Ver productos.");
            printMessage("b) Ver instrumentos.");
            printMessage("c) Ver complementos.");
            printMessage("d) Ver flautas.");
            printMessage("e) Ver saxofones.");
            printMessage("f) Ver trombones.");
            printMessage("g) Ver libros.");
            printMessage("h) Ver estuches.");
            printMessage("s) Salir.");
            String opcionVer = this.getString("> ");

            switch (opcionVer) {
                case "a":
                    ArrayList<Producto> lista = GestionProductos.getProductos();
                    printList(lista);
                    break;
                case "b":
                    ArrayList<Producto> listaInstrumentos = GestionProductos.getInstrumentos();
                    printList(listaInstrumentos);
                    break;
                case "c":
                    ArrayList<Producto> listaComplementos = GestionProductos.getComplementos();
                    printList(listaComplementos);
                    break;
                case "d":
                    ArrayList<Producto> listaFlautas = GestionProductos.getFlautas();
                    printList(listaFlautas);
                    break;
                case "e":
                    ArrayList<Producto> listaSaxofones = GestionProductos.getSaxofones();
                    printList(listaSaxofones);
                    break;
                case "f":
                    ArrayList<Producto> listaTrombones = GestionProductos.getTrombones();
                    printList(listaTrombones);
                    break;
                case "g":
                    ArrayList<Producto> listaLibros = GestionProductos.getLibros();
                    printList(listaLibros);
                    break;
                case "h":
                    ArrayList<Producto> listaEstuches = GestionProductos.getEstuches();
                    printList(listaEstuches);
                    break;
                case "s":
                    eligiendoQueVer = false;
                    break;
                default:
                    printMessage("Opción no válida.");
            }
        }
    }
}
