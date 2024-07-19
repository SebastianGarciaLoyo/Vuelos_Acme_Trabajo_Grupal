/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.trayecto.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.acme.viajesacme.trayecto.domain.entity.Trayecto;
import com.acme.viajesacme.trayecto.domain.service.TrayectoService;
import com.acme.viajesacme.trayecto.infrastructure.config.DatabaseConfigTrayecto;

/**
 *
 * @author camper
 */
public class TrayectoRepository implements TrayectoService {
    @Override
    public void crearTrayecto(Trayecto trayecto) {
        String sql = "INSERT INTO trayecto(descripcion, valor) VALUES(?,?)";

        try(Connection connection  = DatabaseConfigTrayecto.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            statement.setString(1, trayecto.getDescripcion());
            statement.setInt(2, trayecto.getValor());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                
            } else {
                throw new SQLException("Crear Trayecto fallo.");
            }
        } catch(SQLException e) {
            System.err.println("Error executing SQL statement: " + e.getMessage());
        }
    }
}
