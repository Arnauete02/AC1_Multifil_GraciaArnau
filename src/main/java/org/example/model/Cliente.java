package org.example.model;

import org.example.utils.EstadoHabitacion;
import org.example.utils.TipoHabitacion;
import org.example.view.PanelHotel;

import java.util.Set;

public class Cliente implements Runnable{
    private int id;
    private String nombre;
    private int personas;
    private TipoHabitacion tipoHabitacion;
    private int dias;
    private PanelHotel panelHotel;

    public Cliente() {
    }

    public Cliente(int id, String nombre, int personas, TipoHabitacion tipoHabitacion, int dias, PanelHotel panelHotel) {
        this.id = id;
        this.nombre = nombre;
        this.personas = personas;
        this.tipoHabitacion = tipoHabitacion;
        this.dias = dias;
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {
        Habitacion habitacion = this.searchHabitacion();

        if (habitacion != null) {
            habitacion.setDisponible(EstadoHabitacion.OCUPADA);
            panelHotel.getHotel().setDinero(panelHotel.getHotel().getDinero() + habitacion.getPrecioNoche());
        } else {
            panelHotel.getHotel().setPersonasPerdidas(panelHotel.getHotel().getPersonasPerdidas() + 1);
            panelHotel.getHotel().setDinero(panelHotel.getHotel().getDinero() - 1000);
        }

        for (int i = 0; i < this.dias; i++) {
            try {
                Thread.sleep(2000);

                if (habitacion.getDisponible() == EstadoHabitacion.AVERIADA) {
                    if (this.searchHabitacion() == null) {
                        panelHotel.getHotel().setPersonasPerdidas(panelHotel.getHotel().getPersonasPerdidas() + 1);
                        panelHotel.getHotel().setDinero(panelHotel.getHotel().getDinero() - 1000); //TODO -> y también restas el precio ingresado de esta habitación.
                        i = this.dias;
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        habitacion.setDisponible(EstadoHabitacion.DISPONIBLE);
    }

    private Habitacion searchHabitacion() {
        Set<Habitacion> habitaciones = panelHotel.getHotel().getHabitaciones();

        for (Habitacion habitacion : habitaciones) {
            if (this.tipoHabitacion.getTipo() == habitacion.getTipo()
                    && this.personas == habitacion.getCapacidad()) {
                return habitacion;
            }
        }

        return null;
    }
}
