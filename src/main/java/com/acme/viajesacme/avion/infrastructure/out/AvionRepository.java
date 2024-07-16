package com.acme.viajesacme.avion.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.acme.viajesacme.avion.domain.entity.Avion;
import com.acme.viajesacme.avion.domain.service.AvionService;
import com.acme.viajesacme.avion.infrastructure.config.DatabaseConfigAvion;

public class AvionRepository implements AvionService {

    @Override
    public void createAvion(Avion avion) {
        String sql = "INSERT INTO avion (placa, capacidad, año_fabricacion, mes_fabricacion, dia_fabricacion, estado, aerolinea, modelo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
        try (Connection connection = DatabaseConfigAvion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
    
            // Asignar valores de avion directamente
            statement.setInt(1, avion.getPlaca());
            statement.setInt(2, avion.getCapacidad());
            statement.setInt(3, avion.getAño_fabricacion());
            statement.setInt(4, avion.getMes_fabricacion());
            statement.setInt(5, avion.getDia_fabricacion());
            statement.setString(6, avion.getEstado());
            statement.setString(7, avion.getAerolinea());
            statement.setString(8, avion.getModelo());
    
            int rowsInserted = statement.executeUpdate();
    
            if (rowsInserted > 0) {
                // No se necesita obtener claves generadas, ya que la placa es proporcionada por el usuario
            } else {
                throw new SQLException("Creating avion failed, no rows affected.");
            }
        } catch (SQLException ex) {
            System.err.println("Error executing SQL statement: " + ex.getMessage());
        }
    }
    
    
}

