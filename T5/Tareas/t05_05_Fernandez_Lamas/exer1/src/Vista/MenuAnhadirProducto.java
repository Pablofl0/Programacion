import Modelos.Estuche;
import Modelos.Flauta;
import Modelos.Libro;
import Modelos.Saxofon;
import Modelos.TipoInstrumento;
import Modelos.TipoSaxo;
import Modelos.Trombon;

public class MenuAnhadirProducto extends Menu {

    @Override
    public void mostrar() {
        //Eligiendo tipo de producto: instrumento musical o complemento.
        boolean eligiendoTipoProducto = true;

        while (eligiendoTipoProducto) {
            printMessage("\nEscoge un tipo de producto:");
            printMessage("a. Instrumento musical.");
            printMessage("b. Complemento.");
            printMessage("s. Salir");

            String opcionProducto = this.getString("\n\t> ");

            switch (opcionProducto) {
                //Eligiendo tipo de instrumento: flauta, saxofón o trombón.
                case "a" -> {
                    boolean eligiendoTipoInstrumento = true;

                    while (eligiendoTipoInstrumento) {
                        printMessage("\nEscoge un tipo de instrumento:");
                        printMessage("a. Flauta.");
                        printMessage("b. Saxofón.");
                        printMessage("c. Trombón.");
                        printMessage("s. Salir");

                        String opcionInstrumento = this.getString("\n\t> ");

                        switch (opcionInstrumento) {
                            case "a" -> {
                                printMessage("Añadiendo flauta.");
                                double precio = this.getDouble("Introduce el precio: ");
                                int stock = this.getInt("Introduce el stock: ");
                                String descripcion = this.getString("Introduce una breve descripción: ");
                                String marca = this.getString("Introduce la marca: ");
                                String modelo = this.getString("Introduce el modelo: ");
                                printMessage("¿Tiene pie de Si?");
                                int opcionPieDeSI = this.getInt("1. Sí.\n2. No.\n");
                                boolean booleanPieDeSi = false;
                                switch (opcionPieDeSI) {
                                    case 1:
                                        booleanPieDeSi = true;
                                        break;
                                    case 2:
                                        booleanPieDeSi = false;
                                        break;
                                    default:
                                        printMessage("Opción no válida.");
                                        break;
                                }
                                try {
                                    Flauta newFlauta = new Flauta(precio, stock, descripcion, marca, modelo, booleanPieDeSi);
                                    GestionProductos.anhadirProducto(newFlauta);
                                } catch (ExcepcionGeneral e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case "b" -> {
                                printMessage("Añadiendo saxofón: ");
                                double precio = this.getDouble("Introduce el precio: ");
                                int stock = this.getInt("Introduce el stock: ");
                                String descripcion = this.getString("Introduce una breve descripción: ");
                                String marca = this.getString("Introduce la marca: ");
                                String modelo = this.getString("Introduce el modelo: ");
                                printMessage("¿Qué tipo de saxofón es?");
                                int opcionSaxo = this.getInt("1. Soprano.\n2. Alto.\n3. Tenor.\n4. Barítono.");
                                TipoSaxo tipoSaxo = null;
                                switch (opcionSaxo) {
                                    case 1:
                                        tipoSaxo = TipoSaxo.soprano;
                                        break;
                                    case 2:
                                        tipoSaxo = TipoSaxo.alto;
                                        break;
                                    case 3:
                                        tipoSaxo = TipoSaxo.tenor;
                                        break;
                                    case 4:
                                        tipoSaxo = TipoSaxo.baritono;
                                        break;
                                    default:
                                        printMessage("Opción no válida.");
                                        break;
                                }
                                try {
                                    Saxofon newSaxo = new Saxofon(precio, stock, descripcion, marca, modelo, tipoSaxo);
                                    GestionProductos.anhadirProducto(newSaxo);
                                } catch (ExcepcionGeneral e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case "c" -> {
                                printMessage("Añadiendo trombón.");
                                double precio = this.getDouble("Introduce el precio: ");
                                int stock = this.getInt("Introduce el stock: ");
                                String descripcion = this.getString("Introduce una breve descripción: ");
                                String marca = this.getString("Introduce la marca: ");
                                String modelo = this.getString("Introduce el modelo: ");
                                printMessage("¿Tiene transpositor?");
                                int opcionTranspositor = this.getInt("1. Sí.\n2. No.");
                                boolean booleanTranspositor = false;
                                switch (opcionTranspositor) {
                                    case 1:
                                        booleanTranspositor = true;
                                        break;
                                    case 2:
                                        booleanTranspositor = false;
                                        break;
                                    default:
                                        printMessage("Opción no válida.");
                                        break;
                                }
                                try {
                                    Trombon newTrombon = new Trombon(precio, stock, descripcion, marca, modelo, booleanTranspositor);
                                    GestionProductos.anhadirProducto(newTrombon);
                                } catch (ExcepcionGeneral e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case "s" -> {
                                eligiendoTipoInstrumento = false;
                                break;
                            }
                            default -> {
                                System.out.println("Opción non válida.");
                                break;
                            }
                        }
                    }
                    break;
                }
                //Eligiendo tipo de complemento: libro o estuche.
                case "b" -> {
                    boolean eligiendoTipoComplemento = true;

                    while (eligiendoTipoComplemento) {
                        printMessage("\nEscoge un tipo de complemento:");
                        printMessage("a. Libro.");
                        printMessage("b. Estuche.");
                        printMessage("s. Salir");

                        String opcionComplemento = this.getString("\n\t> ");

                        switch (opcionComplemento) {
                            case "a" -> {
                                printMessage("Añadiendo libro.");
                                double precio = this.getDouble("Introduce el precio: ");
                                int stock = this.getInt("Introduce el stock: ");
                                String descripcion = this.getString("Introduce una breve descripción: ");
                                String titulo = this.getString("Introduce la marca: ");
                                String autor = this.getString("Introduce el modelo: ");
                                String isbn = this.getString("Introduce el ISBN: ");
                                try {
                                    Libro newLibro = new Libro(precio, stock, descripcion, titulo, autor, isbn);
                                    GestionProductos.anhadirProducto(newLibro);
                                } catch (ExcepcionGeneral e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case "b" -> {
                                printMessage("Añadiendo estuche: ");
                                double precio = this.getDouble("Introduce el precio: ");
                                int stock = this.getInt("Introduce el stock: ");
                                String descripcion = this.getString("Introduce una breve descripción: ");
                                String marca = this.getString("Introduce la marca: ");
                                printMessage("¿Tiene pie de Si?");
                                int opcionInstrumento = this.getInt("1. Flauta.\n2. Saxofón.\n3. Trombón.");
                                TipoInstrumento tipoInstrumento = null;
                                switch (opcionInstrumento) {
                                    case 1:
                                        tipoInstrumento = TipoInstrumento.flauta;
                                        break;
                                    case 2:
                                        tipoInstrumento = TipoInstrumento.saxofon;
                                        break;
                                    case 3:
                                        tipoInstrumento = TipoInstrumento.trombon;
                                        break;
                                    default:
                                        printMessage("Opción no válida.");
                                        break;
                                }
                                try {
                                    Estuche newEstuche = new Estuche(precio, stock, descripcion, marca, tipoInstrumento);
                                    GestionProductos.anhadirProducto(newEstuche);
                                } catch (ExcepcionGeneral e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case "s" -> {
                                eligiendoTipoComplemento = false;
                                break;
                            }
                            default -> {
                                System.out.println("Opción non válida.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case "s" -> {
                    eligiendoTipoProducto = false;
                    break;
                }
                default -> {
                    System.out.println("Opción non válida.");
                    break;
                }
            }
        }
    }
}
