package com.mycompany.futbolclub;

import java.time.LocalDate;

public class Competencia {
    private String nombre;
    private LocalDate fecha;
    private String lugar;

    public Competencia(String nombre, LocalDate fecha, String lugar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Competencia{" +
                "nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}
