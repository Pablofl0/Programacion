package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Excepciones.ExcepcionGeneral;

public abstract class Usuario {

    private String nombreUsuario;
    private String contrasenhaUsuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String correo;
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasenhaUsuario, TipoUsuario tipoUsuario) throws ExcepcionGeneral {
        this.setNombreUsuario(nombreUsuario);
        this.setContrasenhaUsuario(contrasenhaUsuario);
        this.setTipoUsuario(tipoUsuario);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    private void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    // public void setNombreUsuario(String nombreUsuario) throws ExcepcionGeneral {
    //     if (existeNombreUsuario(nombreUsuario)) {
    //         throw new ExcepcionGeneral("El nombre de Usuario ya está en uso.");
    //     }
    //     this.nombreUsuario = nombreUsuario;
    // }

    public String getContrasenhaUsuario() {
        return contrasenhaUsuario;
    }

    private void setContrasenhaUsuario(String contrasenhaUsuario) throws ExcepcionGeneral {
        if (!contrasenhaValida(contrasenhaUsuario)) {
            throw new ExcepcionGeneral("La contraseña no es válida.");
        }
        this.contrasenhaUsuario = contrasenhaUsuario;
    }

    private boolean contrasenhaValida(String contrasenhaUsuario) {
        // Expresión regular para validar la contraseña
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z0-9]{8,}$";

        // Verificar si la contraseña coincide con el patrón
        return Pattern.matches(regex, contrasenhaUsuario);
        // Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*0-9)[a-zA-Z0-9]{8,}");
        // Matcher matcher = pattern.matcher(contrasenhaUsuario);
        // return matcher.matches();
    }


    public boolean coincideContrasenha(String contrasenha) {
        return contrasenha.equals(this.contrasenhaUsuario);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellidos() {
        return apellido1 + apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (comprobarDNI(dni)) {
            this.dni = dni;
        }
    }

    public static boolean comprobarDNI(String DNI){
        if (DNI.length() != 9) {
            return false;
        }

        // Collemos os números é a letra
        String numeros = DNI.substring(0, 8);
        char letra = DNI.charAt(8);

        // Comprobamos que todolos dixitos son números
        for (int i = 0; i < numeros.length(); i++) {
            if (!((int) numeros.charAt(i) >= (int) '0' && (int) numeros.charAt(i) <= (int) '9')) {
                return false;
            }
        }

        // Comprobamos que a letra sexa minúcula
        if (!((int) letra >= (int) 'A' && (int) letra <= (int) 'Z')) {
            return false;
        }

        // Collemos os numeros como un enteiro
        int numero = Integer.parseInt(numeros);

        // Calculamos o resto
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numero % letras.length();

        // Collemos a letra real
        char letraReal = letras.charAt(resto);

        // Se as letras son diferentes
        if (letra != letraReal) {
            return false;
        }

        // Si todo está correcto que devuelva true.
        return true;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean comprobarEmail(String correo) {
        Pattern pattern = Pattern.compile("^([A-Za-z0-9._%+-]+)@([A-Za-z0-9.-]+\\.[A-Za-z]{2,6})$");
        Matcher matcher = pattern.matcher(correo);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    private void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
;
}
