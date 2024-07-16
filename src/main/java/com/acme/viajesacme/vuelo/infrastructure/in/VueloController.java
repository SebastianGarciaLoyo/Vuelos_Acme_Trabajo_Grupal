/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.vuelo.infrastructure.in;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.acme.viajesacme.vuelo.application.CreateVueloUseCase;
import com.acme.viajesacme.vuelo.domain.entity.Vuelo;

/**
 *
 * @author camper
 */
public class VueloController extends JPanel {
    
    private CreateVueloUseCase createVueloUseCase;

    private JTextField idField;
    private JTextField clienteField;
    private JTextField trayectoField;
    private JTextField añoField;
    private JTextField mesField;
    private JTextField diaField;
    private JTextField tarifaField;

    public VueloController(CreateVueloUseCase createVueloUseCase) {
        this.createVueloUseCase = createVueloUseCase;

        setLayout(new GridLayout(8, 2));

        JLabel idLabel = new JLabel("Id del vuelo:");
        idField = new JTextField(10);
        add(idLabel);
        add(idField);

        JLabel clienteLabel = new JLabel("Nombre del cliente:");
        clienteField = new JTextField(10);
        add(clienteLabel);
        add(clienteField);

        JLabel trayectoLabel = new JLabel("Trayecto:");
        trayectoField = new JTextField(10);
        add(trayectoLabel);
        add(trayectoField);

        JLabel añoLabel = new JLabel("Año del trayecto:");
        añoField = new JTextField(10);
        add(añoLabel);
        add(añoField);

        JLabel mesLabel = new JLabel("Mes del trayecto:");
        mesField = new JTextField(10);
        add(mesLabel);
        add(mesField);

        JLabel diaLabel = new JLabel("Dia del trayecto:");
        diaField = new JTextField(10);
        add(diaLabel);
        add(diaField);

        JLabel tarifaLabel = new JLabel("Tarifa del trayecto:");
        tarifaField = new JTextField(10);
        add(tarifaLabel);
        add(tarifaField);

        JButton registrarButton = new JButton("Registrar Trayecto");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos que ingreso el usuario
                int id_vuelo = Integer.parseInt(idField.getText());
                String cliente = clienteField.getText();
                int año = Integer.parseInt(añoField.getText());
                int mes = Integer.parseInt(mesField.getText());
                int dia = Integer.parseInt(diaField.getText());
                String trayecto = trayectoField.getText();
                int tarifa = Integer.parseInt(trayectoField.getText());

                // Crear objeto vuelo
                Vuelo vuelo = new Vuelo();
                vuelo.setId_vuelo(id_vuelo);
                vuelo.setCliente(cliente);
                vuelo.setAño(año);
                vuelo.setMes(mes);
                vuelo.setDia(dia);
                vuelo.setTrayecto(trayecto);
                vuelo.setTarifa(tarifa);

                createVueloUseCase.execute(vuelo);


                JOptionPane.showMessageDialog(null, "Vuelo Registrado Exitosamente!");
            }
        });
        add(registrarButton);
    }
}
