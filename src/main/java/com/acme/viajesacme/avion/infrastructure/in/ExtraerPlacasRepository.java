package com.acme.viajesacme.avion.infrastructure.in;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.acme.viajesacme.avion.domain.service.PlacasExtraccionService;
import com.acme.viajesacme.avion.infrastructure.config.DatabaseConfigAvion;

public class ExtraerPlacasRepository implements PlacasExtraccionService {
    @Override
    public List<String> extraerPlacas() {
        List<String> listaExistePlaca = new ArrayList<>();
        ResultSet procedureResultSet = null;

        try {
            String sqlProcedure = "{CALL ObtenerPlacasAvion()}";
            Connection connection = DatabaseConfigAvion.getConnection();
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.execute();
            procedureResultSet = cs.getResultSet();

            while (procedureResultSet.next()) {
                String plate = procedureResultSet.getString("placas");
                listaExistePlaca.add(plate);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }

        return listaExistePlaca;
    }
}
