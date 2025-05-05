package com.stream;

import java.time.LocalDate;

public record Song(LocalDate date, int position, String song, String artist, long duration_ms) {
    
}
