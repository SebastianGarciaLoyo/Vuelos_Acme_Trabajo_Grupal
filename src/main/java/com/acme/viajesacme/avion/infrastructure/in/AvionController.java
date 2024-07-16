package com.acme.viajesacme.avion.infrastructure.in;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;

import com.acme.viajesacme.avion.application.CreateAvionUseCase;
import com.acme.viajesacme.avion.domain.entity.Avion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvionController extends JPanel {

    private CreateAvionUseCase createAvionUseCase;

    private JTextField placaField;
    private JTextField capacidadField;
    private JTextField añoFabricacionField;
    private JTextField mesFabricacionField;
    private JTextField diaFabricacionField;
    private JTextField estadoField;
    private JTextField aerolineaField;
    private JTextField modeloField;

    public AvionController(CreateAvionUseCase createAvionUseCase) {
        this.createAvionUseCase = createAvionUseCase;

        setLayout(new GridLayout(9, 2));

        JLabel placaLabel = new JLabel("Placa del avion:");
        placaField = new JTextField(10);
        add(placaLabel);
        add(placaField);

        JLabel capacidadLabel = new JLabel("Capacidad del avion:");
        capacidadField = new JTextField(10);
        add(capacidadLabel);
        add(capacidadField);

        JLabel añoFabricacionLabel = new JLabel("Año de fabricacion:");
        añoFabricacionField = new JTextField(10);
        add(añoFabricacionLabel);
        add(añoFabricacionField);

        JLabel mesFabricacionLabel = new JLabel("Mes de fabricacion:");
        mesFabricacionField = new JTextField(10);
        add(mesFabricacionLabel);
        add(mesFabricacionField);

        JLabel diaFabricacionLabel = new JLabel("Dia de fabricacion:");
        diaFabricacionField = new JTextField(10);
        add(diaFabricacionLabel);
        add(diaFabricacionField);

        JLabel estadoLabel = new JLabel("Estado del avion:");
        estadoField = new JTextField(10);
        add(estadoLabel);
        add(estadoField);

        JLabel aerolineaLabel = new JLabel("Aerolinea del avion:");
        aerolineaField = new JTextField(10);
        add(aerolineaLabel);
        add(aerolineaField);

        JLabel modeloLabel = new JLabel("Modelo del avion:");
        modeloField = new JTextField(10);
        add(modeloLabel);
        add(modeloField);

        JButton registrarButton = new JButton("Registrar Avion");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos ingresados por el usuario
                int placa = Integer.parseInt(placaField.getText());
                int capacidad = Integer.parseInt(capacidadField.getText());
                int añoFabricacion = Integer.parseInt(añoFabricacionField.getText());
                int mesFabricacion = Integer.parseInt(mesFabricacionField.getText());
                int diaFabricacion = Integer.parseInt(diaFabricacionField.getText());
                String estado = estadoField.getText();
                String aerolinea = aerolineaField.getText();
                String modelo = modeloField.getText();

                // Crear objeto Avion
                Avion avion = new Avion();
                avion.setPlaca(placa);
                avion.setCapacidad(capacidad);
                avion.setAño_fabricacion(añoFabricacion);
                avion.setMes_fabricacion(mesFabricacion);
                avion.setDia_fabricacion(diaFabricacion);
                avion.setEstado(estado);
                avion.setAerolinea(aerolinea);
                avion.setModelo(modelo);

                // Ejecutar caso de uso para crear avion
                createAvionUseCase.execute(avion);

                

                JOptionPane.showMessageDialog(null, "Avion registrado exitosamente!");
            }
        });

        add(registrarButton);
    }
}