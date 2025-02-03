package Concesionario;

import dawutils.TipoCombustible;

public class Vehiculo {
    private static int númeroObjetos = 0;
    private static double velocidadMax = 120;

    private String matricula;
    private String marca;
    private String modelo;
    private double velocidad;
    private TipoCombustible tipoCombustible;


    
    public Vehiculo(String matricula, String marca, String modelo, double velocidad, TipoCombustible tipoCombustible) {
        if (validarMatricula(matricula)) {
            this.matricula = matricula;
        }
        else{
            this.matricula = "0000XXX";
        }
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
        if (tipoCombustible == TipoCombustible.DIÉSEL) {
            this.tipoCombustible = 
        }
        this.tipoCombustible = tipoCombustible;
    }

    public static int getNúmeroObjetos() {
        return númeroObjetos;
    }

    public static void setNúmeroObjetos(int númeroObjetos) {
        Vehiculo.númeroObjetos = númeroObjetos;
    }

    public static double getVelocidadMax() {
        return velocidadMax;
    }

    public static void setVelocidadMax(double velocidadMax) {
        Vehiculo.velocidadMax = velocidadMax;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (validarMatricula(matricula)) {
            this.matricula = matricula;   
        }
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

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
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
        String letras = matricula.substring(4, 6);

        // Comprobar que son 4 números.
        for (int i = 0; i < numeros.length(); i++) {
            if ((int) numeros.charAt(i) < 0 || (int) numeros.charAt(i) > 9) {
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
