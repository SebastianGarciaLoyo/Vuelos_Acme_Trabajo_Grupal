/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.infrastructure.in;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.acme.viajesacme.persona.application.ClienteUseCase;
import com.acme.viajesacme.persona.domain.entity.Cliente;

// Importando las clases y paquetes necesarios

/**
 *
 * @author camper
 */
public class ClienteController extends JPanel {
    private ClienteUseCase clienteUseCase;

    private JTextField nombreField;
    private JTextField emailField;
    private JTextField telefonoField;
    private JTextField numIdField;
    private JTextField tipoIdField;
    private JTextField tipoSangreField;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;

        setLayout(new GridLayout(9, 2));


        JLabel nombreLabel = new JLabel("Nombre del Cliente:");
        nombreField = new JTextField(10);
        add(nombreLabel);
        add(nombreField);

        JLabel emailLabel = new JLabel("Email del Cliente:");
        emailField = new JTextField(10);
        add(emailLabel);
        add(emailField);

        JLabel telefonoLabel = new JLabel("Numero de Telefono del Cliente");
        telefonoField = new JTextField(10);
        add(telefonoLabel);
        add(telefonoField);

        JLabel numIdLabel = new JLabel("Documento del Cliente:");
        numIdField = new JTextField(10);
        add(numIdLabel);
        add(numIdField);

        JLabel tipoIdLabel = new JLabel("Tipo de Documento del Cliente:");
        tipoIdField = new JTextField(10);
        add(tipoIdLabel);
        add(tipoIdField);

        JLabel tipoSangreLabel = new JLabel("Tipo de Sanger del Cliente:");
        tipoSangreField = new JTextField(10);
        add(tipoSangreLabel);
        add(tipoSangreField);

        JButton registrarButton = new JButton("Registrar Cliente");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String email = emailField.getText();
                String telefono = telefonoField.getText();
                Long numId = (long) Integer.parseInt(numIdField.getText());
                String tipoId = tipoIdField.getText();
                String tipoSangreRh = tipoSangreField.getText();

                Cliente cliente = new Cliente();
                cliente.setNombre(nombre);
                cliente.setEmail(email);
                cliente.setTelefono(telefono);
                cliente.setNumId(numId);
                cliente.setTipoId(tipoId);
                cliente.setTipoSangreRH(tipoSangreRh);

                clienteUseCase.execute(cliente);


                 JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente!");
            }
        });

        add(registrarButton);
    }

}
