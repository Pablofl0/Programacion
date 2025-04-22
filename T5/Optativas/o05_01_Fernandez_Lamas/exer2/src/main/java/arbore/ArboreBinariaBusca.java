package arbore;

public class ArboreBinariaBusca<T extends Comparable<T>> implements Comparable<T> {

    private T nodo;
    private ArboreBinariaBusca<T> izq;
    private ArboreBinariaBusca<T> der;

    public ArboreBinariaBusca(T nodo) {
        this.nodo = nodo;
    }

    public void anhadirElemento(T elemento) {
        if (nodo == null) {
            nodo = elemento;
        }
        if (this.nodo.compareTo(elemento) < 0) {
            this.der.setNodo(elemento);
        }
        else if (this.nodo.compareTo(elemento) > 0) {
            this.izq.setNodo(elemento);
        }
    }


    
    public T getNodo() {
        return nodo;
    }

    public void setNodo(T nodo) {
        this.nodo = nodo;
    }

    @Override
    public int compareTo(T elemento) {
        return this.nodo.compareTo(elemento);
    }
}
