package Modelo;

import java.io.Serializable;

public class Oferta implements Serializable {
    private Equipo equipo;
    private Xogador xogador;

    public Oferta(Equipo equipo, Xogador xogador) {
        this.equipo = equipo;
        this.xogador = xogador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Xogador getXogador() {
        return xogador;
    }

    public void setXogador(Xogador xogador) {
        this.xogador = xogador;
    }

}
