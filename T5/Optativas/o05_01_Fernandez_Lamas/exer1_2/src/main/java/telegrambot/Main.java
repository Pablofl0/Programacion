package telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {public static void main(String[] args) {
    // Registra o bot
    try {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new BotFestivales("7844286221:AAGYW3H6Uh0OSCCy9vM-ujiCT0g__MhLW5k"));
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}