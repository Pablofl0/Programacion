package Vista;

import Controlador.GestionGeneral;
import Excepciones.ExcepcionGeneral;
import Excepciones.ExcepcionRegistroUsuario;
import Modelos.TipoUsuario;

public class MenuPrincipal extends Menu {

    @Override
    public void mostrar() {
        printMessage("¡Bienvenido!");

        // Eligiendo qué acción tomar.
        boolean eligiendoQueHacer = true;

        while (eligiendoQueHacer) {
            printMessage("¿Qué acción quieres realizar?");
            printMessage("a) Registrarse.");
            printMessage("b) Iniciar sesión.");
            printMessage("s) Salir.");
            String opcionHacer = this.getString("> ");

            switch (opcionHacer) {
                case "a":
                    printMessage("Registro.");
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
                        if (!GestionGeneral.getInstance().coincidenCon1YCon2(contrasenhaUsuarioRegistro, contrasenhaUsuarioRegistroConfirmacion)) {
                            printMessage("Las contraseñas no coincide.");
                        }
                        else{
                            registroContrasenhas = false;
                        }
                    }
                    printMessage("¿Rol?\n1. Administrador.\n2. Cliente.");
                    int opcionUsuario = 0;
                    opcionUsuario = this.getInt(">");
                    while (opcionUsuario < 1 || opcionUsuario > 2) {
                        opcionUsuario = this.getInt(">");
                    }
                    // if (GestionGeneral.getInstance().existeNombreUsuario(nombreUsuarioRegistro) || !GestionGeneral.getInstance().coincidenCon1YCon2(contrasenhaUsuarioRegistro, contrasenhaUsuarioRegistroConfirmacion)) {
                    //     printMessage("Credenciales no válidas.");
                    // }

                    try {
                        switch (opcionUsuario) {
                            case 1:
                                GestionGeneral.getInstance().anhadirAdministrador(nombreUsuarioRegistro, contrasenhaUsuarioRegistro);
                                new MenuAdministrador().mostrar();
                                break;
                            case 2:
                                GestionGeneral.getInstance().anhadirCliente(nombreUsuarioRegistro, contrasenhaUsuarioRegistro);
                                new MenuCliente().mostrar();
                                break;
                            default:
                                printMessage("Elige un rol válido.");
                        }
                    } catch (ExcepcionGeneral e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionRegistroUsuario e) {
                        printMessage(e.getMessage());
                    }
                    break;
                case "b":
                    printMessage("Iniciando sesión.");
                    String nombreUsuarioInicio = this.getString("Introduce el nombre de usuario: ");
                    String contrasenhaUsuarioInicio = this.getString("Introduce la contrasenha: ");
                    try {
                        GestionGeneral.getInstance().InicioDeSesionValido(nombreUsuarioInicio, contrasenhaUsuarioInicio);
                        TipoUsuario tipoUsuarioIniciandoSesion = GestionGeneral.getInstance().getTipoUsuario(nombreUsuarioInicio);
                        switch (tipoUsuarioIniciandoSesion) {
                            case TipoUsuario.Administrador:
                                new MenuAdministrador().mostrar();
                                break;
                            case TipoUsuario.Cliente:
                                new MenuCliente().mostrar();
                                break;
                            default:
                                throw new AssertionError();
                        }
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
