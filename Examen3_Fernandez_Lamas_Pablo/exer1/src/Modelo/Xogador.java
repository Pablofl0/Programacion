package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Modelo.Excepcions.ExcepcionEmailInvalido;
import Modelo.Excepcions.ExcepcionNoOfertaDeEquipo;
import Modelo.Excepcions.ExcepcionPlantillaChea;
import Modelo.Excepcions.ExcepcionXogadorNonLibre;

public class Xogador extends Usuario implements Comparable<Xogador>, Serializable {
    private TipoXogador tipoXogador;
    private String nomeDeportivo;
    private Equipo equipoAsignado;
    private Double numeroPartidosXogados;
    private Double valorNumericoDeLaEstadistica;
    private Double puntuacionXogador;
    private ArrayList<Oferta> listaOfertas;

    public Xogador(String correoUsuario, TipoXogador tipoXogador, String nomeDeportivo)
            throws ExcepcionEmailInvalido {
        super(correoUsuario, TipoUsuario.XOGADOR);
        this.setTipoXogador(tipoXogador);
        this.setNomeDeportivo(nomeDeportivo);
        this.setEquipoAsignado(null);
        this.setNumeroPartidosXogados(0.0);
        this.setValorNumericoDeLaEstadistica(0.0);
        this.setPuntuacionXogador();
        this.listaOfertas = new ArrayList<>();
    }

    @Override
    public int compareTo(Xogador outro) {
        if (this.nomeDeportivo.toLowerCase().compareTo(outro.nomeDeportivo.toLowerCase()) < 0) {
            return -1;
        }
        else if (this.nomeDeportivo.toLowerCase().compareTo(outro.nomeDeportivo.toLowerCase()) > 0) {
            return 1;
        }
        else if (this.nomeDeportivo.toLowerCase().compareTo(outro.nomeDeportivo.toLowerCase()) == 0) {
            if (this.puntuacionXogador < outro.puntuacionXogador) {
                return -1;
            }
            else if (this.puntuacionXogador > outro.puntuacionXogador) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String posicion = "";
        switch (tipoXogador) {
            case BASE:
                posicion = "Base";
                break;
            case INTERIOR:
                posicion = "Interior";
                break;
            case EXTERIOR:
                posicion = "Exterior";
                break;
            default:
                break;
        }
        return nomeDeportivo + " | " + this.getcorreoUsuario() + " | " + posicion;
    }

    private Double mediaPuntuacionPorPartido() {
        Double media = 0.0;
        if (numeroPartidosXogados == 0) {
            return media;
        }
        media = this.valorNumericoDeLaEstadistica / numeroPartidosXogados;
        return media;
    }

    public TipoXogador getTipoXogador() {
        return tipoXogador;
    }

    public void setTipoXogador(TipoXogador tipoXogador) {
        this.tipoXogador = tipoXogador;
    }

    public String getNomeDeportivo() {
        return nomeDeportivo;
    }

    public void setNomeDeportivo(String nomeDeportivo) {
        this.nomeDeportivo = nomeDeportivo;
    }

    public Equipo getEquipoAsignado() {
        return equipoAsignado;
    }

    public void setEquipoAsignado(Equipo equipoAsignado) {
        this.equipoAsignado = equipoAsignado;
    }

    public Double getNumeroPartidosXogados() {
        return numeroPartidosXogados;
    }

    public void setNumeroPartidosXogados(Double numeroPartidosXogados) {
        this.numeroPartidosXogados = numeroPartidosXogados;
    }

    public void sumarUnPartidoXogado() {
        this.numeroPartidosXogados++;
    }

    public Double getValorNumericoDeLaEstadistica() {
        return valorNumericoDeLaEstadistica;
    }

    public void setValorNumericoDeLaEstadistica(Double valorNumericoDeLaEstadistica) {
        this.valorNumericoDeLaEstadistica = valorNumericoDeLaEstadistica;
        this.setPuntuacionXogador();
    }

    public void sumarValorALaEstadistica(Double valor) {
        this.valorNumericoDeLaEstadistica += valor;
        this.setPuntuacionXogador();
    }

    public Double getPuntuacionXogador() {
        return puntuacionXogador;
    }

    public void setPuntuacionXogador() {
        switch (tipoXogador) {
            case BASE:
                this.puntuacionXogador = this.mediaPuntuacionPorPartido() * 2;
                break;
            case INTERIOR:
                this.puntuacionXogador = this.mediaPuntuacionPorPartido() * 1.5;
                break;
            case EXTERIOR:
                this.puntuacionXogador = this.mediaPuntuacionPorPartido() * 0.75;
                break;
            default:
                break;
        }
    }

    public ArrayList<Oferta> getListaOfertas() {
        ArrayList<Oferta> listaOfertasGet = new ArrayList<>();
        for (Oferta oferta : this.listaOfertas) {
            listaOfertasGet.add(oferta);
        }
        return listaOfertasGet;
    }

    public List<Equipo> getEquiposOfertas() {
        return this.getListaOfertas().stream().map(c -> c.getEquipo()).toList();
    }

    public void anhadirOferta(Equipo equipo) {
        this.listaOfertas.add(new Oferta(equipo, this));
    }

    public boolean isXogadorLibre() {
        if (this.getEquipoAsignado() == null) {
            return true;
        }
        return false;
    }

    public void aceptarOferta(Equipo equipoDeOferta) throws ExcepcionNoOfertaDeEquipo, ExcepcionPlantillaChea {
        if (!listaOfertas.stream().map(c -> c.getEquipo()).toList().contains(equipoDeOferta)) {
            throw new ExcepcionNoOfertaDeEquipo();
        }
        if (equipoDeOferta.plantillaChea()) {
            throw new ExcepcionPlantillaChea();
        }
        this.setEquipoAsignado(equipoDeOferta);
        this.equipoAsignado.anhadirXogador(this);
        this.listaOfertas = new ArrayList<>();
    }
}
