package telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotFestivales extends TelegramLongPollingBot {
    private final String username = "MusicFestiBot";
    private final String token = "7844286221:AAGYW3H6Uh0OSCCy9vM-ujiCT0g__MhLW5k";

    public void onUpdateReceived(Update update) {
        update.getMessage().getText();
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

}
