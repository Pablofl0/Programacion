import Concesionario.Vehiculo;
import dawutils.TipoCombustible;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(Vehiculo.getNúmeroObjetos()); // 0
        
        Vehiculo leon = new Vehiculo("1234CGF", "SEAT", "León");
        System.out.println(Vehiculo.getNúmeroObjetos()); // 1
        Vehiculo c3 = new Vehiculo("6894DEF", "Citroen", "C3", TipoCombustible.ELÉCTRICO);
        System.out.println(Vehiculo.getNúmeroObjetos()); // 2

        System.out.println(leon.getMatricula() + " " + leon.getTipoCombustible()); // 1234CGF GASOLINA
        System.out.println(c3.getMatricula() + " " + c3.getTipoCombustible()); // 0000XXX ELECTRICO

        leon.acelerarVar(20);
        leon.acelerar();
        System.out.println(leon.getVelocidad()); // 30.0

        leon.acelerarVar(100);
        System.out.println(leon.getVelocidad()); // 120.0

        leon.decelerar();
        leon.decelerarVar(200);
        System.out.println(leon.getVelocidad()); // 0.0

        Vehiculo.setVelocidadMax(130);

        leon.acelerarVar(125);
        System.out.println(leon.getVelocidad()); // 125.0

    }

}
