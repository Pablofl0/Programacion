package Vista;

import Controlador.GestionGeneral;
import Excepciones.ExcepcionDNIExistente;
import Excepciones.ExcepcionEmailInvalido;
import Excepciones.ExcepcionGeneral;
import Excepciones.ExcepcionRegistroUsuario;
import Modelo.AdministradorBiblioteca;
import Modelo.AdministradorGeneral;
import Modelo.Cliente;
import Modelo.TipoUsuario;
import Modelo.Usuario;

public class MenuPrincipal extends Menu {

    @Override
    public void mostrar() {
        GestionGeneral.getInstance();
        printMessage("¡Bienvenido!");

        // Eligiendo qué acción tomar.
        boolean eligiendoQueHacer = true;

        while (eligiendoQueHacer) {
            printMessage("¿Qué acción quieres realizar?");
            printMessage("a) Registro.");
            printMessage("b) Iniciar sesión.");
            printMessage("s) Salir.");
            String opcionHacer = this.getString("> ");

            switch (opcionHacer) {
                case "a":
                    printMessage("Registro de Cliente.");
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
                    // printMessage("¿Rol?\n1. Administrador General.\n2. Administrador de
                    // Biblioteca.\n3. Cliente.");
                    // int opcionUsuario = 0;
                    // opcionUsuario = this.getInt(">");
                    // while (opcionUsuario < 1 || opcionUsuario > 3) {
                    // opcionUsuario = this.getInt(">");
                    // }
                    // if (GestionGeneral.getInstance().existeNombreUsuario(nombreUsuarioRegistro)
                    // ||
                    // !GestionGeneral.getInstance().coincidenCon1YCon2(contrasenhaUsuarioRegistro,
                    // contrasenhaUsuarioRegistroConfirmacion)) {
                    // printMessage("Credenciales no válidas.");
                    // }

                    try {
                        GestionGeneral.getInstance().anhadirCliente(nombreUsuarioRegistro,
                                contrasenhaUsuarioRegistroConfirmacion, nombre, apellido1, apellido2, dni, correo);
                        new MenuCliente().mostrar();
                    } catch (ExcepcionGeneral e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionRegistroUsuario e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionEmailInvalido e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionDNIExistente e) {
                        printMessage(e.getMessage());
                    }
                    // try {
                    // switch (opcionUsuario) {
                    // case 1:
                    // GestionGeneral.getInstance().anhadirAdministradorGeneral(nombreUsuarioRegistro,
                    // contrasenhaUsuarioRegistroConfirmacion, nombre, apellido1, apellido2, dni,
                    // correo);
                    // ;
                    // new MenuAdminGeneral().mostrar();
                    // break;
                    // case 2:
                    // Integer idBiblioteca = 0;
                    // idBiblioteca = this.getInt("Introduce el id de la biblioteca: ");
                    // while (idBiblioteca < 1 || idBiblioteca >
                    // (GestionGeneral.getInstance().idDeBibliotecaMaximo())) {
                    // idBiblioteca = this.getInt("Introduce el id de la biblioteca: ");
                    // }
                    // GestionGeneral.getInstance().anhadirAdministradorBiblioteca(nombreUsuarioRegistro,
                    // contrasenhaUsuarioRegistroConfirmacion, nombre, apellido1, apellido2, dni,
                    // correo, null);
                    // new MenuAdminBiblio().mostrar();
                    // break;
                    // case 3:
                    // GestionGeneral.getInstance().anhadirCliente(nombreUsuarioRegistro,
                    // contrasenhaUsuarioRegistro);
                    // new MenuCliente().mostrar();
                    // break;
                    // default:
                    // printMessage("Elige un rol válido.");
                    // }
                    // } catch (ExcepcionGeneral e) {
                    // printMessage(e.getMessage());
                    // } catch (ExcepcionRegistroUsuario e) {
                    // printMessage(e.getMessage());
                    // } catch (ExcepcionEmailInvalido e) {
                    // printMessage(e.getMessage());
                    // }
                    break;
                case "b":
                    printMessage("Iniciando sesión.");
                    String nombreUsuarioInicio = this.getString("Introduce el nombre de usuario: ");
                    String contrasenhaUsuarioInicio = this.getString("Introduce la contrasenha: ");
                    try {
                        GestionGeneral.getInstance().InicioDeSesionValido(nombreUsuarioInicio,
                                contrasenhaUsuarioInicio);
                        Usuario usuarioNow = GestionGeneral.getInstance().getUsuarios().get(nombreUsuarioInicio);
                        TipoUsuario tipoUsuarioIniciandoSesion = GestionGeneral.getInstance()
                                .getTipoUsuario(nombreUsuarioInicio);
                        switch (tipoUsuarioIniciandoSesion) {
                            case TipoUsuario.ADMINGENERAL:
                                AdministradorGeneral adminGeneral = (AdministradorGeneral) usuarioNow;
                                new MenuAdministradorGeneral().mostrar(adminGeneral);
                                break;
                            case TipoUsuario.ADMINBIBLIOTECA:
                                AdministradorBiblioteca adminBiblio = (AdministradorBiblioteca) usuarioNow;
                                new MenuAdministradorBiblioteca().mostrar(adminBiblio);
                                break;
                            case TipoUsuario.CLIENTE:
                                Cliente cliente = (Cliente) usuarioNow;
                                new MenuCliente().mostrar(cliente);
                                break;
                            default:
                                throw new AssertionError();
                        }
                    } catch (ExcepcionGeneral e) {
                        printMessage(e.getMessage());
                    }
                    break;
                case "s":
                    GestionGeneral.getInstance().gardar();
                    eligiendoQueHacer = false;
                    break;
                default:
                    printMessage("Opción no válida.");
            }
        }
    }
}
