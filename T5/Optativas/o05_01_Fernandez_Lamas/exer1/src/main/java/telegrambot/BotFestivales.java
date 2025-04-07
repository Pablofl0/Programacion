package telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotFestivales extends TelegramLongPollingBot {
    private final String botUsername;
    private final String botToken;

    public BotFestivales(String botToken, String botUsername) {
        super(botToken); // Pass the bot token to the superclass constructor
        this.botToken = botToken;
        this.botUsername = botUsername;
    }

    public void onUpdateReceived(Update update) {
        String textoEntrante = update.getMessage().getText();
        String idDelMensajeEntrante = String.valueOf(update.getMessage().getChatId());
        SendMessage mensajeDevuelto = new SendMessage(idDelMensajeEntrante, textoEntrante);
        try {
            execute(mensajeDevuelto);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

    

}
