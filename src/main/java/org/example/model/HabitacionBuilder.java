package org.example.model;

import org.example.utils.EstadoHabitacion;
import org.example.utils.TipoHabitacion;

public class HabitacionBuilder {
    private int numero;
    private EstadoHabitacion disponible;
    private TipoHabitacion tipo;
    private int capacidad;
    private double precioNoche;

    public HabitacionBuilder() {
    }

    public HabitacionBuilder setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public HabitacionBuilder setDisponible(EstadoHabitacion disponible) {
        this.disponible = disponible;
        return this;
    }

    public HabitacionBuilder setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
        return this;
    }

    public HabitacionBuilder setCapacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    public HabitacionBuilder setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
        return this;
    }

    public Habitacion build() {
        return new Habitacion(numero, disponible, tipo, capacidad, precioNoche);
    }
}
