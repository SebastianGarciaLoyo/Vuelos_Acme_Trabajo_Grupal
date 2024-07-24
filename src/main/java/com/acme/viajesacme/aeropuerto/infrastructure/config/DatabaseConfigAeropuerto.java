package com.acme.viajesacme.aeropuerto.infrastructure.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfigAeropuerto {
    // Definiendo las credenciales para la base de datos
    private static final String URL = "jdbc:mysql://root:QEQTbxsgNWQduPAZzPdvqPbRKfYFFhZC@viaduct.proxy.rlwy.net:26806/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "QEQTbxsgNWQduPAZzPdvqPbRKfYFFhZC";

        // Declarando el metodo para poder ingresar a la base de datos
        public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
