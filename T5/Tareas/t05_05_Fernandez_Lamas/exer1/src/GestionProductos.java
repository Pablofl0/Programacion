
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class GestionProductos {

    private static GestionProductos INSTANCE; // Singleton

    private static HashMap<Integer, Producto> productos;

    // public static HashMap<Integer, Producto> getProductos() {
    //     return productos;
    // }

    public GestionProductos() {
        productos = new HashMap<>();
    }

    public static void anhadirProducto(Producto newProducto){
        productos.put(newProducto.getIdProducto(), newProducto);
    }

    public static Producto verProductoSegunID(int idProducto) throws ExcepcionGeneral{
        if (!productos.keySet().contains(idProducto)) {
            throw new ExcepcionGeneral("Identificador único no válido.");
        }
        return productos.get(idProducto);
    }

    public static void anhadirStockAUnProducto(int idProducto, int newStock) throws ExcepcionGeneral{
        verProductoSegunID(idProducto).anhadirStock(newStock);
    }

    public static void eliminarStockDeUnProducto(int idProducto, int stockAEliminar) throws ExcepcionGeneral{
        verProductoSegunID(idProducto).eliminarStock(stockAEliminar);
    }

    public static void comprarUnaUnidadDeUnProducto(int idProducto) throws ExcepcionGeneral{
        verProductoSegunID(idProducto).comprarUnaUnidad();
    }

    public Set<Integer> obtenerIdProductos() {
        return productos.keySet();
    }

    public static ArrayList<Producto> getProductos(){
        ArrayList<Producto> listaProductos = new ArrayList<>();
        for (int idProducto : productos.keySet()) {
            listaProductos.add(productos.get(idProducto));
        }
        return listaProductos;
    }

    public static ArrayList<Producto> getInstrumentos(){
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : productos.keySet()) {
            Producto productoNow = productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.flauta) || productoNow.getTipoProducto().equals(TipoProducto.saxofon) || productoNow.getTipoProducto().equals(TipoProducto.trombon)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public static ArrayList<Producto> getComplementos(){
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : productos.keySet()) {
            Producto productoNow = productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.libro) || productoNow.getTipoProducto().equals(TipoProducto.estuche)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public static ArrayList<Producto> getFlautas(){
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : productos.keySet()) {
            Producto productoNow = productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.flauta)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public static ArrayList<Producto> getSaxofones(){
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : productos.keySet()) {
            Producto productoNow = productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.saxofon)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public static ArrayList<Producto> getTrombones(){
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : productos.keySet()) {
            Producto productoNow = productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.trombon)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public static ArrayList<Producto> getLibros(){
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : productos.keySet()) {
            Producto productoNow = productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.libro)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }

    public static ArrayList<Producto> getEstuches(){
        ArrayList<Producto> lista = new ArrayList<>();
        for (int idProducto : productos.keySet()) {
            Producto productoNow = productos.get(idProducto);
            if (productoNow.getTipoProducto().equals(TipoProducto.estuche)) {
                lista.add(productoNow);
            }
        }
        return lista;
    }
    // public Optional<Usuario> obterUsuarioPorNome(String nombre) {
    //     for (String nombreUsuario : usuarios.keySet()) {
    //         if (nombreUsuario.equals(nombre)) {
    //             return Optional.of(usuarios.get(nombreUsuario));
    //         }
    //     }
    //     return Optional.empty();
    // }

    // Patrón Singleton
    public static GestionProductos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GestionProductos();
        }
        return INSTANCE;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
