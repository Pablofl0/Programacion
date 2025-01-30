

public class Empleado {
    private String DNI;
    private String Nombre;
    private String Apellido;
    private String Apellido2;
    private double Salario;
    private boolean tieneDNI;
    final static int IRPF = 15;

    private boolean comprobarDNI(String DNI) {
        if (DNI.length() == 9) {
            return true;
        } else {
            return false;
        }
    }


    public void setDNI(String DNI) {
        if (comprobarDNI(DNI)) {
            this.DNI = DNI;
            this.tieneDNI = true;
        }
        else{
            this.tieneDNI = false;
        }
    }

    public String getDNI(){
        if (this.tieneDNI) {
            return this.DNI;
        }
        return "Sin información";
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public String getApellidos(){
        return Apellido + Apellido2;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }

    public static int getIrpf() {
        return IRPF;
    }

    public double getSalarioNeto(){
        return this.Salario * ((100-IRPF)/100);
    }
}
