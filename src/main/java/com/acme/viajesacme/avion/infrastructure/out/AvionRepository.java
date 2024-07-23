package com.acme.viajesacme.avion.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.acme.viajesacme.avion.domain.entity.Avion;
import com.acme.viajesacme.avion.domain.service.AvionRecordService;
import com.acme.viajesacme.avion.infrastructure.config.DatabaseConfigAvion;

public class AvionRepository implements AvionRecordService {
    @Override
    public int record(Avion avion) {

        String placa = avion.getPlaca();
        int capacidad = avion.getCapacidad();
        String fecha_fabricacion = avion.getFecha_fabricacion();
        int modelo_id = avion.getModelo_id();
        int estado_id = avion.getEstado_id();
        int insertedRows = 0;

        Connection connection = null;
        CallableStatement cs = null;
        ResultSet procedureInsertarAvion = null;

        try {
            String sqlProcedure = "{CALL InsertarAvion(?,?,?,?,?)}";
            connection = DatabaseConfigAvion.getConnection();
            cs = connection.prepareCall(sqlProcedure);
            cs.setString(1, placa);
            cs.setInt(2, capacidad);
            cs.setString(3, fecha_fabricacion);
            cs.setInt(4, modelo_id);
            cs.setInt(5, estado_id);

            boolean hasResultSet = cs.execute();

            if (hasResultSet) {
                procedureInsertarAvion = cs.getResultSet();
                if (procedureInsertarAvion.next()) {
                    insertedRows = procedureInsertarAvion.getInt("numRow");
                }
            } else {
                // If there is no ResultSet, check if update count is available
                insertedRows = cs.getUpdateCount();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Ensure the resources are closed to avoid memory leaks
            try {
                if (procedureInsertarAvion != null) procedureInsertarAvion.close();
                if (cs != null) cs.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return insertedRows;
    }
}






