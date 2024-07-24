package com.acme.viajesacme.avion.infrastructure.in;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.acme.viajesacme.avion.domain.service.ExtraerRegistroService;
import com.acme.viajesacme.avion.infrastructure.config.DatabaseConfigAvion;

public class ExtraerEstadoAvionRepository implements ExtraerRegistroService {
    
    @Override
    public ResultSet extraerInfo() {
        ResultSet procedureResultSet = null;

        try {
            String sqlProcedure = "{CALL ObtenerEstadosAvion()}";
            Connection connection = DatabaseConfigAvion.getConnection();
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.execute();
            procedureResultSet = cs.getResultSet();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return procedureResultSet;
    }
}
