package org.example.utils;

public enum TipoHabitacion {
    sencilla(1), doble(2), suite(3);

    private int tipo;

    TipoHabitacion(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return this.tipo;
    }
}
