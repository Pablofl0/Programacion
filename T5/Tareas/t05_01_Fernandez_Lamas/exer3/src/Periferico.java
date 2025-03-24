
import java.util.ArrayList;

public abstract class Periferico extends Producto{
    private ArrayList<Conector> conectores = new ArrayList<>();

    public Periferico(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }


    public void addConector(Conector conector){
        conectores.add(conector);
    }


    public String getConectoresString() {
        String mensaje = "";
        int i = 1;
        for (Conector conector : conectores) {
            mensaje = mensaje + conector;
            if (i != conectores.size()) {
                mensaje = mensaje + " "; 
            }
            i++;
        }
        return mensaje;
    }
}
