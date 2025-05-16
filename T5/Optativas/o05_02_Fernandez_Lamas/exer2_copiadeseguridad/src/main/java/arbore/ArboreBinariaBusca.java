package arbore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArboreBinariaBusca<T extends Comparable<T>> implements Comparable<T>, Iterable<T> {

    private T nodo;
    private ArboreBinariaBusca<T> izq;
    private ArboreBinariaBusca<T> der;

    public ArboreBinariaBusca() {
    }

    public void anhadirElemento(T elemento) {
        if (nodo == null) {
            this.setNodo(elemento);
        }
        if (this.nodo.compareTo(elemento) < 0) {
            if (this.der == null) {
                this.der = new ArboreBinariaBusca<>();
            }
            this.der.anhadirElemento(elemento);
        }
        else if (this.nodo.compareTo(elemento) > 0) {
            if (this.izq == null) {
                this.izq = new ArboreBinariaBusca<>();
            }
            this.izq.anhadirElemento(elemento);
        }
    }


    public List<T> recorridoInOrde() {
        List<T> listaDevolver = new ArrayList<>();
        if (izq != null) {
            listaDevolver.addAll(izq.recorridoInOrde());
            // List<T> listaIzq = izq.recorridoInOrde();
            // for (T t : listaIzq) {
            //     listaDevolver.add(t);
            // }
        }
        listaDevolver.add(nodo);
        if (der != null) {
            listaDevolver.addAll(der.recorridoInOrde());
            // List<T> listaDer = der.recorridoInOrde();
            // for (T t : listaDer) {
            //     listaDevolver.add(t);
            // }
        }
        return listaDevolver;
    }

    @Override
    public Iterator<T> iterator(){
        return new IteradorABB<>(this);
    }

    
    public T getNodo() {
        return nodo;
    }

    public void setNodo(T nodo) {
        this.nodo = nodo;
    }

    @Override
    public int compareTo(T elemento) {
        return nodo.compareTo(elemento);
    }
}
