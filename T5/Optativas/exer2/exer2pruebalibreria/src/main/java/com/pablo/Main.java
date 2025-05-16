package com.pablo;

import arbore.arbores.ArboreBinariaBusca;

public class Main {
    public static void main(String[] args) {
        ArboreBinariaBusca<String> arbore = new ArboreBinariaBusca<>();
        
        arbore.anhadirElemento("Lionel Messi");
        arbore.anhadirElemento("Cristiano Ronaldo");
        arbore.anhadirElemento("Neymar Jr.");
        arbore.anhadirElemento("Kylian Mbappé");
        arbore.anhadirElemento("Zlatan Ibrahimovic");
        arbore.anhadirElemento("Robert Lewandowski");
        arbore.anhadirElemento("Sergio Ramos");
        arbore.anhadirElemento("Kevin De Bruyne");
        arbore.anhadirElemento("Mohamed Salah");
        arbore.anhadirElemento("Erling Haaland");

        for (String string : arbore) {
            System.out.println(string);
        }
    }
}