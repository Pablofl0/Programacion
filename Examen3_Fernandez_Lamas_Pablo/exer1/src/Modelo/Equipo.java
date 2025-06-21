package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import Controlador.GestionGeneral;
import Modelo.Excepcions.ExcepcionCidadeNoValida;
import Modelo.Excepcions.ExcepcionEmailInvalido;
import Modelo.Excepcions.ExcepcionPlantillaChea;
import Modelo.Excepcions.ExcepcionXogadorNonLibre;

public class Equipo extends Usuario implements Serializable {
    private String nomeEquipo;
    private String cidade;
    private Provincia provincia;
    private ArrayList<Xogador> listaXogadores;

    public Equipo(String nomeEquipo, String cidade) throws ExcepcionEmailInvalido {
        super.setTipoUsuario(TipoUsuario.EQUIPO);
        super.setContrasenhaUsuario(TipoUsuario.EQUIPO);
        this.setNomeEquipo(nomeEquipo);
        this.setCidade(cidade);
        this.setProvinciaCsv(cidade);
        this.setcorreoUsuario();
        this.setListaXogadores(new ArrayList<>());
    }

    public void setcorreoUsuario() throws ExcepcionEmailInvalido {
        super.setcorreoUsuario(correoEquipo(this.nomeEquipo, this.cidade));
    }

    @Override
    public String toString() {
        return nomeEquipo + " de " + cidade;
    }

    private String correoEquipo(String nomeEquipo, String cidade) {
        String correoEquipo = nomeEquipo.toLowerCase() + "." + cidade.toLowerCase() + "@fgb.gal";
        return correoEquipo;
    }

    public String getNomeEquipo() {
        return nomeEquipo;
    }

    private void setNomeEquipo(String nomeEquipo) {
        this.nomeEquipo = nomeEquipo;
    }

    public String getCidade() {
        return cidade;
    }

    private void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    private void setProvincia(String cidade) {
        this.provincia = Provincia.CORUÑA;
    }

    private void setProvinciaCsv(String cidade) {

        // Try con resources
        try (BufferedReader reader = new BufferedReader(new FileReader("provincias.csv"))) {
            String liña;
            Provincia provincia = null;
            reader.readLine();
            while ((liña = reader.readLine()) != null) {
                // Separar a liña en campos usando a coma como delimitador
                String[] campos = liña.split(",");

                
                if (cidade == campos[0]) {
                    switch (campos[1]) {
                        case "Pontevedra":
                            provincia = Provincia.PONTEVEDRA;
                            break;
                        case "Ourense":
                            provincia = Provincia.OURENSE;
                            break;
                        case "Lugo":
                            provincia = Provincia.LUGO;
                            break;
                        case "A Coruña":
                            provincia = Provincia.CORUÑA;
                            break;
                        default:
                            break;
                    }
                }
            }
            if (provincia == null) {
                throw new ExcepcionCidadeNoValida();
            }
            this.provincia = provincia;
        } catch (ExcepcionCidadeNoValida e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public ArrayList<Xogador> getListaXogadores() {
        ArrayList<Xogador> listaXogadoresEquipo = new ArrayList<>();
        for (Xogador xogador : this.listaXogadores) {
            listaXogadoresEquipo.add(xogador);
        }
        return listaXogadoresEquipo;
    }

    public List<Xogador> getXogadoresOrdenadosEquipo() {
        // return this.getListaXogadores().stream().sorted(new Comparator<Xogador>() {
        // public int compare(Xogador x1, Xogador x2) {
        // return (int) (x1.getPuntuacionXogador() - x2.getPuntuacionXogador());
        // }
        // }).toList();
        return this.getListaXogadores().stream()
                .sorted((x, y) -> x.getPuntuacionXogador().compareTo(y.getPuntuacionXogador())).toList();

    }

    private void setListaXogadores(ArrayList<Xogador> listaXogadores) {
        this.listaXogadores = listaXogadores;
    }

    public void anhadirXogador(Xogador xogador) {
        this.listaXogadores.add(xogador);
    }

    public boolean plantillaChea() {
        if (this.listaXogadores.stream().count() >= 15) {
            return true;
        }
        return false;
    }

    public void xogarPartido() {
        for (Xogador xogador : listaXogadores) {
            xogador.sumarUnPartidoXogado();
            switch (xogador.getTipoXogador()) {
                case TipoXogador.BASE:
                    Random random = new Random();
                    Integer numeroAleatorio = random.nextInt((12 - 0) + 1) + 0;
                    xogador.sumarValorALaEstadistica(numeroAleatorio.doubleValue());
                    break;
                case TipoXogador.INTERIOR:
                    Random random2 = new Random();
                    Integer numeroAleatorio2 = random2.nextInt((15 - 0) + 1) + 0;
                    xogador.sumarValorALaEstadistica(numeroAleatorio2.doubleValue());
                    break;
                case TipoXogador.EXTERIOR:
                    Random random3 = new Random();
                    Integer numeroAleatorio3 = random3.nextInt((30 - 0) + 1) + 0;
                    xogador.sumarValorALaEstadistica(numeroAleatorio3.doubleValue());
                    break;
                default:
                    break;
            }
        }
    }
}
