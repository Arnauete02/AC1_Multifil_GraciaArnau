package org.example.model;

import org.example.utils.EstadoHabitacion;
import org.example.utils.TipoHabitacion;

public class Habitacion implements Comparable<Habitacion> {
    private int numero;
    private EstadoHabitacion disponible;
    private TipoHabitacion tipo;
    private int capacidad;
    private double precioNoche;

    public Habitacion() {
    }

    public Habitacion(int numero, EstadoHabitacion disponible, TipoHabitacion tipo, int capacidad, double precioNoche) {
        this.numero = numero;
        this.disponible = disponible;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precioNoche = precioNoche;
    }

    @Override
    public int compareTo(Habitacion o) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EstadoHabitacion getDisponible() {
        return disponible;
    }

    public void setDisponible(EstadoHabitacion disponible) {
        this.disponible = disponible;
    }

    public int getTipo() {
        return tipo.getTipo();
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }
}
