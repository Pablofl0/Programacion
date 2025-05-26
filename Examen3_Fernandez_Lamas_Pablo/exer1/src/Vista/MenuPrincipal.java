package Vista;

import Controlador.GestionGeneral;
import Modelo.Administrador;
import Modelo.Equipo;
import Modelo.TipoUsuario;
import Modelo.Usuario;
import Modelo.Xogador;
import Modelo.Excepcions.ExcepcionInicioNoValido;

public class MenuPrincipal extends Menu {
    public void mostrar() {

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Principal");
            this.printMessage("\ta) Iniciar sesión");
            this.printMessage("\ts) Sair");

            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {

                // Iniciar Sesion
                case "a" -> {
                    String email = this.getString("Introduza un nome de usuario: ");
                    String password = this.getString("Introduza o contrasinal: ");
                    try {
                        GestionGeneral.getInstance().InicioDeSesionValido(email,
                                password);
                        Usuario usuarioNow = GestionGeneral.getInstance().getUsuarios().get(email);
                        TipoUsuario tipoUsuarioIniciandoSesion = GestionGeneral.getInstance()
                                .getTipoUsuario(email);
                        switch (tipoUsuarioIniciandoSesion) {
                            case TipoUsuario.ADMINISTRADOR:
                                Administrador adminGeneral = (Administrador) usuarioNow;
                                new MenuAdministrador().mostrar(adminGeneral);
                                break;
                            case TipoUsuario.EQUIPO:
                                Equipo equipo = (Equipo) usuarioNow;
                                new MenuEquipo().mostrar(equipo);
                                break;
                            case TipoUsuario.XOGADOR:
                                Xogador xogador = (Xogador) usuarioNow;
                                new MenuXogador().mostrar(xogador);
                                break;
                            default:
                                throw new AssertionError();
                        }
                    } catch (ExcepcionInicioNoValido e) {
                        printMessage(e.getMessage());
                    }
                }

                // Sair
                case "s" -> {
                    this.printMessage("Saíndo do programa");
                    menuActivo = false;
                }

                // Opcion por defecto
                default -> this.printMessage("Elixe unha opcion correcta");
            }
        }

    }
}
