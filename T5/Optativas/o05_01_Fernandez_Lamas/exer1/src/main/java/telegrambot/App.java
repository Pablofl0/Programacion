package telegrambot;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Registra o bot
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new BotFestivales());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
