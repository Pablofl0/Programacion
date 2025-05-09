package Controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

import Excepciones.ExcepcionEjemplaresInsuficientes;
import Excepciones.ExcepcionGeneral;
import Excepciones.ExcepcionISBNNoValido;
import Excepciones.ExcepcionIdNoValido;
import Modelo.AdministradorBiblioteca;
import Modelo.AdministradorGeneral;
import Modelo.Cliente;
import Modelo.Libro;
import Modelo.TipoLengua;
import Modelo.TipoUsuario;
import Modelo.Usuario;
import Modelo.Biblioteca;

public class GestionGeneral {

    private static GestionGeneral INSTANCE; // Singleton

    private HashMap<Integer, Biblioteca> redDeBibliotecas;
    private HashMap<String, Usuario> usuarios;
    private HashMap<String, Libro> redDeLibros;

    private GestionGeneral() {
        this.usuarios = new HashMap<>();
        this.redDeBibliotecas = new HashMap<>();
        this.redDeLibros = new HashMap<>();
        this.anhadirDatosDePrueba();
    }

    //Métodos de la red de Bibliotecas.
    public void anhadirBiblioteca(String nombre, String direccion, String ciudad, String provincia) {
        Biblioteca newBiblioteca = new Biblioteca(nombre, direccion, ciudad, provincia);
        this.redDeBibliotecas.put(newBiblioteca.getIdentificadorBiblioteca(), newBiblioteca);
    }

    public Biblioteca verBibliotecaSegunID(Integer id) throws ExcepcionIdNoValido {
        if (!this.redDeBibliotecas.keySet().contains(id)) {
            throw new ExcepcionIdNoValido();
        }
        return this.redDeBibliotecas.get(id);
    }

    public ArrayList<Biblioteca> getBibliotecas() {
        ArrayList<Biblioteca> listaBibliotecas = new ArrayList<>();
        for (int idProducto : this.redDeBibliotecas.keySet()) {
            listaBibliotecas.add(this.redDeBibliotecas.get(idProducto));
        }
        return listaBibliotecas;
    }

    public void anhadirEjemplaresAUnaBiblioteca(Integer identificadorDeBiblioteca, int numeroDeEjemplares, Libro libro) throws ExcepcionEjemplaresInsuficientes{
        this.redDeBibliotecas.get(identificadorDeBiblioteca).anhadirEjemplares(numeroDeEjemplares, libro);
    }

    public void anhadirLibro(String titulo, String autor, TipoLengua lengua, String editorial, String ISBN,
    Integer numeroDeEjemplares) throws ExcepcionISBNNoValido {
        Libro newLibro = new Libro(titulo, autor, lengua, editorial, ISBN, numeroDeEjemplares);
        this.redDeLibros.put(ISBN, newLibro);
    }


    //Métodos de clientes.
    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        for (String idUsuario : this.usuarios.keySet()) {
            if (this.usuarios.get(idUsuario).getTipoUsuario().equals(TipoUsuario.CLIENTE)) {
                listaClientes.add((Cliente) this.usuarios.get(idUsuario));
            }
        }
        return listaClientes;
    }

    public Cliente getClienteSegunDNI(String dni) {
        for (Cliente cliente : this.getClientes()) {
            if (cliente.getDni().equals(dni)) {
                
            }
        }
    }

    public void anhadirUnPrestamoAUnCliente(String nombreCliente, Libro libroPrestado, String fechaPrestamo) {

    }

    private void anhadirDatosDePrueba() {
        try {
            this.anhadirAdministrador("Pepe", "AAAAAAaaaa1");
            this.anhadirCliente("Juan", "AAAAAaaaa2");
            Flauta flauta = new Flauta(10, 10, "adsga", "sdfsa", "dsfas", false);
            this.anhadirProducto(flauta);
            Saxofon saxofon = new Saxofon(10, 10, "adsga", "sdfsa", "dsfas", TipoSaxo.alto);
            this.anhadirProducto(saxofon);
            Trombon trombon = new Trombon(10, 10, "adsga", "sdfsa", "dsfas", false);
            this.anhadirProducto(trombon);
            Estuche estuche = new Estuche(10, 10, "nosf", "lsjf", TipoInstrumento.flauta);
            this.anhadirProducto(estuche);
            Libro libro = new Libro(10, 10, "ksdfj", "fksajf", "sdfs", "1000000001");
            this.anhadirProducto(libro);
        } catch (ExcepcionISBNNoValido | ExcepcionStockNegativo | ExcepcionGeneral | ExcepcionPrecioNegativo
                | ExcepcionRegistroUsuario e) {

        }
    }

    // //Añade el usuario, sea cliente o admin, a la tabla de usuarios.
    // public void anhadirUsuario(Usuario newUsuario) {
    // this.usuarios.put(newUsuario.getNombreUsuario(), newUsuario);
    // }
    public void anhadirCliente(String nombreUsuario, String contrasenhaUsuario)
            throws ExcepcionRegistroUsuario, ExcepcionGeneral {
        if (existeNombreUsuario(nombreUsuario)) {
            throw new ExcepcionRegistroUsuario();
        }
        Cliente newCliente = new Cliente(nombreUsuario, contrasenhaUsuario);
        this.usuarios.put(nombreUsuario, newCliente);
    }

    public void anhadirAdministrador(String nombreUsuario, String contrasenhaUsuario)
            throws ExcepcionRegistroUsuario, ExcepcionGeneral {
        if (existeNombreUsuario(nombreUsuario)) {
            throw new ExcepcionRegistroUsuario();
        }
        AdministradorGeneral newAdmin = new AdministradorGeneral(nombreUsuario, contrasenhaUsuario);
        this.usuarios.put(nombreUsuario, newAdmin);
    }

    public void InicioDeSesionValido(String nombre, String contrasenha) throws ExcepcionGeneral {
        if (!(this.usuarios.containsKey(nombre) && this.usuarios.get(nombre).coincideContrasenha(contrasenha))) {
            throw new ExcepcionGeneral("No ha sido posible iniciar sesión.");
        }
    }

    // Registrarse
    // public boolean registroValido(String nombreUsuario, String con1, String
    // con2){
    // return ((!(existeNombreUsuario(nombreUsuario))) && contrasenhaValida(con1) &&
    // coincidenCon1YCon2(con1, con2));
    // }
    // public boolean existeNombreUsuario(String nombreUsuario) {
    // return
    // (GestionUsuarios.getInstance().obtenerNombreUsuarios().contains(nombreUsuario));
    // }
    // public boolean contrasenhaValida(String contrasenhaUsuario) {
    // Pattern pattern =
    // Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
    // Matcher matcher = pattern.matcher(contrasenhaUsuario);
    // return matcher.matches();
    // }
    // private static boolean coincidenCon1YCon2(String con1, String con2) {
    // return (con1.equals(con2));
    // }
    // Iniciar sesión.
    public TipoUsuario getTipoUsuario(String nombreUsuario) {
        return this.usuarios.get(nombreUsuario).getTipoUsuario();
    }

    public boolean existeNombreUsuario(String nombreUsuario) {
        return (this.usuarios.keySet().contains(nombreUsuario));
    }

    public boolean coincidenCon1YCon2(String con1, String con2) {
        return (con1.equals(con2));
    }

    public Set<String> obtenerNombreUsuarios() {
        return this.usuarios.keySet();
    }

    public Optional<Usuario> obterUsuarioPorNome(String nombre) {
        for (String nombreUsuario : usuarios.keySet()) {
            if (nombreUsuario.equals(nombre)) {
                return Optional.of(usuarios.get(nombreUsuario));
            }
        }
        return Optional.empty();
    }

    public void anhadirProducto(Producto newProducto) {
        this.productos.put(newProducto.getIdProducto(), newProducto);
    }

    public Producto verProductoSegunID(int idProducto) throws ExcepcionIdNoValido {
        if (!this.productos.keySet().contains(idProducto)) {
            throw new ExcepcionIdNoValido();
        }
        return this.productos.get(idProducto);
    }

    public void anhadirStockAUnProducto(int idProducto, int newStock) throws ExcepcionIdNoValido {
        verProductoSegunID(idProducto).anhadirStock(newStock);
    }

    public void eliminarStockDeUnProducto(int idProducto, int stockAEliminar)
            throws ExcepcionEliminarStockDeMas, ExcepcionIdNoValido {
        verProductoSegunID(idProducto).eliminarStock(stockAEliminar);
    }

    public void comprarUnaUnidadDeUnProducto(int idProducto)
            throws ExcepcionComprarProductoSinStock, ExcepcionIdNoValido {
        verProductoSegunID(idProducto).comprarUnaUnidad();
    }

    public Set<Integer> obtenerIdProductos() {
        return this.productos.keySet();
    }

    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        for (int idProducto : this.productos.keySet()) {
            listaProductos.add(this.productos.get(idProducto));
        }
        return listaProductos;
    }

    public ArrayList<Producto> getInstrumentos() {
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : this.productos.keySet()) {
            Producto productoNow = this.productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.flauta)
                    || productoNow.getTipoProducto().equals(TipoProducto.saxofon)
                    || productoNow.getTipoProducto().equals(TipoProducto.trombon)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public ArrayList<Producto> getComplementos() {
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : this.productos.keySet()) {
            Producto productoNow = this.productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.libro)
                    || productoNow.getTipoProducto().equals(TipoProducto.estuche)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public ArrayList<Producto> getFlautas() {
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : this.productos.keySet()) {
            Producto productoNow = this.productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.flauta)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public ArrayList<Producto> getSaxofones() {
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : this.productos.keySet()) {
            Producto productoNow = this.productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.saxofon)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public ArrayList<Producto> getTrombones() {
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : this.productos.keySet()) {
            Producto productoNow = this.productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.trombon)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public ArrayList<Producto> getLibros() {
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : this.productos.keySet()) {
            Producto productoNow = this.productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.libro)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public ArrayList<Producto> getEstuches() {
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : this.productos.keySet()) {
            Producto productoNow = this.productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.estuche)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    // Patrón Singleton
    public static GestionGeneral getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GestionGeneral();
        }
        return INSTANCE;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
