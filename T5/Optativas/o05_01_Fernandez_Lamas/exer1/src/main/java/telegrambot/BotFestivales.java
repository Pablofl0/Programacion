package telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import telegrambot.DAO.DAOFestival;

public class BotFestivales extends TelegramLongPollingBot {

    private final String botUsername = "MusicFestiBot";
    private final String botToken = "7844286221:AAGYW3H6Uh0OSCCy9vM-ujiCT0g__MhLW5k";
    private DAOFestival daoFest;

    public BotFestivales(String botToken) {
        super(botToken); // Pass the bot token to the superclass constructor
        this.daoFest = new DAOFestivalMemoria();
    }

    public void onUpdateReceived(Update update) {
        String textoEntrante = update.getMessage().getText();
        String[] partes = textoEntrante.split(" ");
        String comando = partes[0];
        if (partes.length > 1) {
            String argumentos = partes[1];
        }
        String idDelMensajeEntrante = String.valueOf(update.getMessage().getChatId());
        switch (comando) {
            case "/help":
                comandoHelp();
                break;
            case "/ver":
                comandoHelp();
                break;
            case "/proximo":
                comandoHelp();
                break;
            case "/provincia":
                comandoHelp();
                break;
            default:
                throw new AssertionError();
        }
        SendMessage mensajeDevuelto = new SendMessage(idDelMensajeEntrante, textoEntrante);
        try {
            execute(mensajeDevuelto);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void comandoHelp() {
        System.out.println("/help muestra un mensaje de ayuda de todos los comandos.\n/ver indica todos los festivales.\n/proximo indica el próximo festival.\n/provincia $1 indica los festivales de cada provincia, donde:\n- 'c' será para A Coruña.\n- 'l' será para Lugo.\n- 'o' será para Ourense.\n- 'p' para Pontevedra.");
    }

    private void comandoVer(){

    }

    

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

}
