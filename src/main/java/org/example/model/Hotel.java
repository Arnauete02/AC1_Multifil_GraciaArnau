package org.example.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        this.habitaciones = new HashSet<>();
        this.tecnicos = new ArrayList<>();
        this.dinero = 0.0;
        this.dia = 0;
        this.personasPerdidas = 0;
        this.open = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Set<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
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

    public void setOpen(boolean open) {
        this.open = open;
    }
}
