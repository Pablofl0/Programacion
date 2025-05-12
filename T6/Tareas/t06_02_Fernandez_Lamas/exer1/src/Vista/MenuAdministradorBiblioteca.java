package Vista;

import Controlador.GestionGeneral;
import Modelo.AdministradorBiblioteca;

public class MenuAdministradorBiblioteca extends Menu {

    @Override
    public void mostrar() {
    }

    public void mostrar(AdministradorBiblioteca adminBiblio) {
        //Eligiendo lo que quiere hacer el administrador.
        boolean eligiendoQueHacer = true;

        while (eligiendoQueHacer) {
            printMessage("¿Qué quiere hacer el administrador de la biblioteca?");
            printMessage("a) Ver libros de la biblioteca.");
            printMessage("b) Añadir préstamo.");
            printMessage("c) Devolver ejemplar.");
            printMessage("s) Salir.");
            String opcionHacer = this.getString("> ");

            switch (opcionHacer) {
                case "a":
                    adminBiblio.getBibliotecaAsignada().getListaEjemplaresSinPrestar().stream().forEach(c -> System.out.println(c));
                    break;
                case "b":
                    String dni = this.getString("Introduce el DNI del cliente: ");
                    String isbnLibroDelEjemplarParaPrestar = this.getString("Introduce el isbn del libro que deseas: ");
                    String fechaPrestamo = this.getString("Introduce la fecha del préstamo: ");
                    try {
                        GestionGeneral.getInstance().anhadirUnPrestamoAUnCliente(dni, isbnLibroDelEjemplarParaPrestar, fechaPrestamo, adminBiblio.getBibliotecaAsignada());
                    } catch (Exception e) {
                        printMessage(e.getMessage());
                    }
                    break;
                case "c":
                    String dniDevoluvion = this.getString("Introduce el DNI del cliente: ");
                    String fechaDevolucion = this.getString("Introduce la fecha de devolución: ");
                    try {
                        GestionGeneral.getInstance().devolverPrestamoDeUnCliente(dniDevoluvion, fechaDevolucion);
                    } catch (Exception e) {
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
