public abstract class Componente extends Producto{

    public Componente(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }
    

    public static double bytesToGigaBytes(long  bytes){
        double bytesDouble = (double) bytes;
        return bytesDouble / 1000;
    }

    public static long  gigaBytesToBytes(double gigaBytes){
        long gigaBytesLong = (long) gigaBytes;
        return gigaBytesLong * 1000;
    }

    public static double hzToMhz(long  hz){
        double hzDouble = (double) hz;
        return hzDouble / 1000000;
    }

    public static long  gigaHzToHz(double ghz){
        long ghzLong = (long) ghz;
        return ghzLong * 1000;
    }
}
