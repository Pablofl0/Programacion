package telegrambot.DAO;

import java.util.List;

import telegrambot.Festival;
import telegrambot.NombreProvincia;

public interface DAOFestival {
    List<Festival> getFestivales();
    Festival getProximoFestival();
    List<Festival> getFestivaisProvincia(NombreProvincia provincia);  
} 