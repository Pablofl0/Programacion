package com.stream;

import java.time.LocalDate;

public record Song(LocalDate date, Integer position, String song, String artist, long duration_ms) {
    
}
