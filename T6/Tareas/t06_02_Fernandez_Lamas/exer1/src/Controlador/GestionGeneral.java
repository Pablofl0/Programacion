package Controlador;

import Excepciones.ExcepcionBibliotecaNoEnLaRed;
import Excepciones.ExcepcionClienteConPrestamos;
import Excepciones.ExcepcionClienteSancionado;
import Excepciones.ExcepcionClienteSinPrestamos;
import Excepciones.ExcepcionDNIExistente;
import Excepciones.ExcepcionDNIInexistente;
import Excepciones.ExcepcionEjemplaresInsuficientes;
import Excepciones.ExcepcionEmailInvalido;
import Excepciones.ExcepcionGeneral;
import Excepciones.ExcepcionISBNNoExistente;
import Excepciones.ExcepcionISBNNoValido;
import Excepciones.ExcepcionISBNRepetido;
import Excepciones.ExcepcionIdNoValido;
import Excepciones.ExcepcionNoLibrosPorAutor;
import Excepciones.ExcepcionNoLibrosPorTitulo;
import Excepciones.ExcepcionRedDeBibliotecasVacia;
import Excepciones.ExcepcionRedDeLibrosVacia;
import Excepciones.ExcepcionRegistroUsuario;
import Modelo.AdministradorBiblioteca;
import Modelo.AdministradorGeneral;
import Modelo.Biblioteca;
import Modelo.Cliente;
import Modelo.Libro;
import Modelo.TipoLengua;
import Modelo.TipoUsuario;
import Modelo.Usuario;
import io.GestionGeneralIO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GestionGeneral implements Serializable {

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

    // Métodos de préstamos.
    public void anhadirUnPrestamoAUnCliente(String dni, String isbnLibroDelEjemplarParaPrestar, String fechaPrestamo, Biblioteca bibliotecaDelAdminBiblio) throws ExcepcionClienteSancionado ,ExcepcionDNIInexistente, ExcepcionClienteConPrestamos{
        if (this.getClienteSegunDNI(dni).isEmpty()) {
            throw new ExcepcionDNIInexistente();
        }
        this.getClienteSegunDNI(dni).get().anhadirPrestamo(bibliotecaDelAdminBiblio.getListaEjemplaresSinPrestar().stream().filter(c -> c.getLibro().getISBN().equals(isbnLibroDelEjemplarParaPrestar)).findFirst().get(), fechaPrestamo);
        this.gardar();
    }

    public void devolverPrestamoDeUnCliente(String dni, String fechaDevolucion) throws ExcepcionClienteSinPrestamos{
        this.getClienteSegunDNI(dni).get().devolverPrestamoActual(fechaDevolucion);
        this.gardar();
    }

    // Métodos de la red de bibliotecas.
    public void anhadirBiblioteca(String nombre, String direccion, String ciudad, String provincia) {
        Biblioteca newBiblioteca = new Biblioteca(nombre, direccion, ciudad, provincia);
        this.redDeBibliotecas.put(newBiblioteca.getIdentificadorBiblioteca(), newBiblioteca);
        this.gardar();
    }

    public Biblioteca verBibliotecaSegunID(Integer id) throws ExcepcionIdNoValido {
        if (!this.redDeBibliotecas.keySet().contains(id)) {
            throw new ExcepcionIdNoValido();
        }
        return this.redDeBibliotecas.get(id);
    }

    public Optional<ArrayList<Biblioteca>> getBibliotecas() throws ExcepcionRedDeBibliotecasVacia {
        if (this.redDeBibliotecas.isEmpty()) {
            throw new ExcepcionRedDeBibliotecasVacia();
        }
        ArrayList<Biblioteca> listaBibliotecas = new ArrayList<>();
        for (int idProducto : this.redDeBibliotecas.keySet()) {
            listaBibliotecas.add(this.redDeBibliotecas.get(idProducto));
        }
        return Optional.of(listaBibliotecas);
    }

    public void anhadirEjemplaresAUnaBiblioteca(Integer identificadorDeBiblioteca, int numeroDeEjemplares, Libro libro)
            throws ExcepcionEjemplaresInsuficientes {
        this.redDeBibliotecas.get(identificadorDeBiblioteca).anhadirEjemplares(numeroDeEjemplares, libro);
        this.gardar();
    }

    // public Integer idDeBibliotecaMaximo() {
    //     // return int intvalue =
    //     // optionalint.get(this.redDeBibliotecas.keySet().stream().max(Comparator.comparing(c
    //     // -> c)));
    //     Integer maximo = null;
    //     for (Integer idBiblio : this.redDeBibliotecas.keySet()) {
    //         if (idBiblio > maximo || maximo == null) {
    //             maximo = idBiblio;
    //         }
    //     }
    //     return maximo;
    // }
    public Long idDeBibliotecaMaximo() {
        return this.redDeBibliotecas.keySet().stream().count();
    }

    // Métodos de red de libros.
    public void anhadirLibro(String titulo, String autor, TipoLengua lengua, String editorial, String ISBN,
            Integer numeroDeEjemplares) throws ExcepcionISBNNoValido, ExcepcionISBNRepetido {
        this.existeLibroEnLaRedDeLibros(ISBN);
        Libro newLibro = new Libro(titulo, autor, lengua, editorial, ISBN, numeroDeEjemplares);
        this.redDeLibros.put(ISBN, newLibro);
        this.gardar();
    }

    private boolean existeLibroEnLaRedDeLibros(String isbn) throws ExcepcionISBNRepetido {
        if (this.redDeLibros.keySet().contains(isbn)) {
            throw new ExcepcionISBNRepetido();
        }
        return false;
    }

    public Optional<ArrayList<Libro>> getLibros() throws ExcepcionRedDeLibrosVacia{
        if (this.redDeLibros.isEmpty()) {
            throw new ExcepcionRedDeLibrosVacia();
        }
        ArrayList<Libro> listaLibros = new ArrayList<>();
        for (String isbn : redDeLibros.keySet()) {
            listaLibros.add(this.redDeLibros.get(isbn));
        }
        return Optional.of(listaLibros);
    }

    public Libro existeLibroConISBN(String ISBN) throws ExcepcionISBNNoExistente {
        if (!this.redDeLibros.keySet().contains(ISBN)) {
            throw new ExcepcionISBNNoExistente();
        }
        return this.redDeLibros.get(ISBN);
    }
    // Métodos de clientes.
    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        for (String idUsuario : this.usuarios.keySet()) {
            if (this.usuarios.get(idUsuario).getTipoUsuario().equals(TipoUsuario.CLIENTE)) {
                listaClientes.add((Cliente) this.usuarios.get(idUsuario));
            }
        }
        return listaClientes;
    }

    // public Cliente getClienteSegunDNI(String dni) {
    //     Cliente clienteSegunDni = null;
    //     for (Cliente cliente : this.getClientes()) {
    //         if (cliente.getDni().equals(dni)) {
    //             clienteSegunDni = cliente;
    //         }
    //     }
    //     return clienteSegunDni;
    // }
    public Optional<Cliente> getClienteSegunDNI(String dni) {
        return this.getClientes().stream().filter(c -> c.getDni().equals(dni)).findFirst();
    }

    public Stream<Libro> librosPorTitulo(String titulo) throws ExcepcionRedDeLibrosVacia, ExcepcionNoLibrosPorTitulo {
        String regex = ".*" + titulo + ".*";

        Stream<Libro> librosPorTitulo = this.getLibros().get().stream()
        .filter(c -> Pattern.matches(regex,c.getTitulo()) && c.getEjemplaresDisponibles().size() > 0)
        .sorted();
        if (Optional.of(librosPorTitulo).isEmpty()) {
            throw new ExcepcionNoLibrosPorTitulo();
        }
        return librosPorTitulo;
    }

    public Stream<Libro> librosPorAutor(String autor) throws ExcepcionRedDeLibrosVacia, ExcepcionNoLibrosPorAutor {
        String regex = ".*" + autor + ".*";

        Stream<Libro> librosPorAutor = this.getLibros().get().stream()
        .filter(c -> Pattern.matches(regex,c.getAutor()) && c.getEjemplaresDisponibles().size() > 0)
        .sorted();
        if (Optional.of(librosPorAutor).isEmpty()) {
            throw new ExcepcionNoLibrosPorAutor();
        }
        return this.getLibros().get().stream()
                .filter(c -> c.getAutor().contains(autor) && c.getEjemplaresDisponibles().size() > 0)
                .sorted();
    }

    // Métodos de usuarios.
    public void anhadirCliente(String nombreUsuario, String contrasenhaUsuario, String nombre,
            String apellido1, String apellido2, String dni, String correo)
            throws ExcepcionRegistroUsuario, ExcepcionGeneral, ExcepcionEmailInvalido, ExcepcionDNIExistente {
        if (existeNombreUsuario(nombreUsuario)) {
            throw new ExcepcionRegistroUsuario();
        } else if (!getClienteSegunDNI(dni).isEmpty()) {
            throw new ExcepcionDNIExistente();
        }
        Cliente newCliente = new Cliente(nombreUsuario, contrasenhaUsuario, nombre, apellido1, apellido2, dni, correo);
        this.usuarios.put(nombreUsuario, newCliente);
        this.gardar();
    }

    private void anhadirAdministradorGeneral(String nombreUsuario, String contrasenhaUsuario, String nombre,
            String apellido1, String apellido2, String dni, String correo)
            throws ExcepcionGeneral, ExcepcionEmailInvalido, ExcepcionRegistroUsuario {
        if (existeNombreUsuario(nombreUsuario)) {
            throw new ExcepcionRegistroUsuario();
        }
        AdministradorGeneral newAdmin = new AdministradorGeneral(nombreUsuario, contrasenhaUsuario, nombre, apellido1,
                apellido2, dni, correo);
        this.usuarios.put(nombreUsuario, newAdmin);
        this.gardar();
    }

    public void anhadirAdministradorBiblioteca(String nombreUsuario, String contrasenhaUsuario, String nombre,
            String apellido1, String apellido2, String dni, String correo, Integer idBiblioteca)
            throws ExcepcionBibliotecaNoEnLaRed, ExcepcionGeneral, ExcepcionEmailInvalido, ExcepcionRegistroUsuario {
        if (existeNombreUsuario(nombreUsuario)) {
            throw new ExcepcionRegistroUsuario();
        } else if (!existeBiblioteca(idBiblioteca)) {
            throw new ExcepcionBibliotecaNoEnLaRed();
        }
        AdministradorBiblioteca newAdmin = new AdministradorBiblioteca(nombreUsuario, contrasenhaUsuario, nombre,
                apellido1, apellido2, dni, correo, this.redDeBibliotecas.get(idBiblioteca));
        this.usuarios.put(nombreUsuario, newAdmin);
        this.gardar();
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    // Añadir admin:abc123.
    private void anhadirDatosDePrueba() {
        try {
            this.anhadirAdministradorGeneral("admin", "abc123.", "Pablo", "Fernández", "Lamas", "34630933V",
                    "a24pablofl@ies.sanclemente.net");
            this.anhadirBiblioteca("sanbiblio", "sanbiblio", "sanbiblio", "sanbiblio");
            this.anhadirAdministradorBiblioteca("pepe", "abc123.", "pepe", "pepe", "pepe", "34968656P", "pepe@gmail.com", 1);
            this.anhadirCliente("jose", "abc123.", "jose", "jose", "jose", "34630934H", "jose@gmail.com");
        } catch (ExcepcionEmailInvalido | ExcepcionGeneral | ExcepcionRegistroUsuario | ExcepcionBibliotecaNoEnLaRed | ExcepcionDNIExistente e) {
            System.out.println(e.getMessage());
        }
    }

    // //Añade el usuario, sea cliente o admin, a la tabla de usuarios.
    // public void anhadirUsuario(Usuario newUsuario) {
    // this.usuarios.put(newUsuario.getNombreUsuario(), newUsuario);
    // }
    public void InicioDeSesionValido(String nombre, String contrasenha) throws ExcepcionGeneral {
        if (!(this.usuarios.keySet().contains(nombre) /*&& this.usuarios.get(nombre).coincideContrasenha(contrasenha)*/)) {
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

    public boolean existeBiblioteca(Integer idBiblioteca) {
        return (this.redDeBibliotecas.keySet().contains(idBiblioteca));
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

    // Patrón Singleton
    // public static GestionGeneral getInstance() {
    //     if (INSTANCE == null) {
    //         INSTANCE = new GestionGeneral();
    //     }
    //     return INSTANCE;
    // }

    // Metodo publico e estatico para poder acceder aos métodos da clase
    public static GestionGeneral getInstance() {
        // Se inda non se accedeu, inicializase
        if (INSTANCE == null) {

            // Intentamos cargar os restaurantes
            Optional<GestionGeneral> lectura = GestionGeneralIO.cargar();

            // Se non devolve nada, creamos unha nova cadea
            if (lectura.isEmpty()) {
                INSTANCE = new GestionGeneral();
                INSTANCE.gardar();

            }
            // Xa temos a cadea gardada
            else {
                INSTANCE = lectura.get();
            }
        }
        return INSTANCE;
    }

    /**
     * Garda os datos da cadea de restaurantes
     */
    public  void gardar() {
        GestionGeneralIO.gardar(INSTANCE);
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
