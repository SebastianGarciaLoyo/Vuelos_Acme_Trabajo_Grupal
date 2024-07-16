/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.avion.application;

import com.acme.viajesacme.avion.domain.entity.Avion;
import com.acme.viajesacme.avion.domain.service.AvionService;

/**
 *
 * @author mateo
 */
// firmando contrato
public class CreateAvionUseCase {
    private final AvionService avionService;

// creando la funcion
    public CreateAvionUseCase(AvionService avionService) {
        this.avionService = avionService;
    }

// Ejecutandola
    public void execute(Avion avion) {
        avionService.createAvion(avion);
    }
}
