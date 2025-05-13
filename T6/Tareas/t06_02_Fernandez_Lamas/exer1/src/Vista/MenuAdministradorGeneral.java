package Vista;

import Controlador.GestionGeneral;
import Excepciones.ExcepcionBibliotecaNoEnLaRed;
import Excepciones.ExcepcionEjemplaresInsuficientes;
import Excepciones.ExcepcionEmailInvalido;
import Excepciones.ExcepcionGeneral;
import Excepciones.ExcepcionISBNNoExistente;
import Excepciones.ExcepcionISBNNoValido;
import Excepciones.ExcepcionISBNRepetido;
import Excepciones.ExcepcionIdNoValido;
import Excepciones.ExcepcionRedDeBibliotecasVacia;
import Excepciones.ExcepcionRedDeLibrosVacia;
import Excepciones.ExcepcionRegistroUsuario;
import Modelo.AdministradorGeneral;
import Modelo.TipoLengua;

public class MenuAdministradorGeneral extends Menu {

    @Override
    public void mostrar() {
    }

    public void mostrar(AdministradorGeneral adminGeneral) {
        // Eligiendo lo que quiere hacer el administrador.
        boolean eligiendoQueHacer = true;

        while (eligiendoQueHacer) {
            printMessage("¿Qué quiere hacer el administrador?");
            printMessage("a) Dar de alta nueva biblioteca.");
            printMessage("b) Ver bibliotecas de la red.");
            printMessage("c) Añadir un libro.");
            printMessage("d) Ver libros de la red.");
            printMessage("e) Añadir ejemplares a una biblioteca.");
            printMessage("f) Dar de alta administradores de biblioteca.");
            printMessage("s) Salir.");
            String opcionHacer = this.getString("> ");

            switch (opcionHacer) {
                case "a":
                    String nombreBiblio = this.getString("Introduce el nombre de la biblioteca: ");
                    String direccion = this.getString("Introduce la dirección de la biblioteca: ");
                    String ciudad = this.getString("Introduce la ciudad en la que se encuentra la biblioteca: ");
                    String provincia = this.getString("Introduce la provincia en la que se encuentra la biblioteca: ");
                    GestionGeneral.getInstance().anhadirBiblioteca(nombreBiblio, direccion, ciudad, provincia);
                    break;
                case "b":
                    try {
                        GestionGeneral.getInstance().getBibliotecas().stream().forEach(b -> System.out.println(b));
                    } catch (ExcepcionRedDeBibliotecasVacia e) {
                        printMessage(e.getMessage());
                    }
                    break;
                case "c":
                    String titulo = this.getString("Introduce el título del libro: ");
                    String autor = this.getString("Introduce el autor del libro: ");
                    String editorial = this.getString("Introduce la editorial del libro: ");
                    String ISBN = this.getString("Introduce el ISBN del libro: ");
                    int opcionLengua = this.getInt("¿En qué lengua está el libro?");
                    TipoLengua tipoLengua = null;
                    switch (opcionLengua) {
                        case 1:
                            tipoLengua = TipoLengua.CASTELLANO;
                            break;
                        case 2:
                            tipoLengua = TipoLengua.GALLEGO;
                            break;
                        case 3:
                            tipoLengua = TipoLengua.INGLÉS;
                            break;
                        default:
                            printMessage("Opción no válida.");
                            break;
                    }
                    Integer numeroDeEjemplares = this.getInt("Introduce el número de ejemplares: ");
                    try {
                        GestionGeneral.getInstance().anhadirLibro(titulo, autor, tipoLengua, editorial, ISBN,
                                numeroDeEjemplares);
                    } catch (ExcepcionISBNNoValido e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionISBNRepetido e) {
                        printMessage(e.getMessage());
                    }
                    break;
                case "d":
                    try {
                        GestionGeneral.getInstance().getLibros().stream().forEach(b -> System.out.println(b));
                    } catch (ExcepcionRedDeLibrosVacia e) {
                        printMessage(e.getMessage());
                    }
                    break;
                case "e":
                    Integer numeroDeEjemplaresAAnhadir = this.getInt("Introduce el número de ejemplares: ");
                    Integer idBiblioteca = null;
                    while (idBiblioteca < 1
                            || idBiblioteca > GestionGeneral.getInstance().idDeBibliotecaMaximo().get()) {
                        idBiblioteca = this.getInt("Introduce el id de la Biblioteca: ");
                    }
                    String isbnLibro = this.getString("Introduce el ISBN del libro: ");
                    try {
                        GestionGeneral.getInstance().anhadirEjemplaresAUnaBiblioteca(idBiblioteca,
                                numeroDeEjemplaresAAnhadir,
                                GestionGeneral.getInstance().existeLibroConISBN(isbnLibro));
                    } catch (ExcepcionISBNNoExistente e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionEjemplaresInsuficientes e) {
                        printMessage(e.getMessage());
                    }
                    break;
                case "f":
                    boolean registroNombre = true;
                    boolean registroContrasenhas = true;
                    String nombreUsuarioRegistro = null;
                    String contrasenhaUsuarioRegistro = null;
                    String contrasenhaUsuarioRegistroConfirmacion = null;
                    while (registroNombre) {
                        nombreUsuarioRegistro = this.getString("Introduce el nombre de usuario: ");
                        if (GestionGeneral.getInstance().existeNombreUsuario(nombreUsuarioRegistro)) {
                            printMessage("El nombre de usuario ya está siendo utilizado.");
                        } else {
                            registroNombre = false;
                        }
                    }
                    while (registroContrasenhas) {
                        contrasenhaUsuarioRegistro = this.getString("Introduce la contrasenha: ");
                        contrasenhaUsuarioRegistroConfirmacion = this
                                .getString("Introduce nuevamente la contraseña: ");
                        if (!GestionGeneral.getInstance().coincidenCon1YCon2(contrasenhaUsuarioRegistro,
                                contrasenhaUsuarioRegistroConfirmacion)) {
                            printMessage("Las contraseñas no coincide.");
                        } else {
                            registroContrasenhas = false;
                        }
                    }
                    String nombre = this.getString("Introduce el nombre: ");
                    String apellido1 = this.getString("Introduce el primer apellido: ");
                    String apellido2 = this.getString("Introduce el segundo apellido: ");
                    String dni = this.getString("Introduce el DNI: ");
                    String correo = this.getString("Introduce un correo: ");
                    Integer idBibliotecaAdmin = 0;
                    while (idBibliotecaAdmin < 1 || idBibliotecaAdmin > GestionGeneral.getInstance().idDeBibliotecaMaximo().get()) {
                        idBibliotecaAdmin = this.getInt("Introduce el id de la biblioteca: ");
                    }
                    try {
                        GestionGeneral.getInstance().anhadirAdministradorBiblioteca(nombreUsuarioRegistro, contrasenhaUsuarioRegistroConfirmacion, nombre, apellido1, apellido2, dni, correo, idBibliotecaAdmin);
                    } catch (ExcepcionRegistroUsuario e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionEmailInvalido e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionBibliotecaNoEnLaRed e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionGeneral e) {
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
