package hotelapp;

public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private boolean ocupada;

    public Habitacion(int numero, TipoHabitacion tipo) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número de habitación debe ser positivo.");
        }
        this.numero = numero;
        this.tipo = tipo;
        this.ocupada = false;
    }

    public int getNumero() {
        return numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void reservar() {
        this.ocupada = true;
    }

    public void liberar() {
        this.ocupada = false;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", tipo=" + tipo +
                ", ocupada=" + ocupada +
                '}';
    }
}