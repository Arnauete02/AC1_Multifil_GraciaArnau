package org.example.model;

public class Tecnico {
    private int id;
    private Habitacion habitacion;

    public Tecnico() {
    }

    public Tecnico(int id) {
        this.id = id;
    }

    public Tecnico(int id, Habitacion habitacion) {
        this.id = id;
        this.habitacion = habitacion;
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
