public class Rectangulo {
    private double altura;
    private double ancho;

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getAncho() {
        return ancho;
    }
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    /**
     * 
     * @param altura Altura del rectángulo
     * @param ancho Ancho del rectángulo
     */
    public Rectangulo(double altura, double ancho) {
        this.altura = altura;
        this.ancho = ancho;
    }

    //Métodos
    /**
     * 
     * @return perímetro del rectángulo
     */
    public double perimetro(){
        return (2*altura + 2*ancho);
    }
    /**
     * 
     * @return área del rectángulo
     */
    public double area(){
        return (altura*ancho);
    }

    


}
