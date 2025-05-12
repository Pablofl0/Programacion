package Vista;

import Controlador.GestionGeneral;
import Excepciones.ExcepcionIdNoValido;
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
                    if (GestionGeneral.getInstance().librosPorTitulo(tituloLibro).toList().isEmpty()) {
                        printMessage("No hay libros con ese título.");
                    }
                    GestionGeneral.getInstance().librosPorTitulo(tituloLibro).forEach(c -> System.out.println(c));
                    break;
                case "b":
                    String autorLibro = this.getString("Introduce el autor del libro: ");
                    if (GestionGeneral.getInstance().librosPorAutor(autorLibro).toList().isEmpty()) {
                        printMessage("No hay libros con ese autor.");
                    }
                    GestionGeneral.getInstance().librosPorAutor(autorLibro);
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
