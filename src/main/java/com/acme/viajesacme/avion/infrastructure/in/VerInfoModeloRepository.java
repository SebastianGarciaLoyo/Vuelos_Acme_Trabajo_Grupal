package com.acme.viajesacme.avion.infrastructure.in;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.acme.viajesacme.avion.domain.service.VerInfoService;

public class VerInfoModeloRepository implements VerInfoService {
    @Override
    public List<Integer> print(ResultSet resultSet) {
        List<Integer> listaCodigos = new ArrayList<>();
        int rowCount = 0;

        try {

            System.out.println("\n\n==============================");
            System.out.println("         Modelos Registrados");
            System.out.println("====================================");
            System.out.println("  ID\t|   MODELO");
            System.out.println("====================================");

            while (resultSet.next()) {
                
                rowCount++;
                int code = resultSet.getInt("id_modelo");
                listaCodigos.add(code);
                String model = resultSet.getString("modelo");
                System.out.println("  " + code + ".\t|  " + model);
                System.out.println(" ");
            }

            if (rowCount == 0) {
                
                System.out.println("\nNo hay modelos registrados\n");
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaCodigos;
    }
}
