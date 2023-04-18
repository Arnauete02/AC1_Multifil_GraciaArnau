package org.example.model;

import com.sun.source.tree.Tree;

import java.util.*;

public class Hotel {
    private String nombre;
    private Set<Habitacion> habitaciones;
    private List<Tecnico> tecnicos;
    private double dinero;
    private int dia;
    private int personasPerdidas;
    private boolean open;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new TreeSet<>();
        this.tecnicos = new ArrayList<>();
        this.dinero = 0.0;
        this.dia = 0;
        this.personasPerdidas = 0;
        this.open = false;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getPersonasPerdidas() {
        return personasPerdidas;
    }

    public void setPersonasPerdidas(int personasPerdidas) {
        this.personasPerdidas = personasPerdidas;
    }

    public boolean isOpen() {
        return open;
    }
}
