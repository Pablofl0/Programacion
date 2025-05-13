package Vista;

import Controlador.GestionGeneral;
import Excepciones.ExcepcionIdNoValido;
import Excepciones.ExcepcionNoLibrosPorAutor;
import Excepciones.ExcepcionNoLibrosPorTitulo;
import Excepciones.ExcepcionRedDeLibrosVacia;
import Modelo.Cliente;
import Modelo.Usuario;

public class MenuCliente extends Menu {

    public void mostrar() {
    }

    public void mostrar(Cliente clienteNow) {
        // Eligiendo lo que quiere hacer el cliente.
        boolean eligiendoQueHacer = true;

        while (eligiendoQueHacer) {
            printMessage("¿Qué desea hacer el cliente?");
            printMessage("a) Buscar libros por título.");
            printMessage("b) Buscar libros por autor.");
            printMessage("c) Fecha devolución del préstamo actual.");
            printMessage("s) Salir.");
            String opcionHacer = this.getString("> ");

            switch (opcionHacer) {
                case "a":
                    String tituloLibro = this.getString("Introduce el título del libro: ");
                    try {
                        GestionGeneral.getInstance().librosPorTitulo(tituloLibro).forEach(c -> System.out.println(c));
                    } catch (ExcepcionNoLibrosPorTitulo e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionRedDeLibrosVacia e) {
                        printMessage(e.getMessage());
                    }
                    break;
                case "b":
                    String autorLibro = this.getString("Introduce el autor del libro: ");
                    try {
                        GestionGeneral.getInstance().librosPorAutor(autorLibro).forEach(c -> System.out.println(c));
                    } catch (ExcepcionNoLibrosPorAutor e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionRedDeLibrosVacia e) {
                        printMessage(e.getMessage());
                    }
                    break;
                case "c":
                    if (!clienteNow.tieneLibrosPrestados()) {
                        printMessage("No tienes libros prestados.");
                        break;
                    }
                    printMessage(clienteNow.fechaDevolucionPrestamoActual());
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
