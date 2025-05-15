package arbore.arbores;

import java.util.Iterator;
import java.util.List;

public class IteradorABB<T extends Comparable<T>> implements Iterator<T>{
    private List<T> lista;
    private int posicion = 0;

    public IteradorABB(ArboreBinariaBusca abb) {
        this.setLista(abb.recorridoInOrde());
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public T next(){
        T elemntoActual = lista.get(posicion);
        posicion += 1;
        return elemntoActual;
    }
    
    public boolean hasNext() {
        if (posicion < lista.size()) {
            return true;
        }
        return false;
    }
}
