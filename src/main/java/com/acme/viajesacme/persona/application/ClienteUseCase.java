/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.application;

// Importando las clases y paquetes necesarios
import com.acme.viajesacme.persona.domain.entity.Cliente;
import com.acme.viajesacme.persona.domain.service.ClienteService;


/**
 *
 * @author mateo
 */
public class ClienteUseCase {
    // Declarando el contrato entre application y domain
    private final ClienteService clienteService;
    
    // Concretando el contrato mediante el constructor de la clase
    public ClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    
    // Definiendo el método a ejecutar
    public void execute(Cliente cliente) {
        clienteService.crearCliente(cliente);
    }
}
