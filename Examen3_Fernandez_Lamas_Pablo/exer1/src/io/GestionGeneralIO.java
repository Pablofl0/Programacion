package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

import Controlador.GestionGeneral;

public class GestionGeneralIO {

    private static final String FILENAME = "data.bin";

    public static void gardar(GestionGeneral cadea){
        try {

            // Crear fluxo de saída para gardar o obxecto
            FileOutputStream ficheiro = new FileOutputStream(FILENAME);
            ObjectOutputStream obxecto = new ObjectOutputStream(ficheiro);

            // Serializar o obxecto
            obxecto.writeObject(cadea);

            // Pechar os fluxos
            obxecto.close();
            ficheiro.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Optional<GestionGeneral> cargar(){
        try {
            // Crear fluxo de entrada para ler o obxecto
            FileInputStream ficheiro = new FileInputStream(FILENAME);
            ObjectInputStream obxecto = new ObjectInputStream(ficheiro);

            // Deserializar o obxecto
            GestionGeneral cadea = (GestionGeneral) obxecto.readObject();

            // Pechar os fluxos
            obxecto.close();
            ficheiro.close();

            return Optional.of(cadea);

        } catch (Exception e) {
            return Optional.empty();
        }
    }

}