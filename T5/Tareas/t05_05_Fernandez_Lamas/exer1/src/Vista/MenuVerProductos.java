package Vista;
import java.util.ArrayList;

import Controlador.GestionGeneral;
import Modelos.Producto;

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
                    ArrayList<Producto> lista = GestionGeneral.getInstance().getProductos();
                    printList(lista);
                    break;
                case "b":
                    ArrayList<Producto> listaInstrumentos = GestionGeneral.getInstance().getInstrumentos();
                    printList(listaInstrumentos);
                    break;
                case "c":
                    ArrayList<Producto> listaComplementos = GestionGeneral.getInstance().getComplementos();
                    printList(listaComplementos);
                    break;
                case "d":
                    ArrayList<Producto> listaFlautas = GestionGeneral.getInstance().getFlautas();
                    printList(listaFlautas);
                    break;
                case "e":
                    ArrayList<Producto> listaSaxofones = GestionGeneral.getInstance().getSaxofones();
                    printList(listaSaxofones);
                    break;
                case "f":
                    ArrayList<Producto> listaTrombones = GestionGeneral.getInstance().getTrombones();
                    printList(listaTrombones);
                    break;
                case "g":
                    ArrayList<Producto> listaLibros = GestionGeneral.getInstance().getLibros();
                    printList(listaLibros);
                    break;
                case "h":
                    ArrayList<Producto> listaEstuches = GestionGeneral.getInstance().getEstuches();
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
