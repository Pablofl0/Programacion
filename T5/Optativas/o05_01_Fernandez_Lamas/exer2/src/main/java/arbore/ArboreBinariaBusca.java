package arbore;

public class ArboreBinariaBusca<T extends Comparable<T>> {
    private Nodo<T> nodoRaiz;
    

    public void anhadirElemento (T elemento){
        Nodo<T> nodoNow = this.nodoRaiz;
        if (nodoNow.equals(null)) {
            this.setNodoRaiz(nodoNow);
        }
        else{
            
        }
    }


    public Nodo<T> getNodoRaiz() {
        return nodoRaiz;
    }


    public void setNodoRaiz(Nodo<T> nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }

    
}
