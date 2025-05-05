package com.stream;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.MappingIterator;
// import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public final class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        File csvFile = new File("spotify.csv");

        // Ler CSV
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        Reader reader = new FileReader(csvFile);
        MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class).with(schema).readValues(reader);

        // Crear HashMap para almacenar os obxectos Frase
        List<List<String>> record = new ArrayList<>();

        // Crear obxectos Frase e engadilos ao HashMap
        int contador = 0;
        while (it.hasNext()) {
            Map<String, String> row = it.next();
            record.add(new ArrayList<String>());
            record.get(contador).add(row.get("date"));
            record.get(contador).add(row.get("position"));
            record.get(contador).add(row.get("song"));
            record.get(contador).add(row.get("artist"));
            record.get(contador).add(row.get("duration_ms"));
            // String id = row.get("id");
            // Frase fraseObj = new Frase(id);
            // fraseObj.engadirTraducion("gal", row.get("gal"));
            // fraseObj.engadirTraducion("esp", row.get("esp"));
            // fraseObj.engadirTraducion("eng", row.get("eng"));
            // frasesMap.put(id, fraseObj);
            contador++;
        }

        // 1-Imprime os artistas que tiveron un número 1 no ano 2023.

         DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // record.stream().filter(c -> LocalDate.parse(c.get(0), formato).getYear() == 2023 && c.get(1).equals("1")).forEach(c -> System.out.println(c));
        
        // // 2-Indica o número de canción diferentes que foron número 1 en 2024.

        // System.out.println(record.stream().filter(c -> LocalDate.parse(c.get(0), formato).getYear() == 2024 && c.get(1).equals("1")).map(c -> c.get(2)).distinct().count());

        // 3-Indica as cancións de “Aitana” que estiveron nas 10 primeiras posicións das
        // máis escoitadas.

        // record.stream().filter(c -> (c.get(3).equals("Aitana") && (Integer.valueOf(c.get(1)) >= 1 && Integer.valueOf(c.get(1)) <= 10))).forEach(c -> System.out.println(c));

        // 4-Indica as cancións que foron máis escoitadas durante o mes de agosto de 2024.

        // record.stream().filter(c -> LocalDate.parse(c.get(0), formato).getMonth().equals(Month.AUGUST)).sorted((x,y) -> x.get(1).compareTo(y.get(1))).map(c -> c.get(2)).distinct().limit(5).forEach(c -> System.out.println(c));
        // record.stream().filter(c -> LocalDate.parse(c.get(0), formato).getMonth().equals(Month.AUGUST)).sorted((x,y) -> y.get(4).compareTo(x.get(4))).map(c -> c.get(2)).distinct().limit(5).forEach(c -> System.out.println(c));

        // 5-Indica as posicións diferentes que obtiveron as cancións de “Aitan"a”
        // ordenadas de menor a maior nunha cadea de texto separada por comas

        // System.out.println(record.stream().filter(c -> (c.get(3).equals("Aitana"))).sorted((x,y) -> Integer.valueOf(x.get(1)).compareTo(Integer.valueOf(y.get(1)))).map(c -> c.get(1)).distinct().collect(Collectors.joining(", ")));
        // record.stream().filter(c -> (c.get(3).equals("Aitana"))).sorted((x,y) -> Integer.valueOf(x.get(1)).compareTo(Integer.valueOf(y.get(1)))).map(c -> c.get(1)).distinct().collect(Collectors.joining(", "));

        // 6-Indica a posición máis alta de escoitadas que chegou unha canción de “Cris
        // Mj”.

        // System.out.println(record.stream().filter(c -> (c.get(3).contains("Cris Mj"))).map(c -> c.get(1)).min(Comparator.comparing(c -> Integer.valueOf(c))));

        // 7-Agrupa as cancións por artista nun map.

        record.stream()
            .filter(c -> (c.get(3).equals("Aitana")))
            .map(c -> c);

        // 8-Indica a número de cancións que superan os 6 minutos que estiveron nas 5
        // primeiras posicións.

        // for (List<String> list : record) {
        //     System.out.println(list);
        // }

        sc.close();

    }
}
