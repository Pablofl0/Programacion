public class App {
    public static void main(String[] args) throws Exception {
        Empleado Manuel = new Empleado("55026812R" , "Manuel", "Valera", "López", 1500);

        System.out.println(Manuel.getDNI());

        Manuel.setDNI("55026811R");

        System.out.println(Manuel.getApellidos() + ", " + Manuel.getNombre() + " con " + Manuel.getDNI() +  " tiene un salario neto de " + Manuel.getSalarioNeto() + ".");
    }
}
