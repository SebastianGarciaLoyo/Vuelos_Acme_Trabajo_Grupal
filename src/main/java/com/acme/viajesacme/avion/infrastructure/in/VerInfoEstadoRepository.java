package com.acme.viajesacme.avion.infrastructure.in;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.acme.viajesacme.avion.domain.service.VerInfoService;

public class VerInfoEstadoRepository implements VerInfoService {
    @Override
    public List<Integer> print(ResultSet resultSet) {
        List<Integer> listaCodigos = new ArrayList<>();
        int rowCount = 0;

        try {

            System.out.println("\n\n==================================");
            System.out.println("         Estados Registrados");
            System.out.println("====================================");
            System.out.println("  ID\t|   ESTADO");
            System.out.println("====================================");

            while (resultSet.next()) {
                rowCount++;
                int code = resultSet.getInt("id_estado");
                listaCodigos.add(code);
                String status = resultSet.getString("estado");
                System.out.println("  " + code + ".\t|  " + status);
                System.out.println(" ");
            }

            if (rowCount == 0) {
                System.out.println("\nNo hay estados registrados\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaCodigos;
    }
}
