package com.mycompany.futbolclub;

public abstract class Miembro {
    private String nombre;
    private int edad;
    private TipoMiembro tipoMiembro;

    public Miembro(String nombre, int edad, TipoMiembro tipoMiembro) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoMiembro = tipoMiembro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public TipoMiembro getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(TipoMiembro tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
    }

    @Override
    public String toString() {
        return "Miembro{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipoMiembro=" + tipoMiembro +
                '}';
    }
}
