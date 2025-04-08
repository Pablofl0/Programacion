package telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import telegrambot.DAO.DAOFestival;

public class BotFestivales extends TelegramLongPollingBot {

    private final String botUsername = "MusicFestiBot";
    private final String botToken = "7844286221:AAGYW3H6Uh0OSCCy9vM-ujiCT0g__MhLW5k";
    private DAOFestival daoFest = new DAOFestivalMemoria();

    public BotFestivales(String botToken) {
        super(botToken); // Pass the bot token to the superclass constructor
        this.daoFest = new DAOFestivalMemoria();
    }

    public void onUpdateReceived(Update update) {
        String textoEntrante = update.getMessage().getText();
        String[] partes = textoEntrante.split(" ");
        String comando = partes[0];
        String argumentos = null;
        if (partes.length > 1) {
            argumentos = partes[1];
        }
        String idDelMensajeEntrante = String.valueOf(update.getMessage().getChatId());
        String mensajeComando = "";
        switch (comando) {
            case "/help":
                mensajeComando = comandoHelp();
                break;
            case "/ver":
                for (Festival festival : daoFest.getFestivales()) {
                    mensajeComando = mensajeComando + "- " + festival + "\n";
                }
                break;
            case "/proximo":
                Festival proximoFestival = daoFest.getProximoFestival();
                mensajeComando = proximoFestival.toString();
                break;
            case "/provincia":
                switch (argumentos) {
                    case "$c":
                        for (Festival festival : daoFest.getFestivaisProvincia(NombreProvincia.CORUÑA)) {
                            mensajeComando = mensajeComando + "- " + festival + "\n";
                        }
                        break;
                    case "$l":
                        for (Festival festival : daoFest.getFestivaisProvincia(NombreProvincia.LUGO)) {
                            mensajeComando = mensajeComando + "- " + festival + "\n";
                        }
                        break;
                    case "$o":
                        for (Festival festival : daoFest.getFestivaisProvincia(NombreProvincia.OURENSE)) {
                            mensajeComando = mensajeComando + "- " + festival + "\n";
                        }
                        break;
                    case "$p":
                        for (Festival festival : daoFest.getFestivaisProvincia(NombreProvincia.PONTEVEDRA)) {
                            mensajeComando = mensajeComando + "- " + festival + "\n";
                        }
                        break;
                    default:
                        break;
                }
                break;
            default:
                mensajeComando = comandoHelp();
                break;
        }
        SendMessage mensajeDevuelto = new SendMessage(idDelMensajeEntrante, mensajeComando);
        try {
            execute(mensajeDevuelto);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private String comandoHelp() {
        return ("/help muestra un mensaje de ayuda de todos los comandos.\n/ver indica todos los festivales.\n/proximo indica el próximo festival.\n/provincia $1 indica los festivales de cada provincia, donde:\n- 'c' será para A Coruña.\n- 'l' será para Lugo.\n- 'o' será para Ourense.\n- 'p' para Pontevedra.");
    }

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

}
