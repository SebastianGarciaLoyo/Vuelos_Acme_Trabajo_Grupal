/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.infrastructure.out;

// Importando las clases y paquetes necesarios
import com.acme.viajesacme.persona.domain.entity.Cliente;
import com.acme.viajesacme.persona.domain.service.ClienteService;
import com.acme.viajesacme.persona.infrastructure.config.DatabaseConfigPersona;
import com.acme.viajesacme.persona.infrastructure.config.DatabaseConfigPersona;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.MessageFormat;


/**
 *
 * @author camper
 */
public class AppRepository {    
    // Se debe crear tantas funciones como servicios hayan disponibles
    public static void crearCliente(ArrayList<Object> cliente) {
        // Definiendo la consulta SQL necesaria
        String sql = "INSERT INTO " +
                        "clientes(nombre, correo, password, telefono, codTel, rolUser, numDocId, id_tipo, tgsDocId)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        
        // Insertando la información a la base de datos
        try {
            // Estableciendo la conexión a la base de datos
            Connection connection = DatabaseConfigPersona.getConnection();
            
            
            // Preparando la consulta SQL a realizar
            PreparedStatement statement = connection.prepareStatement(
                sql, PreparedStatement.RETURN_GENERATED_KEYS
            );
            
            statement.setString(1, (String) cliente.get(0));
            statement.setString(2, (String) cliente.get(1));
            statement.setString(3, (String) cliente.get(2));
            statement.setLong(4, (Long) cliente.get(3));
            statement.setString(5, (String) cliente.get(4));
            statement.setString(6, (String) cliente.get(5));
            statement.setLong(7, (Long) cliente.get(6));
            statement.setInt(8, 2);
            statement.setString(9, (String) cliente.get(8));
            statement.execute();
            
            
            // Mostrando mensaje de operación exitosa
            System.out.println("¡La información ha sido guardada con éxito!");
            statement.close();
            connection.close();
            
        } catch(SQLException e) {
            System.out.println(
                MessageFormat.format(
                    "Ha ocurrido un error al guardar la información.\nMensaje de error: {0}",
                    e.getMessage()
            ));
        }
    }
    
    
   
    public ArrayList<String> findClientById(ArrayList<String> infoUser) {
        // Definiendo la consulta SQL necesaria
        String sql = "SELECT id_cliente, correo, password, rolUser " +
                        "FROM clientes " +
                        "WHERE correo = ? AND password = ?";
        ArrayList<String> lstInfoCliente = new ArrayList<>();
        
        
        // Creando la conexión a la base de datos
        try {
            Connection connection = DatabaseConfigPersona.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, infoUser.get(0));
            statement.setString(2, infoUser.get(1));
            
            
            // Ejecutar query
            try(ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next()) {
                    lstInfoCliente.add(String.valueOf(resultSet.getInt("id_cliente")));
                    lstInfoCliente.add(resultSet.getString("correo"));
                    lstInfoCliente.add(resultSet.getString("password"));
                    lstInfoCliente.add(resultSet.getString("rolUser"));
                }
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return lstInfoCliente;
    }
    
    
    
    public void actualizarCliente(Cliente cliente) {
        // Instrucciones para actualizar un cliente
    }
    
    
    
    public void eliminarCliente(Long id) {
        // Instrucciones para eliminar un cliente
    }
    
}
