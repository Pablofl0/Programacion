import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSanClemente extends Email{
    public EmailSanClemente(String correo) throws ExcepcionEmailInvalido{
        super(correo);
    }

    @Override
    public boolean comprobarEmail(String correo) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@iessanclemente.net");
        Matcher matcher = pattern.matcher(correo);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    @Override
    public String getMessageError(String correo){
        return ("Esta cadena no es un correo de San Clemente: " + correo + ".");
    }
}
