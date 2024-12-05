package com.mycompany.futbolclub;

public class Jugador extends Miembro {
    private String posicion;

    public Jugador(String nombre, int edad, String posicion) {
        super(nombre, edad, TipoMiembro.JUGADOR);
        this.posicion = posicion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", posicion='" + posicion + '\'' +
                '}';
    }
}

