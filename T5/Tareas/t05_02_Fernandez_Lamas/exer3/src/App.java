import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
        ArrayList<Tenista> tenistas = new ArrayList<Tenista>();
        ArrayList<Piloto> pilotos = new ArrayList<Piloto>();
        ArrayList<PilotoF1> pilotosCoches = new ArrayList<PilotoF1>();
        ArrayList<PilotoMotoGP> pilotosMotos = new ArrayList<PilotoMotoGP>();

        Tenista alcaraz = new Tenista("Carlos Jonás Alcaraz", "Carlos Alcaraz", "23/05/2003", 3);
        deportistas.add(alcaraz);
        tenistas.add(alcaraz);
        Tenista novak = new Tenista("Novak Djokovic", "Djokovic", "22/05/1987", 2);
        deportistas.add(novak);
        tenistas.add(novak);

        PilotoF1 alonso = new PilotoF1("Fernando Alonso Díaz", "Fernando Alonso", "29/07/1981", "Aston Martin", 33, 26, 22);
        deportistas.add(alonso);
        pilotos.add(alonso);
        pilotosCoches.add(alonso);

        PilotoF1 max = new PilotoF1("Max Emilian Verstappen", "Verstappen", "30/09/1997", "Red Bull Racing", 62, 33, 40);
        deportistas.add(max);
        pilotos.add(max);
        pilotosCoches.add(max);

        PilotoMotoGP marquez = new PilotoMotoGP("Marc Márquez Alentà", "Marc Márquez", "17/02/1993", "Grenesi Racing", 102.0);
        deportistas.add(marquez);
        pilotos.add(marquez);
        pilotosMotos.add(marquez);

        PilotoMotoGP bagnaia = new PilotoMotoGP("Francesco Bagnaia", "Bagnaia", "14/01/1997", "Ducati Lenovo Team", 461.0);
        deportistas.add(bagnaia);
        pilotos.add(bagnaia);
        pilotosMotos.add(bagnaia);

        Collections.sort(deportistas);
        for(Deportista elemento: deportistas ){
            System.out.println(elemento);
        }
        System.out.println("-----------");
        for(Piloto elemento: pilotos ){
            System.out.println(elemento);
        }
        System.out.println("-----------");
        for(Tenista elemento: tenistas ){
            System.out.println(elemento);
        }
        System.out.println("-----------");
        for(PilotoF1 elemento: pilotosCoches ){
            System.out.println(elemento);
        }
        System.out.println("-----------");
        for(PilotoMotoGP elemento: pilotosMotos ){
            System.out.println(elemento);
        }

    }
}