package org.example.controller;

import org.example.view.PanelHotel;

public class ClientesController implements Runnable{
    private PanelHotel panelHotel;

    public ClientesController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {

    }
}
