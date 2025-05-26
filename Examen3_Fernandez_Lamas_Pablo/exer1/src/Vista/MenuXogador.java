package Vista;

import Controlador.GestionGeneral;
import Modelo.Xogador;
import Modelo.Excepcions.ExcepcionNoOfertaDeEquipo;
import Modelo.Excepcions.ExcepcionNombreEquipoNoExistente;
import Modelo.Excepcions.ExcepcionPlantillaChea;
import Modelo.Excepcions.ExcepcionXogadorNonLibre;

public class MenuXogador extends Menu {
    public void mostrar() {

    }

    public void mostrar(Xogador xogadorNow) {

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Xogador");
            this.printMessage("\ta) Ver ofertas");
            this.printMessage("\tb) Aceptar oferta dun equipo");
            this.printMessage("\ts) Sair");

            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {

                // Ver ofertas
                case "a" -> {
                    if (xogadorNow.getListaOfertas().isEmpty()) {
                        printMessage("No tiene ofertas.");
                        break;
                    }
                    xogadorNow.getEquiposOfertas().forEach(c -> System.out.println(c));
                }
                // Aceptar oferta
                case "b" -> {
                    try {
                        if (!xogadorNow.isXogadorLibre()) {
                            throw new ExcepcionXogadorNonLibre();
                        }
                        String nome = this.getString("Indaca o nome do equipo");
                        String cidade = this.getString("Indica a cidade do equipo");
                        if (!GestionGeneral.getInstance().existeNombreEquipo(nome, cidade)) {
                            throw new ExcepcionNombreEquipoNoExistente();
                        }
                        xogadorNow.aceptarOferta(GestionGeneral.getInstance().getEquipoPorNomeCidade(nome, cidade).get());
                    } catch (ExcepcionXogadorNonLibre e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionNombreEquipoNoExistente e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionNoOfertaDeEquipo e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionPlantillaChea e) {
                        printMessage(e.getMessage());
                    }
                }

                // Sair
                case "s" -> {
                    this.printMessage("Saíndo o menú principal");
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
