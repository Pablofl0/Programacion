package com.example;

import java.util.HashMap;

public class Frase {
    private String identificadorFrase;
    private HashMap<String,String> frases;
    
    public Frase(String identificadorFrase) {
        this.identificadorFrase = identificadorFrase;
        this.frases = new HashMap<String,String>();
    }

    public void engadirTraducion(String lingua, String frase){
        this.frases.put(lingua, frase);
    }

    public String getIdentificadorFrase() {
        return identificadorFrase;
    }

    public String getPalabraLengua(String lengua){
        return this.frases.get(lengua);
    }

    public HashMap<String, String> getFrases() {
        return frases;
    }
}
