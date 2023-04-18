package org.example.controller;

import org.example.model.Habitacion;
import org.example.model.HabitacionBuilder;
import org.example.utils.Constants;
import org.example.utils.EstadoHabitacion;
import org.example.utils.Files;
import org.example.utils.TipoHabitacion;
import org.example.view.PanelHotel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class HotelController implements Runnable{
    private PanelHotel panelHotel;

    public HotelController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Constants.HABITACIONES));
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] valores = linea.split(" ");

                Habitacion habitacion = new HabitacionBuilder()
                        .setNumero(Integer.parseInt(valores[0]))
                        .setDisponible(EstadoHabitacion.valueOf(valores[1].toUpperCase()))
                        .setTipo(TipoHabitacion.valueOf(valores[2].toLowerCase()))
                        .setCapacidad(Integer.parseInt(valores[3]))
                        .setPrecioNoche(Double.parseDouble(valores[4]))
                        .build();

                panelHotel.getHotel().getHabitaciones().add(habitacion);
                panelHotel.actualizar();

                Thread.sleep(500);
            }

            reader.close();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
