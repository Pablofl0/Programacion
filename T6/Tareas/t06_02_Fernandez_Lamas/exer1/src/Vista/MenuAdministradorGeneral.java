package Vista;

import Controlador.GestionGeneral;
import Excepciones.ExcepcionBibliotecaNoEnLaRed;
import Excepciones.ExcepcionEjemplaresInsuficientes;
import Excepciones.ExcepcionEmailInvalido;
import Excepciones.ExcepcionGeneral;
import Excepciones.ExcepcionISBNNoExistente;
import Excepciones.ExcepcionISBNNoValido;
import Excepciones.ExcepcionISBNRepetido;
import Excepciones.ExcepcionRedDeBibliotecasVacia;
import Excepciones.ExcepcionRedDeLibrosVacia;
import Excepciones.ExcepcionRegistroUsuario;
import Modelo.AdministradorGeneral;
import Modelo.TipoLengua;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
            printMessage("c) Añadir un libro mediante línea de comandos.");
            printMessage("d) Añadir libros mediante un archivo.");
            printMessage("e) Ver libros de la red.");
            printMessage("f) Añadir ejemplares a una biblioteca.");
            printMessage("g) Dar de alta administradores de biblioteca.");
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
                    String rutaFicheiro = this.getString("Introduce el nombre del fichero: ");

                    // Try con resources
                    try (BufferedReader reader = new BufferedReader(new FileReader(rutaFicheiro))) {
                        String liña;
                        reader.readLine();
                        while ((liña = reader.readLine()) != null) {
                            // Separar a liña en campos usando a coma como delimitador
                            String[] campos = liña.split(",");

                            TipoLengua tipoLenguaLibro = null;
                            switch (campos[2]) {
                                case "INGLES":
                                    tipoLenguaLibro = TipoLengua.INGLÉS;
                                    break;
                                case "GALEGO":
                                    tipoLenguaLibro = TipoLengua.GALLEGO;
                                    break;
                                case "ESPAÑOL":
                                    tipoLenguaLibro = TipoLengua.CASTELLANO;
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                            try {
                                GestionGeneral.getInstance().anhadirLibro(campos[0], campos[3], tipoLenguaLibro, campos[1], campos[4], Integer.valueOf(campos[5]));
                            } catch (ExcepcionISBNNoValido e) {
                                printMessage(e.getMessage());
                            } catch (ExcepcionISBNRepetido e) {
                                printMessage(e.getMessage());
                            }
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    break;
                case "e":
                    try {
                        GestionGeneral.getInstance().getLibros().stream().forEach(b -> System.out.println(b));
                    } catch (ExcepcionRedDeLibrosVacia e) {
                        printMessage(e.getMessage());
                    }
                    break;
                case "f":
                    Integer numeroDeEjemplaresAAnhadir = this.getInt("Introduce el número de ejemplares: ");
                    Integer idBiblioteca = 0;
                    while (idBiblioteca < 1
                            || idBiblioteca > GestionGeneral.getInstance().idDeBibliotecaMaximo()) {
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
                case "g":
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
                    while (idBibliotecaAdmin < 1 || idBibliotecaAdmin > GestionGeneral.getInstance().idDeBibliotecaMaximo()) {
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
