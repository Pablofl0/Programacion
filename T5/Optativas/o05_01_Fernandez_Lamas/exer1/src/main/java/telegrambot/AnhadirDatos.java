package telegrambot;

import java.util.ArrayList;

public class AnhadirDatos {

    public static ArrayList<Festival> crearDatos() {
        ArrayList<Festival> listaFestivalesCreada = new ArrayList<>();
        listaFestivalesCreada.add(new Festival("A Candeloira", "Lugo", NombreProvincia.LUGO, "4/4/2025", "5/4/2025"));
        listaFestivalesCreada
                .add(new Festival("Festival Jaleo!", "A Coruña", NombreProvincia.CORUÑA, "5/4/2025", "5/4/2025"));
        listaFestivalesCreada.add(new Festival("Resurrection Fest", "Lugo", NombreProvincia.LUGO, "25/6/2025", "28/6/2025"));
        listaFestivalesCreada.add(new Festival("Festival Internacional do Mundo Celta", "Viveiro", NombreProvincia.CORUÑA,
                "9/7/2025", "13/7/2025"));
        listaFestivalesCreada.add(
                new Festival("Arcanxo Festival", "Ponteareas", NombreProvincia.PONTEVEDRA, "18/7/2025", "19/7/2025"));
        listaFestivalesCreada.add(new Festival("Festival Noroeste Estrella Galicia", "A Coruña", NombreProvincia.CORUÑA,
                "7/8/2025", "9/7/2025"));
        listaFestivalesCreada.add(
                new Festival("Festival de Ortigueira", "Ortigueira", NombreProvincia.CORUÑA, "9/7/2025", "13/7/2025"));
        listaFestivalesCreada
                .add(new Festival("Festival de Luz", "Boimorto", NombreProvincia.CORUÑA, "21/8/2025", "23/8/2025"));
        listaFestivalesCreada.add(
                new Festival("Festival da Canción de Sada", "Sada", NombreProvincia.CORUÑA, "1/9/2025", "5/9/2025"));
        return listaFestivalesCreada;
    }
}
