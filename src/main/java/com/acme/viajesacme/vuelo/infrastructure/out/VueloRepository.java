/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.vuelo.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.acme.viajesacme.vuelo.domain.entity.Vuelo;
import com.acme.viajesacme.vuelo.domain.service.VueloService;
import com.acme.viajesacme.vuelo.infrastructure.config.DatabaseConfigVuelo;

/**
 *
 * @author camper
 */
public class VueloRepository implements VueloService {
    
    @Override
    public void createVuelo(Vuelo vuelo) {
        String sql = "INSERT INTO vuelo(id_vuelo, cliente, trayecto, año, mes, dia, tarifa) VALUES(?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfigVuelo.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                statement.setInt(1, vuelo.getId_vuelo());
                statement.setString(2, vuelo.getCliente());
                statement.setInt(3, vuelo.getAño());
                statement.setInt(4, vuelo.getMes());
                statement.setInt(5, vuelo.getMes());
                statement.setInt(6, vuelo.getDia());
                statement.setString(7, vuelo.getTrayecto());
                statement.setInt(8, vuelo.getTarifa());

                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {

                } else {
                    throw new SQLException("Creating vuelo failed.");
                }
            } catch (SQLException ex) {
                System.err.println("Error executing SQL statement: " + ex.getMessage() );
            }
    }
}
