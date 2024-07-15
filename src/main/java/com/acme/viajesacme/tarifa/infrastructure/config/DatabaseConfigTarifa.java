/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.tarifa.infrastructure.config;

// Importando las clases y paquetes necesarios
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author camper
 */
public class DatabaseConfigTarifa {
    // Definiendo las credenciales de acceso a la base de datos
    private static final String URL = "jdbc:mysql://root:QEQTbxsgNWQduPAZzPdvqPbRKfYFFhZC@viaduct.proxy.rlwy.net:26806/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "QEQTbxsgNWQduPAZzPdvqPbRKfYFFhZC";
    
    // Declarando método para conección a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
