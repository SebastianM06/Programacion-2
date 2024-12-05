package com.mycompany.futbolclub;

public class Socio extends Miembro {
    private String tipo;

    public Socio(String nombre, int edad, String tipo) {
        super(nombre, edad, TipoMiembro.SOCIO);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
