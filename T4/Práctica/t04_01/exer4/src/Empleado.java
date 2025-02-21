

public class Empleado {
    private String DNI;
    private String Nombre;
    private String Apellido;
    private String Apellido2;
    private double Salario;
    private boolean tieneDNI;
    final static int IRPF = 15;

    
    public Empleado(String nombre, String apellido, double salario) {
        Nombre = nombre;
        Apellido = apellido;
        Salario = salario;
        
    }

    public Empleado(String dNI, String nombre, String apellido, double salario) {
        DNI = dNI;
        Nombre = nombre;
        Apellido = apellido;
        Salario = salario;
        
    }

    public Empleado(String dNI, String nombre, String apellido, String apellido2, double salario) {
        DNI = dNI;
        Nombre = nombre;
        Apellido = apellido;
        Apellido2 = apellido2;
        Salario = salario;
        
    }

    private boolean comprobarDNI(String DNI){
        if (DNI.length() != 9) {
            return false;
        }

        // Collemos os números é a letra
        String numeros = DNI.substring(0, 8);
        char letra = DNI.charAt(8);

        // Comprobamos que todolos dixitos son números
        for(int i=0; i< numeros.length(); i++){
            if (!((int)numeros.charAt(i) >= (int)'0' && (int)numeros.charAt(i) <= (int)'9')) {
                return false;
            }
        }

        // Comprobamos que a letra sexa minúcula
        if (!((int)letra >= (int)'A' && (int)letra <= (int)'Z')) {
            return false;
        }

        // Collemos os numeros como un enteiro
        int numero = Integer.valueOf(numeros);

        // Calculamos o resto
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numero % letras.length();

        // Collemos a letra real
        char letraReal = letras.charAt(resto);

        // Se as letras son diferentes
        if (letra != letraReal) {
            return false;
        }

        // Todo está en orde
        return true;

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
        return Apellido + " " +  Apellido2;
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
