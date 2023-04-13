package org.example.controller;

import org.example.model.Cliente;
import org.example.utils.Files;
import org.example.utils.TipoHabitacion;
import org.example.view.PanelHotel;

import java.io.IOException;

public class ClientesController implements Runnable{
    private PanelHotel panelHotel;

    public ClientesController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {
        try {
            String[] lineas = Files.leerArchivo("C:\\Users\\Arnau\\Documents\\intellij\\m09\\AC1_Multifil_GraciaArnau\\src\\files\\clientes.txt");
            String[] valores = null;
            String[] elementos = null;

            for (int i = 0; i < lineas.length; i++) {
                valores = lineas[i].split(" ");
                elementos = valores[2].split(",");

                for (int j = 0; j < elementos.length; j++) {
                    Thread clienteThread = new Thread(new Cliente(Integer.parseInt(valores[0]), valores[1], Integer.parseInt(elementos[j]),
                            TipoHabitacion.valueOf(valores[3].toLowerCase()), Integer.parseInt(valores[4]), panelHotel));
                }

                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
