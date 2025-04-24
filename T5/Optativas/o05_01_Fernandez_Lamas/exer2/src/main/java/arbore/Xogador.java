package arbore;

public class Xogador implements Comparable<Xogador> {

    private String nome;
    private int dorsal;

    public Xogador(String nome, int dorsal) {
        this.nome = nome;
        this.dorsal = dorsal;
    }

    @Override
    public String toString() {
        return dorsal + ": " + nome;
    }

    @Override
    public int compareTo(Xogador xogador) {
        return this.dorsal - xogador.getDorsal();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

}
