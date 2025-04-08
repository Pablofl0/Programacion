package telegrambot;

import java.util.ArrayList;

public class AnhadirDatos {

    public static ArrayList<Festival> crearDatos() {
        ArrayList<Festival> listaFestivalesCreada = new ArrayList<>();
        listaFestivalesCreada.add(new Festival("A Candeloira", "Lugo", NombreProvincia.LUGO, "04/04/2025", "05/04/2025"));
        listaFestivalesCreada
                .add(new Festival("Festival Jaleo!", "A Coruña", NombreProvincia.CORUÑA, "05/04/2025", "05/04/2025"));
        listaFestivalesCreada.add(new Festival("Resurrection Fest", "Lugo", NombreProvincia.LUGO, "25/06/2025", "28/06/2025"));
        listaFestivalesCreada.add(new Festival("Festival Internacional do Mundo Celta", "Viveiro", NombreProvincia.CORUÑA,
                "09/07/2025", "13/07/2025"));
        listaFestivalesCreada.add(
                new Festival("Arcanxo Festival", "Ponteareas", NombreProvincia.PONTEVEDRA, "18/07/2025", "19/07/2025"));
        listaFestivalesCreada.add(new Festival("Festival Noroeste Estrella Galicia", "A Coruña", NombreProvincia.CORUÑA,
                "07/08/2025", "09/07/2025"));
        listaFestivalesCreada.add(
                new Festival("Festival de Ortigueira", "Ortigueira", NombreProvincia.CORUÑA, "09/07/2025", "13/07/2025"));
        listaFestivalesCreada
                .add(new Festival("Festival de Luz", "Boimorto", NombreProvincia.CORUÑA, "21/08/2025", "23/08/2025"));
        listaFestivalesCreada.add(
                new Festival("Festival da Canción de Sada", "Sada", NombreProvincia.CORUÑA, "01/09/2025", "05/09/2025"));
        return listaFestivalesCreada;
    }
}
