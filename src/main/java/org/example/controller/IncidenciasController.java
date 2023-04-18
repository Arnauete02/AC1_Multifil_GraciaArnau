package org.example.controller;

import org.example.model.Habitacion;
import org.example.utils.Constants;
import org.example.utils.EstadoHabitacion;
import org.example.utils.Files;
import org.example.view.PanelHotel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Set;
import java.util.TreeSet;

public class IncidenciasController implements Runnable {
    private PanelHotel panelHotel;

    public IncidenciasController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Constants.INCIDENCIAS));
            String line = reader.readLine();

            while (line != null) {
                try {
                    String[] valores = line.split(" ");
                    char tipoAveria = valores[0].charAt(0);

                    Thread.sleep(Integer.parseInt(valores[1]));

                    Set<Habitacion> habitaciones = panelHotel.getHotel().getHabitaciones();

                    switch (tipoAveria) {
                        case 'P':
                            for (Habitacion habitacion : habitaciones) {
                                if ((Integer.parseInt(valores[2]) / 100) == (habitacion.getNumero() / 100)) {
                                    habitacion.setDisponible(EstadoHabitacion.AVERIADA);
                                }
                            }
                            break;
                        case 'A':
                            for (Habitacion habitacion : habitaciones) {
                                if (habitacion.getNumero() == Integer.parseInt(valores[2])) {
                                    habitacion.setDisponible(EstadoHabitacion.AVERIADA);
                                }
                            }
                            break;
                        default:
                            System.err.println("Incidencia no reconocida: " + line);
                            break;
                    }

                    Thread.sleep(500);

                    line = reader.readLine();
                } catch (ConcurrentModificationException e) {
                    throw new RuntimeException(e);
                }
            }

            reader.close();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
