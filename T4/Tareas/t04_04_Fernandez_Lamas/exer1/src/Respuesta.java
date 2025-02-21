public class Respuesta {
    private String contenido;
    private double veces;
    private final double zero = 0;


    
    public Respuesta(String contenido) {
        setContenido(contenido);
        this.veces = zero;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        if (contenido.length() > 0) {
            this.contenido = contenido;
        }
    }

    public double getVeces() {
        return veces;
    }


    public void sumar1vez(){
        this.veces += 1;
    }

}
