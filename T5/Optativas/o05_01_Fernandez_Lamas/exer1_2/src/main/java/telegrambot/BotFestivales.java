package telegrambot;

import java.io.File;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BotFestivales extends TelegramLongPollingBot {

    private final String botUsername = "MusicFestiBot";
    private final String botToken = "7844286221:AAGYW3H6Uh0OSCCy9vM-ujiCT0g__MhLW5k";
    private DAOFestival daoFest;

    public BotFestivales(String botToken) {
        super(botToken); // Pass the bot token to the superclass constructor
        this.daoFest = configurarFuenteDeDatos();
    }

    // Método para decidir la fuente de datos según config.json
    private DAOFestival configurarFuenteDeDatos() {
        try {

            // Leer el archivo de configuración
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File("C:/Clase/NOUNI/Programacion/T5/Optativas/o05_01_Fernandez_Lamas/exer1_2/src/main/java/telegrambot/config.json"));

            String dataSource = rootNode.path("data_source").asText();

            // Decidir la fuente de datos
            if ("memory".equals(dataSource)) {
                // Implementación en memoria
                System.out.println("Cargando datos desde memoria...");
                return new DAOFestivalMemoria(); 
            } else if ("db".equals(dataSource)) {
                // Implementación de base de datos
                System.out.println("Cargando datos desde la base de datos...");
                return new DAOFestivalDB();
            } else {
                throw new IllegalArgumentException("Fuente de datos desconocida: " + dataSource);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al configurar la fuente de datos.");
        }
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
