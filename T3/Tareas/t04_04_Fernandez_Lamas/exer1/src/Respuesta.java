public class Respuesta {
    private String contenido;
    private double veces = 0;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public double getVeces() {
        return veces;
    }


    public void sumar1vez(){
        this.veces += 1;
    }

}
