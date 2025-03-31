import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Email> listaEmails = new ArrayList<>();
        ArrayList<Email> listaEmailsSanClemente = new ArrayList<>();

        String[] emails = {
                "maria.gomez@iessanclemente.net",
                "juan.perez@gmail.com",
                "laura.fernandez@iessanclemente.net",
                "laura.fernandeziessanclemente.net",
                "carlos.rodriguez@yahoo.com",
                "ana.martinez@iessanclemente.net",
                "pedro.lopez@hotmail.com",
                "sofia.rivas@iessanclemente.net",
                "miguel.vazquez@outlook.com",
                "paula.castro@iessanclemente.net",
                "david.sanchez@protonmail.com",
                "david.sanchez@protonmail"
        };

        //Creando Emails.
        for (int i = 0; i < emails.length; i++) {
            try {
                Email newEmail = new Email(emails[i]);
                listaEmails.add(newEmail);
                EmailSanClemente newEmailSanClemente = new EmailSanClemente(emails[i]);
                listaEmailsSanClemente.add(newEmailSanClemente);
            } catch (ExcepcionEmailInvalido excepcion) {
                    System.out.println(excepcion.getMessage());
            }
        }

        //Imprimiendo lista de emails.
        for (Email email : listaEmails) {
            System.out.println(email);
        }

        //Imprimiendo lista de emails de San Clemente.
        for (Email email : listaEmailsSanClemente) {
            System.out.println(email);
        }

        // for (int i = 0; i < emails.length; i++) {
        // try {
        // EmailSanClemente newEmailSanClemente = new EmailSanClemente(emails[i]);
        // listaEmailsSanClemente.add(newEmailSanClemente);
        // } catch (ExcepcionEmailInvalido excepcionEmailSanClemente) {
        // try {
        // Email newEmail = new Email(emails[i]);
        // listaEmails.add(newEmail);
        // } catch (ExcepcionEmailInvalido excepcionEmail) {
        // System.out.println(excepcionEmail.getMessage());
        // }

        // }
        // }

    }
}
