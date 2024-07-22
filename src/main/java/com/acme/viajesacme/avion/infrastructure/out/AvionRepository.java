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
        String sql = "INSERT INTO aviones (placa, capacidad, fecha_fabricacion, id_estado, id_modelo) VALUES (?,?,?,?,?)";
    
        try (Connection connection = DatabaseConfigAvion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
    
            // Asignar valores de avion directamente
            statement.setInt(1, avion.getPlaca());
            statement.setInt(2, avion.getCapacidad());
            statement.setString(3, avion.getFecha_fabricacion());
            statement.setInt(4, avion.getEstado_id());
            statement.setInt(5, avion.getModelo_id());
    
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

