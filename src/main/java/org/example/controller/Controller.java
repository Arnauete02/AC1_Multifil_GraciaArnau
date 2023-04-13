package org.example.controller;

import org.example.model.Hotel;
import org.example.view.PanelHotel;

public class Controller {
    private static Controller controller;

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    private Controller() {

    }

    public void init() {
        Hotel hotel = new Hotel("Hotel Barceló");
        PanelHotel panelHotel = new PanelHotel(hotel);

        Thread diasThread = new Thread(new DiasController(panelHotel));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread hotelThread = new Thread(new HotelController(panelHotel));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread clientsThread = new Thread(new ClientesController(panelHotel));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread incidenciasThread = new Thread(new IncidenciasController(panelHotel));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
