package com.acme.viajesacme.avion.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.acme.viajesacme.avion.domain.entity.Avion;
import com.acme.viajesacme.avion.domain.entity.Estado;
import com.acme.viajesacme.avion.domain.entity.Aerolinea;
import com.acme.viajesacme.avion.domain.entity.Modelo;
import com.acme.viajesacme.avion.domain.service.AvionService;
import com.acme.viajesacme.avion.infrastructure.config.DatabaseConfigAvion;

public class AvionRepository implements AvionService {

    @Override
    public void createAvion(Avion avion) {
        try {


            // Insertar Estado y obtener su ID
            int estadoId = insertEstado(avion.getEstado().getEstado());

            // Insertar Aerolinea y obtener su ID
            int aerolineaId = insertAerolinea(avion.getAerolinea().getAerolinea());

            // Insertar Modelo y obtener su ID
            int modeloId = insertModelo(avion.getModelo().getModelo());

             // Insertar Fabricante y obtener su ID si es necesario
            int fabricanteId = insertFabricante(avion.getFabricante().getFabricante()); // Asegúrate de tener un método similar

            // Insertar Avion
            String sql = "INSERT INTO aviones (placa, capacidad, año_fabricacion, mes_fabricacion, dia_fabricacion, id_estado, id_aerolinea, id_modelo, id_fabricante) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
            try (Connection connection = DatabaseConfigAvion.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
        
                statement.setInt(1, avion.getPlaca());
                statement.setInt(2, avion.getCapacidad());
                statement.setInt(3, avion.getAño_fabricacion());
                statement.setInt(4, avion.getMes_fabricacion());
                statement.setInt(5, avion.getDia_fabricacion());
                statement.setInt(6, estadoId);
                statement.setInt(7, aerolineaId);
                statement.setInt(8, modeloId);
                statement.setInt(9, fabricanteId);
        
                int rowsInserted = statement.executeUpdate();
        
                if (rowsInserted > 0) {
                    System.out.println("Avion creado exitosamente.");
                } else {
                    throw new SQLException("Creating avion failed, no rows affected.");
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error executing SQL statement: " + ex.getMessage());
            ex.printStackTrace(); // Imprime la traza de la pila para mayor detalle
        }
    }

    private int insertEstado(String estadoNombre) throws SQLException {
        String checkSql = "SELECT id_estado FROM estados WHERE estado = ?";
        String insertSql = "INSERT INTO estados (estado) VALUES (?)";
        
        try (Connection connection = DatabaseConfigAvion.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
            
            checkStatement.setString(1, estadoNombre);
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id_estado");
                }
            }

            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                insertStatement.setString(1, estadoNombre);
                int rowsInserted = insertStatement.executeUpdate();

                if (rowsInserted > 0) {
                    try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            return generatedKeys.getInt(1);
                        } else {
                            throw new SQLException("Creating estado failed, no ID obtained.");
                        }
                    }
                } else {
                    throw new SQLException("Creating estado failed, no rows affected.");
                }
            }
        }
    }

    private int insertAerolinea(String aerolineaNombre) throws SQLException {
        String checkSql = "SELECT id_aerolinea FROM aerolineas WHERE aerolinea = ?";
        String insertSql = "INSERT INTO aerolineas (aerolinea) VALUES (?)";
        
        try (Connection connection = DatabaseConfigAvion.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
            
            checkStatement.setString(1, aerolineaNombre);
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id_aerolinea");
                }
            }

            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                insertStatement.setString(1, aerolineaNombre);
                int rowsInserted = insertStatement.executeUpdate();

                if (rowsInserted > 0) {
                    try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            return generatedKeys.getInt(1);
                        } else {
                            throw new SQLException("Creating aerolinea failed, no ID obtained.");
                        }
                    }
                } else {
                    throw new SQLException("Creating aerolinea failed, no rows affected.");
                }
            }
        }
    }

    private int insertFabricante(String fabricanteNombre) throws SQLException {
        String checkSql = "SELECT id_fabricante FROM fabricantes WHERE fabricante = ?";
        String insertSql = "INSERT INTO fabricantes (fabricante) VALUES (?)";
        
        try (Connection connection = DatabaseConfigAvion.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
            
            checkStatement.setString(1, fabricanteNombre);
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id_fabricante");
                }
            }
    
            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                insertStatement.setString(1, fabricanteNombre);
                int rowsInserted = insertStatement.executeUpdate();
    
                if (rowsInserted > 0) {
                    try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            return generatedKeys.getInt(1);
                        } else {
                            throw new SQLException("Creating fabricante failed, no ID obtained.");
                        }
                    }
                } else {
                    throw new SQLException("Creating fabricante failed, no rows affected.");
                }
            }
        }
    }
    

    private int insertModelo(String modeloNombre) throws SQLException {
        String checkSql = "SELECT id_modelo FROM modelos WHERE modelo = ?";
        String insertSql = "INSERT INTO modelos (modelo) VALUES (?)";
        
        try (Connection connection = DatabaseConfigAvion.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
            
            checkStatement.setString(1, modeloNombre);
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id_modelo");
                }
            }

            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                insertStatement.setString(1, modeloNombre);
                int rowsInserted = insertStatement.executeUpdate();

                if (rowsInserted > 0) {
                    try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            return generatedKeys.getInt(1);
                        } else {
                            throw new SQLException("Creating modelo failed, no ID obtained.");
                        }
                    }
                } else {
                    throw new SQLException("Creating modelo failed, no rows affected.");
                }
            }
        }
    }
}




