package org.example.controller;

import org.example.model.Habitacion;
import org.example.utils.EstadoHabitacion;
import org.example.utils.Files;
import org.example.view.PanelHotel;

import java.io.IOException;
import java.util.Set;

public class IncidenciasController implements Runnable {
    private PanelHotel panelHotel;

    public IncidenciasController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {
        try {
            String[] lineas = Files.leerArchivo("C:\\Users\\Arnau\\Documents\\intellij\\m09\\AC1_Multifil_GraciaArnau\\src\\files\\incidencias.txt");
            String[] valores = null;

            for (String linea : lineas) {
                valores = linea.split(" ");

                Thread.sleep(Integer.parseInt(valores[1]));

                if (valores[0].equals("P")) {
                    for (Habitacion habitacion : panelHotel.getHotel().getHabitaciones()) {
                        if ((Integer.parseInt(valores[2]) / 100) == (habitacion.getNumero() / 100)) {
                            habitacion.setDisponible(EstadoHabitacion.AVERIADA);
                        }
                    }
                } else if (valores[0].equals("A")) {
                    for (Habitacion habitacion : panelHotel.getHotel().getHabitaciones()) {
                        if (habitacion.getNumero() == Integer.parseInt(valores[2])) {
                            habitacion.setDisponible(EstadoHabitacion.AVERIADA);
                        }
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
