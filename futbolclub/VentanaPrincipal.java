package com.mycompany.futbolclub;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private List<Jugador> listaJugadores = new ArrayList<>();
    private List<Entrenador> listaEntrenadores = new ArrayList<>();
    private List<Socio> listaSocios = new ArrayList<>();
    private List<Finanza> listaFinanzas = new ArrayList<>();
    private List<Competencia> listaCompetencias = new ArrayList<>();

    public VentanaPrincipal() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestión de Club de Fútbol");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton botonGestionMiembros = new JButton("Gestión de Miembros");
        JButton botonGestionFinanciera = new JButton("Gestión Financiera");
        JButton botonGestionCompetencias = new JButton("Gestión de Competencias");
        JButton botonVerRegistros = new JButton("Ver Registros");
        JButton botonSalir = new JButton("Salir");

        botonGestionMiembros.addActionListener(this::botonGestionMiembrosActionPerformed);
        botonGestionFinanciera.addActionListener(this::botonGestionFinancieraActionPerformed);
        botonGestionCompetencias.addActionListener(this::botonGestionCompetenciasActionPerformed);
        botonVerRegistros.addActionListener(this::botonVerRegistrosActionPerformed);
        botonSalir.addActionListener(evt -> System.exit(0));

        JPanel panel = new JPanel();
        panel.add(botonGestionMiembros);
        panel.add(botonGestionFinanciera);
        panel.add(botonGestionCompetencias);
        panel.add(botonVerRegistros);
        panel.add(botonSalir);

        add(panel);
    }

    private void botonGestionMiembrosActionPerformed(ActionEvent evt) {
        String[] opciones = {"Jugador", "Entrenador", "Socio"};
        String seleccion = (String) JOptionPane.showInputDialog(this, 
                "Seleccione el tipo de miembro:", 
                "Gestión de Miembros", 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                opciones, 
                opciones[0]);

        if (seleccion == null) return;

        switch (seleccion) {
            case "Jugador" -> gestionarJugador();
            case "Entrenador" -> gestionarEntrenador();
            case "Socio" -> gestionarSocio();
        }
    }

    private void gestionarJugador() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del jugador:");
        if (nombre == null) return;

        String edadStr = JOptionPane.showInputDialog(this, "Edad del jugador:");
        if (edadStr == null) return;

        String posicion = JOptionPane.showInputDialog(this, "Posición del jugador:");
        if (posicion == null) return;

        try {
            int edad = Integer.parseInt(edadStr);
            listaJugadores.add(new Jugador(nombre, edad, posicion));
            JOptionPane.showMessageDialog(this, "Jugador añadido correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad ingresada no es válida.");
        }
    }

    private void gestionarEntrenador() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del entrenador:");
        if (nombre == null) return;

        String edadStr = JOptionPane.showInputDialog(this, "Edad del entrenador:");
        if (edadStr == null) return;

        String experienciaStr = JOptionPane.showInputDialog(this, "Años de experiencia:");
        if (experienciaStr == null) return;

        try {
            int edad = Integer.parseInt(edadStr);
            int experiencia = Integer.parseInt(experienciaStr);
            listaEntrenadores.add(new Entrenador(nombre, edad, experiencia));
            JOptionPane.showMessageDialog(this, "Entrenador añadido correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La información ingresada no es válida.");
        }
    }

    private void gestionarSocio() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del socio:");
        if (nombre == null) return;

        String edadStr = JOptionPane.showInputDialog(this, "Edad del socio:");
        if (edadStr == null) return;

        String categoria = JOptionPane.showInputDialog(this, "Categoría del socio:");
        if (categoria == null) return;

        try {
            int edad = Integer.parseInt(edadStr);
            listaSocios.add(new Socio(nombre, edad, categoria));
            JOptionPane.showMessageDialog(this, "Socio añadido correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad ingresada no es válida.");
        }
    }

    private void botonGestionFinancieraActionPerformed(ActionEvent evt) {
        String descripcion = JOptionPane.showInputDialog(this, "Ingrese descripción:");
        if (descripcion == null) return;

        String montoStr = JOptionPane.showInputDialog(this, "Ingrese monto:");
        if (montoStr == null) return;

        String tipo = JOptionPane.showInputDialog(this, "Es ingreso o egreso? (ingreso/egreso):");
        if (tipo == null) return;

        try {
            double monto = Double.parseDouble(montoStr);
            boolean esIngreso = tipo.equalsIgnoreCase("ingreso");
            listaFinanzas.add(new Finanza(descripcion, monto, esIngreso));
            JOptionPane.showMessageDialog(this, "Registro financiero añadido correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El monto ingresado no es válido.");
        }
    }

    private void botonGestionCompetenciasActionPerformed(ActionEvent evt) {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre de la competencia:");
        if (nombre == null) return;

        String fechaStr = JOptionPane.showInputDialog(this, "Ingrese la fecha (YYYY-MM-DD):");
        if (fechaStr == null) return;

        String lugar = JOptionPane.showInputDialog(this, "Ingrese el lugar:");
        if (lugar == null) return;

        try {
            LocalDate fecha = LocalDate.parse(fechaStr);
            listaCompetencias.add(new Competencia(nombre, fecha, lugar));
            JOptionPane.showMessageDialog(this, "Competencia añadida correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "La fecha ingresada no es válida.");
        }
    }

    private void botonVerRegistrosActionPerformed(ActionEvent evt) {
        StringBuilder registros = new StringBuilder("=== Registros ===\n");

        registros.append("\n** Jugadores **\n");
        listaJugadores.forEach(j -> registros.append("Nombre: ").append(j.getNombre())
                .append(", Edad: ").append(j.getEdad())
                .append(", Posición: ").append(j.getPosicion()).append("\n"));

        registros.append("\n** Entrenadores **\n");
        listaEntrenadores.forEach(e -> registros.append("Nombre: ").append(e.getNombre())
                .append(", Edad: ").append(e.getEdad())
                .append(", Experiencia: ").append(e.getExperiencia()).append("\n"));

        registros.append("\n** Socios **\n");
        listaSocios.forEach(s -> registros.append("Nombre: ").append(s.getNombre())
                .append(", Edad: ").append(s.getEdad())
                .append(", Categoría: ").append(s.getTipo()).append("\n"));

        registros.append("\n** Finanzas **\n");
        listaFinanzas.forEach(f -> registros.append("Descripción: ").append(f.getDescripcion())
                .append(", Monto: ").append(f.getMonto())
                .append(", Tipo: ").append(f.isIngreso() ? "Ingreso" : "Egreso").append("\n"));

        registros.append("\n** Competencias **\n");
        listaCompetencias.forEach(c -> registros.append("Nombre: ").append(c.getNombre())
                .append(", Fecha: ").append(c.getFecha())
                .append(", Lugar: ").append(c.getLugar()).append("\n"));

        JTextArea textArea = new JTextArea(registros.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(this, scrollPane, "Registros Completos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}
