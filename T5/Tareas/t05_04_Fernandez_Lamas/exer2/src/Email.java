import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String correo;

    public Email(String correo) throws ExcepcionEmailInvalido{
        this.setCorreo(correo);
    }

    @Override
    public String toString() {
        return this.getDominio(correo) + ": " + this.getConta(correo);
    }

    public boolean comprobarEmail(String correo) {
        Pattern pattern = Pattern.compile("^([A-Za-z0-9._%+-]+)@([A-Za-z0-9.-]+\\.[A-Za-z]{2,6})$");
        Matcher matcher = pattern.matcher(correo);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public String getDominio(String correo){
        Pattern pattern = Pattern.compile("^([A-Za-z0-9._%+-]+)@([A-Za-z0-9.-]+\\.[A-Za-z]{2,6})$");
        Matcher matcherDominio = pattern.matcher(correo);
        String dominio = null;
        if (matcherDominio.matches()) {
            dominio = matcherDominio.group(2);
        }
        // String dominio = correo.substring(correo.indexOf("@") + 1);
        return dominio;
    }

    public String getConta(String correo){
        Pattern pattern = Pattern.compile("^([A-Za-z0-9._%+-]+)@([A-Za-z0-9.-]+\\.[A-Za-z]{2,6})$");
        Matcher matcherConta = pattern.matcher(correo);
        String conta = null;
        if (matcherConta.matches()) {
            conta = matcherConta.group(1);
        } 
        return conta;
    }


    public String getMessageError(String correo){
        return ("Esta cadena no es un correo: " + correo + ".");
    }
    // public String getConta(String correo){
    //     String conta = correo.substring(0, correo.indexOf("@"));
    //     return conta;
    // }

    public void setCorreo(String correo) throws ExcepcionEmailInvalido{
        if (!comprobarEmail(correo)) {
            throw new ExcepcionEmailInvalido(getMessageError(correo));
        }
        this.correo = correo;
    }
}
