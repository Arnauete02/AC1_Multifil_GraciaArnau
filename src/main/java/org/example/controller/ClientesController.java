package org.example.controller;

import org.example.model.Cliente;
import org.example.utils.Constants;
import org.example.utils.Files;
import org.example.utils.TipoHabitacion;
import org.example.view.PanelHotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClientesController implements Runnable{
    private PanelHotel panelHotel;

    public ClientesController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Constants.CLIENTES));
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] datosCliente = linea.split(" ");
                String[] personasPorHabitacion = datosCliente[2].split(",");

                for (String persona : personasPorHabitacion) {
                    Thread clienteThread = new Thread(new Cliente(Integer.parseInt(datosCliente[0]), datosCliente[1], Integer.parseInt(persona), TipoHabitacion.valueOf(datosCliente[3].toLowerCase()), Integer.parseInt(datosCliente[4]), panelHotel));
                    clienteThread.start();
                }

                Thread.sleep(2000);
            }
            reader.close();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
