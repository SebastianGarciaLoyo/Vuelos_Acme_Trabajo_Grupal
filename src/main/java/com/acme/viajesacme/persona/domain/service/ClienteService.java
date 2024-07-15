/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.acme.viajesacme.persona.domain.service;

// Importando las clases y paquetes necesarios
import com.acme.viajesacme.persona.domain.entity.Cliente;


/**
 *
 * @author camper
 */
public interface ClienteService {
    void crearCliente(Cliente cliente);
    Cliente findClientById(Long id);
    void actualizarCliente(Cliente cliente);
    void EliminarCliente(Long id);
}
