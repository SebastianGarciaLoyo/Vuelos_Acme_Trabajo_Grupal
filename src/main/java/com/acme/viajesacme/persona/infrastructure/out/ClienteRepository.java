/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.acme.viajesacme.persona.domain.entity.Cliente;
import com.acme.viajesacme.persona.domain.service.ClienteService;
import com.acme.viajesacme.persona.infrastructure.config.DatabaseConfigPersona;

/**
 *
 * @author camper
 */
public class ClienteRepository implements ClienteService {

    @Override
    public void crearCliente(Cliente cliente) {
       String sql = "INSERT INTO cliente (nombre, email, telefono, numId, tipoId, tipoSangreRH) VALUES (?,?,?,?,?,?)";
       
       try (Connection connection = DatabaseConfigPersona.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, cliente.getNombre());
                statement.setString(2, cliente.getEmail());
                statement.setString(3, cliente.getTelefono());
                statement.setLong(4, cliente.getNumId());
                statement.setString(5, cliente.getTipoId());
                statement.setString(6, cliente.getTipoSangreRH());
                statement.executeUpdate();
                

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        cliente.setId(generatedKeys.getLong(1));
                    }
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
    }    
}
