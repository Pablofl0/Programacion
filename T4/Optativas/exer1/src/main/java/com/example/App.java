package com.example;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        File csvFile = new File("src/linguas.csv");

        // Ler CSV
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        Reader reader = new FileReader(csvFile);
        MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class).with(schema).readValues(reader);

        // Crear HashMap para almacenar os obxectos Frase
        HashMap<String, Frase> frasesMap = new HashMap<>();

        // Crear obxectos Frase e engadilos ao HashMap
        while (it.hasNext()) {
            Map<String, String> row = it.next();
            String id = row.get("id");
            Frase fraseObj = new Frase(id);
            fraseObj.engadirTraducion("gal", row.get("gal"));
            fraseObj.engadirTraducion("esp", row.get("esp"));
            fraseObj.engadirTraducion("eng", row.get("eng"));
            frasesMap.put(id, fraseObj);
        }

        boolean encendido = true;
        while (encendido) {
            Config config;

            ObjectMapper objectMapper = new ObjectMapper();
            File configFile = new File("config.json");
            if (configFile.exists()) {
                config = objectMapper.readValue(configFile, Config.class);
            } else {
                // Retornar una configuración por defecto se non se atopa o ficheiro
                config = new Config();
            }
            System.out.println(frasesMap.get("saudo").getPalabraLengua(config.getLenguaSeleccionada()));
            System.out.println(frasesMap.get("menuInicio").getPalabraLengua(config.getLenguaSeleccionada()));
            System.out.println("\ta)" + frasesMap.get("cambiarLingua").getPalabraLengua(config.getLenguaSeleccionada()));
            System.out.println("\tb)" + frasesMap.get("sair").getPalabraLengua(config.getLenguaSeleccionada()));
            System.out.print("> ");
            String opc = sc.nextLine();

            switch (opc) {
                case "a":
                    System.out.println(frasesMap.get("seleccionaLingua").getPalabraLengua(config.getLenguaSeleccionada()));
                    System.out.println("\ta)" + frasesMap.get("idioma").getPalabraLengua("gal"));
                    System.out.println("\tb)" + frasesMap.get("idioma").getPalabraLengua("esp"));
                    System.out.println("\tc)" + frasesMap.get("idioma").getPalabraLengua("eng"));
                    System.out.print("> ");
                    String opc2 = sc.nextLine();
                    switch (opc2) {
                        case "a":
                            config.setLenguaSeleccionada("gal");
                            // Guardar el archivo JSON con el nuevo valor
                            objectMapper.writeValue(configFile, config);
                            break;
                        case "b":
                            config.setLenguaSeleccionada("esp");
                            // Guardar el archivo JSON con el nuevo valor
                            objectMapper.writeValue(configFile, config);
                            break;
                        case "c":
                            config.setLenguaSeleccionada("eng");
                            // Guardar el archivo JSON con el nuevo valor
                            objectMapper.writeValue(configFile, config);
                            break;
                        default:
                            System.out.println(frasesMap.get("opcionInvalida").getPalabraLengua(config.getLenguaSeleccionada()));
                            break;
                    }
                    break;
                case "b":
                    System.out.println(frasesMap.get("despedida").getPalabraLengua(config.getLenguaSeleccionada()));
                    encendido = false;
                    break;
                default:
                    System.out.println(frasesMap.get("opcionInvalida").getPalabraLengua(config.getLenguaSeleccionada()));
                    break;
            }
        }

        sc.close();
    }
}
