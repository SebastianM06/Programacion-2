package com.mycompany.futbolclub;

public class Entrenador extends Miembro {
    private int experiencia;

    public Entrenador(String nombre, int edad, int experiencia) {
        super(nombre, edad, TipoMiembro.ENTRENADOR);
        this.experiencia = experiencia;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", experiencia=" + experiencia +
                '}';
    }
}
