package Concesionario;

import dawutils.TipoCombustible;

public class Vehiculo {
    private static int númeroObjetos = 0;
    private static int velocidadMax = 120;

    private String matricula;
    private String marca;
    private String modelo;
    private int velocidad;
    private TipoCombustible tipoCombustible;


    /**
     * 
     * @param matricula matrícula del coche
     * @param marca marca del coche
     * @param modelo modelo del coche
     * @param velocidad velocidad del coche
     * @param tipoCombustible tipo de combustible
     */
    public Vehiculo(String matricula, String marca, String modelo) {
        if (validarMatricula(matricula)) {
            this.setMatricula(matricula);
        }
        else{
            this.setMatricula("0000XXX");
        }
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setVelocidad(0);
        this.setTipoCombustible(TipoCombustible.GASOLINA);
        Vehiculo.sumNumero();
    }

    /**
     * 
     * @param matricula matrícula del coche
     * @param marca marca del coche
     * @param modelo modelo del coche
     * @param tipoCombustible tipo de combustible
     */
    public Vehiculo(String matricula, String marca, String modelo, TipoCombustible tipoCombustible) {
        if (validarMatricula(matricula)) {
            this.setMatricula(matricula);
        }
        else{
            this.setMatricula("0000XXX");
        }
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setTipoCombustible(tipoCombustible);
        Vehiculo.sumNumero();
    }



    private void modificar(int var){
        this.velocidad = velocidad + var;
        if (velocidad < 0) {
            this.velocidad = 0;
        }
        else if (velocidad > velocidadMax) {
            this.velocidad = 120;
        }
    }
    public void acelerar(){
        int var = 10;
        this.modificar(var);;
    }
    public void acelerarVar(int var){
        this.modificar(var);;
    }
    public void decelerar(){
        int var = -10;
        this.modificar(var);;
    }
    public void decelerarVar(int var){
        this.modificar(-var);;
    }




    public static int getNúmeroObjetos() {
        return númeroObjetos;
    }

    public static void setNúmeroObjetos(int númeroObjetos) {
        Vehiculo.númeroObjetos = númeroObjetos;
    }

    public static void sumNumero(){
        Vehiculo.númeroObjetos += 1;
    }

    public static int getVelocidadMax() {
        return velocidadMax;
    }

    public static void setVelocidadMax(int velocidadMax) {
        Vehiculo.velocidadMax = velocidadMax;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
            this.matricula = matricula;   
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    private static boolean validarMatricula(String matricula) {
        if (matricula.length() != 7) {
            return false;
        }

        // Cogemos los números y las letras.
        String numeros = matricula.substring(0, 4);
        String letras = matricula.substring(4, 7);

        // Comprobar que son 4 números.
        for (int i = 0; i < numeros.length(); i++) {
            if ((int)numeros.charAt(i) < 0 || (int)numeros.charAt(i) > 9) {
                return false;
            }
        }

        // Comprobar que son 3 letras.
        for (int i = 0; i < letras.length(); i++) {
            if ((int) letras.charAt(i) < (int) 'B' || (int) letras.charAt(i) > (int) 'Z') {
                return false;
            }
        }

        // Comprobar que no hay vocales.
        int vocales[] = { (int) 'E', (int) 'I', (int) 'O', (int) 'U' };
        for (int i = 0; i < letras.length(); i++) {
            for (int k = 0; k < vocales.length; k++) {
                if ((int) letras.charAt(i) == vocales[k]) {
                    return false;
                }
            }
        }

        // Todo está en orde
        return true;

    }
}
