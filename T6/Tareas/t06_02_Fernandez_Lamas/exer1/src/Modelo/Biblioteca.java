package Modelo;

public class Biblioteca {
    private String identificadorBiblioteca;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String provincia;

    

    public Biblioteca(String identificadorBiblioteca, String nombre, String direccion, String ciudad,
            String provincia) {
        this.setIdentificadorBiblioteca(identificadorBiblioteca);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setCiudad(ciudad);
        this.setProvincia(provincia);
    }

    @Override
    public String toString() {
        return this.getIdentificadorBiblioteca() + this.getNombre() + ", " + this.getDireccion() + "; " + this.getCiudad() + "(" + this.getProvincia() + ")";
    }

    public String getIdentificadorBiblioteca() {
        return identificadorBiblioteca;
    }

    public void setIdentificadorBiblioteca(String identificadorBiblioteca) {
        this.identificadorBiblioteca = identificadorBiblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    

}
