// HotelAppSwim

package hotelapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelAppSwing extends JFrame {
    private Hotel hotel;

    private JTextArea textArea;
    private JTextField numeroField;
    private JComboBox<TipoHabitacion> tipoComboBox;

    public HotelAppSwing() {
        hotel = new Hotel();

        setTitle("Administración de Hotel");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear la interfaz gráfica
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Número:"));
        numeroField = new JTextField(5);
        panel.add(numeroField);

        panel.add(new JLabel("Tipo:"));
        tipoComboBox = new JComboBox<>(TipoHabitacion.values());
        panel.add(tipoComboBox);

        JButton agregarButton = new JButton("Agregar Habitación");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarHabitacion();
            }
        });
        panel.add(agregarButton);

        JButton reservarButton = new JButton("Reservar Habitación");
        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservarHabitacion();
            }
        });
        panel.add(reservarButton);

        JButton liberarButton = new JButton("Liberar Habitación");
        liberarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liberarHabitacion();
            }
        });
        panel.add(liberarButton);

        JButton consultarButton = new JButton("Consultar Estado");
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTablaEstado();
            }
        });
        panel.add(consultarButton);

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(salirButton);

        add(panel, BorderLayout.SOUTH);

        actualizarTexto();
    }

    private void agregarHabitacion() {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            TipoHabitacion tipo = (TipoHabitacion) tipoComboBox.getSelectedItem();
            hotel.agregarHabitacion(numero, tipo);
            actualizarTexto();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El número de habitación debe ser un entero.");
        }
    }

    private void reservarHabitacion() {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            if (hotel.reservarHabitacion(numero)) {
                actualizarTexto();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El número de habitación debe ser un entero.");
        }
    }

    private void liberarHabitacion() {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            if (hotel.eliminarHabitacion(numero)) {
                actualizarTexto();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El número de habitación debe ser un entero.");
        }
    }

    private void mostrarTablaEstado() {
        JFrame frame = new JFrame("Estado de Habitaciones");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        String[] columnNames = {"NUMERO", "TIPO", "ESTADO"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Habitacion hab : hotel.getHabitaciones()) {
            String estado = hab.isOcupada() ? "OCUPADA" : "LIBRE";
            model.addRow(new Object[]{hab.getNumero(), hab.getTipo().name(), estado});
        }

        JTable table = new JTable(model);
        frame.add(new JScrollPane(table));

        frame.setVisible(true);
    }

    private void actualizarTexto() {
        textArea.setText("");
        for (Habitacion hab : hotel.getHabitaciones()) {
            textArea.append(hab.toString().toUpperCase() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HotelAppSwing app = new HotelAppSwing();
            app.setVisible(true);
        });
    }
}

// Hotel

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

// Habitacion

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

// TipoHabitacion 

package hotelapp;

public enum TipoHabitacion {
    SIMPLE, DOBLE, SUITE
}