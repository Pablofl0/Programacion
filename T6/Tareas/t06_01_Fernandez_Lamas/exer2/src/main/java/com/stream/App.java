package com.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String rutaFicheiro = "spotify.csv";
        ArrayList<Song> datos = new ArrayList<>();

        // Try con resources
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaFicheiro))) {
            String liña;
            reader.readLine();
            while ((liña = reader.readLine()) != null) {
                // Separar a liña en campos usando a coma como delimitador
                String[] campos = liña.split(",");

                Song newSong = new Song(LocalDate.parse(campos[0], formato), Integer.valueOf(campos[1]), campos[2],
                        campos[3], Long.valueOf(campos[5]));
                datos.add(newSong);
            }
        } catch (IOException e) {
            System.out.println(e);
        }


        // 1-Imprime os artistas que tiveron un número 1 no ano 2023.

        datos.stream()
        .filter(c -> c.date().getYear() == 2023 && c.position() == 1)
        .forEach(c -> System.out.println(c));

        // // 2-Indica o número de canción diferentes que foron número 1 en 2024.

        long cancionesNumeroUno = datos.stream()
        .filter(c ->c.date().getYear() == 2024 && c.position() == 1)
        .map(c -> c.song())
        .distinct()
        .count();

        System.out.println(cancionesNumeroUno);

        // 3-Indica as cancións de “Aitana” que estiveron nas 10 primeiras posicións das
        // máis escoitadas.

        datos.stream()
        .filter(c -> (c.artist().equals("Aitana") && (c.position() >= 1 &&
        c.position() <= 10)))
        .forEach(c -> System.out.println(c));

        // 4-Indica as cancións que foron máis escoitadas durante o mes de agosto de
        // 2024.

        datos.stream()
        .filter(c -> c.date().getMonth().equals(Month.AUGUST) && c.date().getYear()
        == 2024 && c.position() == 1)
        .distinct().forEach(c -> System.out.println(c));

        // 5-Indica as posicións diferentes que obtiveron as cancións de “Aitan"a”
        // ordenadas de menor a maior nunha cadea de texto separada por comas

        String posicionesAitana = datos.stream()
        .filter(c -> (c.artist().equals("Aitana")))
        .sorted((x,y) -> x.position().compareTo(y.position()))
        .map(c -> String.valueOf(c.position()))
        .distinct()
        .collect(Collectors.joining(", "));

        System.out.println(posicionesAitana);

        // 6-Indica a posición máis alta de escoitadas que chegou unha canción de “Cris
        // Mj”.

        Optional<Integer> posicionMj = datos.stream()
        .filter(c -> (c.artist().contains("Cris Mj")))
        .map(c -> c.position())
        .min(Comparator.comparing(c -> c));

        System.out.println(posicionMj.get());

        // 7-Agrupa as cancións por artista nun map.

        Map<String, List<Song>> mapaCanciones = datos.stream()
            .collect(Collectors.groupingBy(c -> c.artist()));

        for (String song : mapaCanciones.keySet()) {
            System.out.println(song + ": " + mapaCanciones.get(song).stream().map(c -> c.song()).distinct().collect(Collectors.joining(", ")));
        }

        // 8-Indica a número de cancións que superan os 6 minutos que estiveron nas 5
        // primeiras posicións.

        Long numeroCancioneslargas = datos.stream()
                .filter(c -> (c.position() >= 1 && c.position() <= 5) && c.duration_ms() > 360000)
                .count();

        System.out.println(numeroCancioneslargas);

        sc.close();

    }
}
