public class Cadrado {
    private double lado;

    /**
     * 
     * @param lado en metros
     */
    public Cadrado(double lado) {
        this.setLado(lado, UnidadeDistancia.M);
    }

    /**
     * 
     * @param lado o tamaño do lado
     * @param unidade a unidade de medida do lado
     */
    public Cadrado(double lado, UnidadeDistancia unidade){
        this.setLado(lado, unidade);
    }

    /**
     * Método que devolve o perimetro do cadrado
     * @param unidade Unidade de medida do resultado que se devolve
     * @return o perímetro
     */
    public double getPerimetro(UnidadeDistancia unidade) {
        if(unidade == UnidadeDistancia.DM) {
            return (this.lado * 10) * 4;
        }
        else if (unidade == UnidadeDistancia.CM) {
            return (this.lado * 100) * 4;
        }
        else if (unidade == UnidadeDistancia.KM) {
            return (this.lado / 1000) * 4;
        }
        else {
            return this.lado * 4;
        }
    }

    /**
     * Devolve a area do cadrado
     * @param unidade de medida na que se devolve a área
     * @return a área do cadrado
     */
    public double getArea(UnidadeDistancia unidade){
        if(unidade == UnidadeDistancia.DM) {
            return (this.lado * 10) * (this.lado * 10);
        }
        else if (unidade == UnidadeDistancia.CM) {
            return (this.lado * 100) * (this.lado * 100);
        }
        else if (unidade == UnidadeDistancia.KM) {
            return (this.lado / 1000) * (this.lado / 1000);
        }
        else {
            return this.lado * this.lado;
        }
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado, UnidadeDistancia unidade) {
        if(unidade == UnidadeDistancia.DM) {
            this.lado = lado / 10;
        }
        else if (unidade == UnidadeDistancia.CM) {
            this.lado = lado / 100; 
        }
        else if (unidade == UnidadeDistancia.KM) {
            this.lado = lado * 1000;
        }
        else {
            this.lado = lado;
        }
    }

}