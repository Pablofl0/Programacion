package Vista;

import Controlador.GestionGeneral;
import Modelo.Equipo;
import Modelo.Excepcions.ExcepcionCorreoUsuarioExistente;
import Modelo.Excepcions.ExcepcionCorreoUsuarioNonExistente;
import Modelo.Excepcions.ExcepcionPlantillaChea;
import Modelo.Excepcions.ExcepcionXogadorNonLibre;

public class MenuEquipo extends Menu {
    public void mostrar() {

    }

    public void mostrar(Equipo equipoNow) {

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Equipo");
            this.printMessage("\ta) Ver xogadores equipo");
            this.printMessage("\tb) Ver xogadores libres");
            this.printMessage("\tc) Facer oferta xogador");
            this.printMessage("\td) Xogar partido");
            this.printMessage("\ts) Sair");
    
            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {
    
                // Ver xogadores equipo
                case "a" -> {
                    equipoNow.getXogadoresOrdenadosEquipo().forEach(c -> System.out.println(c));
                }
    
                // Ver xogadores libres
                case "b" -> {
                    GestionGeneral.getInstance().getXogadoresLibres().forEach(c -> System.out.println(c));
                }
    
                // Facer oferta a xogador
                case "c" -> {
                    String email = this.getString("Introduce o email do xogador:");
                    try {
                        GestionGeneral.getInstance().facerOfertaAXogadorLibre(equipoNow, email);
                    } catch (ExcepcionCorreoUsuarioNonExistente e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionPlantillaChea e) {
                        printMessage(e.getMessage());
                    } catch (ExcepcionXogadorNonLibre e) {
                        printMessage(e.getMessage());
                    }
                }
    
                // Xogar partido
                case "d" -> {
                    equipoNow.xogarPartido();
                }
    
                // Sair
                case "s" -> {
                    this.printMessage("Saíndo ao menú principal");
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
