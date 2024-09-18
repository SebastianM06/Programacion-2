import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  
    static class Habitacion {
        private int numero;
        private String tipo; 
        private boolean ocupada;

        public Habitacion(int numero, String tipo) {
            this.numero = numero;
            this.tipo = tipo;
            this.ocupada = false;
        }

        public int getNumero() {
            return numero;
        }

        public String getTipo() {
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
                    ", tipo='" + tipo + '\'' +
                    ", ocupada=" + ocupada +
                    '}';
        }
    }

    // Clase interna Hotel
    static class Hotel {
        private ArrayList<Habitacion> habitaciones;

        public Hotel() {
            habitaciones = new ArrayList<>();
        }

        public void agregarHabitacion(int numero, String tipo) {
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

        public boolean liberarHabitacion(int numero) {
            for (Habitacion hab : habitaciones) {
                if (hab.getNumero() == numero) {
                    if (hab.isOcupada()) {
                        hab.liberar();
                        return true;
                    } else {
                        System.out.println("La habitación " + numero + " ya está libre.");
                        return false;
                    }
                }
            }
            System.out.println("La habitación " + numero + " no existe.");
            return false;
        }

        public void consultarEstadoHabitaciones() {
            if (habitaciones.isEmpty()) {
                System.out.println("No hay habitaciones registradas.");
            } else {
                for (Habitacion hab : habitaciones) {
                    System.out.println(hab);
                }
            }
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Reservas de Hotel ---");
            System.out.println("1. Registrar habitación");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Liberar habitación");
            System.out.println("4. Consultar estado de habitaciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        registrarHabitacion(hotel, scanner);
                        break;
                    case 2:
                        reservarHabitacion(hotel, scanner);
                        break;
                    case 3:
                        liberarHabitacion(hotel, scanner);
                        break;
                    case 4:
                        hotel.consultarEstadoHabitaciones();
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); 
            }
        }
    }

    private static void registrarHabitacion(Hotel hotel, Scanner scanner) {
        System.out.print("Ingrese el número de habitación: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el tipo de habitación (simple, doble, suite): ");
        String tipo = scanner.nextLine().toLowerCase();

        if (tipo.equals("simple") || tipo.equals("doble") || tipo.equals("suite")) {
            hotel.agregarHabitacion(numero, tipo);
            System.out.println("Habitación registrada exitosamente.");
        } else {
            System.out.println("Tipo de habitación inválido.");
        }
    }

    private static void reservarHabitacion(Hotel hotel, Scanner scanner) {
        System.out.print("Ingrese el número de habitación a reservar: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); 

        boolean exito = hotel.reservarHabitacion(numero);
        if (exito) {
            System.out.println("Habitación reservada exitosamente.");
        } else {
            System.out.println("No se pudo reservar la habitación.");
        }
    }

    private static void liberarHabitacion(Hotel hotel, Scanner scanner) {
        System.out.print("Ingrese el número de habitación a liberar: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); 

        boolean exito = hotel.liberarHabitacion(numero);
        if (exito) {
            System.out.println("Habitación liberada exitosamente.");
        } else {
            System.out.println("No se pudo liberar la habitación.");
        }
    }
}
