package com.mycompany.futbolclub;

public class Finanza {
    private String descripcion;
    private double monto;
    private boolean ingreso;

    public Finanza(String descripcion, double monto, boolean ingreso) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.ingreso = ingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public boolean isIngreso() {
        return ingreso;
    }
}
