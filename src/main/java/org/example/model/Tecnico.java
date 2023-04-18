package org.example.model;

import org.example.utils.EstadoHabitacion;
import org.example.view.PanelHotel;

public class Tecnico implements Runnable{
    private int id;
    private Habitacion habitacion;
    private PanelHotel panelHotel;

    public Tecnico() {
    }

    public Tecnico(int id) {
        this.id = id;
    }

    public Tecnico(int id, Habitacion habitacion) {
        this.id = id;
        this.habitacion = habitacion;
    }

    @Override
    public void run() {
        System.out.println("Escribe el id del técnico, separado por un espacio, y la habitación que debe reparar.");

        while (!panelHotel.getHotel().isOpen()) {
            String input = System.console().readLine();
            String[] values = input.split(" ");

            for (Habitacion habitacion : panelHotel.getHotel().getHabitaciones()) {
                if (habitacion.getNumero() == Integer.parseInt(values[0])) {
                    this.setHabitacion(habitacion);
                    habitacion.setDisponible(EstadoHabitacion.ARREGLADO);

                    try {
                        Thread.sleep(4000);

                        this.setHabitacion(null);
                        habitacion.setDisponible(EstadoHabitacion.DISPONIBLE);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}
