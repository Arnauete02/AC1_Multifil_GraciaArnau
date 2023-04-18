package org.example.model;

import org.example.utils.EstadoHabitacion;
import org.example.utils.TipoHabitacion;
import org.example.view.PanelHotel;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Cliente implements Runnable{
    private int id;
    private String nombre;
    private int personas;
    private TipoHabitacion tipoHabitacion;
    private int dias;
    private PanelHotel panelHotel;

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
        Habitacion habitacion = searchHabitacion();

        if (habitacion != null) {
            habitacion.setDisponible(EstadoHabitacion.OCUPADA);

            panelHotel.getHotel().setDinero(panelHotel.getHotel().getDinero() + habitacion.getPrecioNoche());

            for (int i = 0; i < this.dias; i++) {
                try {
                    Thread.sleep(2000);

                    if (habitacion.getDisponible() == EstadoHabitacion.AVERIADA) {
                        if (this.searchHabitacion() == null) {
                            panelHotel.getHotel().setPersonasPerdidas(panelHotel.getHotel().getPersonasPerdidas() + 1);
                            panelHotel.getHotel().setDinero(panelHotel.getHotel().getDinero() - 1000 - habitacion.getPrecioNoche());
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (habitacion.getDisponible() != EstadoHabitacion.AVERIADA) {
                habitacion.setDisponible(EstadoHabitacion.DISPONIBLE);
            }
        } else {
            panelHotel.getHotel().setPersonasPerdidas(panelHotel.getHotel().getPersonasPerdidas() + 1);
            panelHotel.getHotel().setDinero(panelHotel.getHotel().getDinero() - 1000);
        }
    }

    private synchronized Habitacion searchHabitacion() {
        Set<Habitacion> habitaciones = panelHotel.getHotel().getHabitaciones();

        for (Habitacion habitacion : habitaciones) {
            if (this.tipoHabitacion.getTipo() == habitacion.getTipo()
                    && this.personas <= habitacion.getCapacidad() && habitacion.getDisponible() == EstadoHabitacion.DISPONIBLE) {
                return habitacion;
            }
        }

        return null;
    }
}
