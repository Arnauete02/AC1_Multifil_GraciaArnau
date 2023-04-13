package org.example.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Files {
    public static String[] leerArchivo(String rutaArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String lineaActual;

            while ((lineaActual = br.readLine()) != null) {
                lineas.add(lineaActual);
            }
        }

        return lineas.toArray(new String[lineas.size()]);
    }
}
