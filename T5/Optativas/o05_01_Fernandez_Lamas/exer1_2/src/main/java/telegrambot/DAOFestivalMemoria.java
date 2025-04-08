package telegrambot;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import telegrambot.DAO.DAOFestival;

public class DAOFestivalMemoria implements DAOFestival{
    public ArrayList<Festival> listaFestivales = AnhadirDatos.crearDatos();
   

    public List<Festival> getFestivales() {
        ArrayList<Festival> listaDevolver = new ArrayList<>();
        for (Festival festival : listaFestivales) {
            listaDevolver.add(festival);
        }
        return listaDevolver;
    }

    public Festival getProximoFestival() {
        Festival festivalFinal = null;
        int diff = -1;
        for (Festival festival : listaFestivales) {
            int diffNow = (int) ChronoUnit.DAYS.between(LocalDate.now(), festival.getHoraInicio());
            if (diff == -1 || diff > diffNow ) {
                diff = diffNow;
                festivalFinal = festival;
            }
        }
        return festivalFinal;
    }

    public List<Festival> getFestivaisProvincia(NombreProvincia nombreProvincia) {
        ArrayList<Festival> festivalesPorProvincia = new ArrayList<>();
        for (Festival festival : listaFestivales) {
            if (nombreProvincia == festival.getProvincia()) {
                festivalesPorProvincia.add(festival);
            }
        }
        return festivalesPorProvincia;
    }

}
