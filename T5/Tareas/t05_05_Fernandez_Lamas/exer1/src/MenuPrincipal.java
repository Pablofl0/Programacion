
public class MenuPrincipal extends Menu {

    @Override
    public void mostrar() {
        //Eligiendo qué acción tomar.
        boolean eligiendoQueHacer = true;

        while (eligiendoQueHacer) {
            printMessage("¡Bienvenido!");
            printMessage("a) Registrarse.");
            printMessage("b) Iniciar sesión.");
            printMessage("s) Salir.");
            String opcionHacer = this.getString("> ");

            switch (opcionHacer) {
                case "a":
                    printMessage("Registro.");
                    String nombreUsuarioRegistro = this.getString("Introduce el nombre de usuario: ");
                    String contrasenhaUsuarioRegistro = this.getString("Introduce la contrasenha: ");
                    String contrasenhaUsuarioRegistroConfirmacion = this.getString("Introduce nuevamente la contraseña: ");
                    printMessage("¿Rol?\n1. Administrador.\n2. Cliente.");
                    int opcionUsuario = this.getInt(">");
                    // int opcionUsuario = 0;
                    // while (opcionUsuario < 1 || opcionUsuario > 2) {
                    //     opcionUsuario = this.getInt(">");
                    // }
                    try {
                        switch (opcionUsuario) {
                            case 1:
                                Administrador newAdministrador = new Administrador(nombreUsuarioRegistro, contrasenhaUsuarioRegistro, contrasenhaUsuarioRegistroConfirmacion);
                                GestionUsuarios.anhadirUsuario(newAdministrador);
                                new MenuAdministrador().mostrar();
                                break;
                            case 2:
                                Cliente newCliente = new Cliente(nombreUsuarioRegistro, contrasenhaUsuarioRegistro, contrasenhaUsuarioRegistroConfirmacion);
                                GestionUsuarios.anhadirUsuario(newCliente);
                                new MenuCliente().mostrar();
                                break;
                            default:
                                printMessage("Elige un rol válido.");
                        }
                    } catch (ExcepcionGeneral e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "b":
                    printMessage("Iniciando sesión.");
                    String nombreUsuarioInicio = this.getString("Introduce el nombre de usuario: ");
                    String contrasenhaUsuarioInicio = this.getString("Introduce la contrasenha: ");
                    try {
                        GestionUsuarios.InicioDeSesionValido(nombreUsuarioInicio, contrasenhaUsuarioInicio);
                        TipoUsuario tipoUsuarioIniciandoSesion = GestionUsuarios.getTipoUsuario(nombreUsuarioInicio);
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
                        System.out.println(e.getMessage());
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
