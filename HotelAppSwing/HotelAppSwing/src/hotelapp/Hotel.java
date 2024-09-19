package hotelapp;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Habitacion> habitaciones;

    public Hotel() {
        habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(int numero, TipoHabitacion tipo) {
        habitaciones.add(new Habitacion(numero, tipo));
    }

    public boolean reservarHabitacion(int numero) {
        for (Habitacion hab : habitaciones) {
            if (hab.getNumero() == numero) {
                if (!hab.isOcupada()) {
                    hab.reservar();
                    return true;
                } else {
                    System.out.println("La habitación " + numero + " ya está ocupada.");
                    return false;
                }
            }
        }
        System.out.println("La habitación " + numero + " no existe.");
        return false;
    }

    public boolean eliminarHabitacion(int numero) {
        for (Habitacion hab : habitaciones) {
            if (hab.getNumero() == numero) {
                habitaciones.remove(hab);
                return true;
            }
        }
        System.out.println("La habitación " + numero + " no existe.");
        return false;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}