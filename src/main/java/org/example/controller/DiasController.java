package org.example.controller;

import org.example.view.PanelHotel;

import java.awt.*;

public class DiasController implements Runnable {
    private PanelHotel panelHotel;

    public DiasController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(2000);

                panelHotel.getHotel().setDia(panelHotel.getHotel().getDia() + 1);

                panelHotel.actualizar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (!panelHotel.getHotel().isOpen());
    }
}
