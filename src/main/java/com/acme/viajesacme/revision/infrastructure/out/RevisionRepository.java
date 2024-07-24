/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.revision.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.acme.viajesacme.revision.domain.entity.Revision;
import com.acme.viajesacme.revision.domain.service.RevisionService;
import com.acme.viajesacme.revision.infrastructure.config.DatabaseConfigRevision;

/**
 *
 * @author camper
 */
public class RevisionRepository implements RevisionService {
    @Override
    public void crearRevision(Revision revision) {
        String sql = "INSERT INTO revisiones(avion, ano_revision, mes_revision, dia_revision, descripcion, empleado) VALUES(?,?,?,?,?,?)";
        
        try (Connection connection = DatabaseConfigRevision.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            statement.setInt(1, revision.getAvion());
            statement.setInt(2, revision.getAno_revision());
            statement.setInt(3, revision.getMes_revision());
            statement.setInt(4, revision.getMes_revision());
            statement.setInt(5, revision.getDia_revision());
            statement.setString(6, revision.getDescripcion());
            statement.setString(7, revision.getEmpleado());

            int rowsInserted = statement.executeUpdate();

            if(rowsInserted > 0) {

            }   else {
                throw new SQLException("Crear revision fallo");
            }
        } catch (SQLException e) {
            System.err.println("Error executing SQL statement: " + e.getMessage() );
        }
    }
}
