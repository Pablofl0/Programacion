package telegrambot;

import java.util.List;

public interface DAOFestival {
    List<Festival> getFestivales();
    Festival getProximoFestival();
    List<Festival> getFestivaisProvincia(Provincia provincia);  
} 