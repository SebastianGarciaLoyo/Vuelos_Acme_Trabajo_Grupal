package com.acme.viajesacme.aeropuerto.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.acme.viajesacme.aeropuerto.domain.entity.Aeropuerto;
import com.acme.viajesacme.aeropuerto.domain.service.AeropuertoService;
import com.acme.viajesacme.aeropuerto.infrastructure.config.DatabaseConfigAeropuerto;

public class AeropuertoRepository implements AeropuertoService {
    @Override
    public void crearAeropuerto(Aeropuerto aeropuerto) {
        String sql = "INSERT INTO aeropuertos(id_aeropuerto, nombre, ciudad, pais) VALUES (?,?,?,?)";

        try (Connection connection = DatabaseConfigAeropuerto.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            statement.setString(1, aeropuerto.getId_aeropuerto());
            statement.setString(2, aeropuerto.getNombre());
            statement.setString(3, aeropuerto.getCiudad());
            statement.setString(4, aeropuerto.getPais());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {

            } else {
                throw new SQLException("Crear aeropuerto fallo.");
            }
        } catch (SQLException e) {
            System.err.println("Error executing SQL statement: " + e.getMessage());
        }
    }
}
