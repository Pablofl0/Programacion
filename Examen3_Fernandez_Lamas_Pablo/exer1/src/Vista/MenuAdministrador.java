package Vista;

import Controlador.GestionGeneral;
import Modelo.Administrador;
import Modelo.TipoXogador;
import Modelo.Excepcions.ExcepcionCorreoUsuarioExistente;
import Modelo.Excepcions.ExcepcionEmailInvalido;
import Modelo.Excepcions.ExcepcionNombreCiudadRepetidos;

public class MenuAdministrador extends Menu {
    public void mostrar() {
        
    }

    public void mostrar(Administrador adminNow) {

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Administrador");
            this.printMessage("\ta) Engadir equipo");
            this.printMessage("\tb) Dar de alta xogadores");
            this.printMessage("\tc) Ver xogadores libres");
            this.printMessage("\ts) Sair");

            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {

                // Engadir equipo
                case "a" -> {
                    String nome = this.getString("Indicame o nome do equipo: ");
                    String cidade = this.getString("Indicame o nome da cidade: ");
                    try {
                        GestionGeneral.getInstance().anhadirEquipo(nome, cidade);
                    } catch (ExcepcionNombreCiudadRepetidos e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionEmailInvalido e) {
                        printMessage(e.getMessage());
                    }
                }

                // Dar de alta xogadores
                case "b" -> {
                    String nome = this.getString("Indicame o nome do xogador: ");
                    String email = this.getString("Indicame o email do xogador: ");
                    String posicionOpcion = this.getString(
                            "Indica a posicion: b) Base e) Exterior i) Interior . Por defecto a selección é interior: ");
                            TipoXogador tipoXogador = null;
                    switch (posicionOpcion) {
                        case "b":
                            tipoXogador = TipoXogador.BASE;
                            break;
                        case "e":
                            tipoXogador = TipoXogador.EXTERIOR;
                            break;
                        case "i":
                            tipoXogador = TipoXogador.INTERIOR;
                            break;
                        default:
                            break;
                    }
                    try {
                        GestionGeneral.getInstance().anhadirXogador(email, tipoXogador, nome);
                    } catch (ExcepcionCorreoUsuarioExistente e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionEmailInvalido e) {
                        printMessage(e.getMessage());
                    }
                }

                // Ver xogadores libres
                case "c" -> {
                    GestionGeneral.getInstance().getXogadoresLibres().forEach(c -> System.out.println(c));
                }

                // Sair
                case "s" -> {
                    this.printMessage("Saíndo do programa");
                    menuActivo = false;
                }

                // Opcion por defecto
                default -> {
                    this.printMessage("Elixe unha opcion correcta");

                }

            }
        }

    }
}
