/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.trayecto.application;

import com.acme.viajesacme.trayecto.domain.entity.Trayecto;
import com.acme.viajesacme.trayecto.domain.service.TrayectoService;

/**
 *
 * @author mateo
 */
public class CreateTrayectoUseCase {
    private final TrayectoService trayectoService;

    public CreateTrayectoUseCase(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }

    public void execute(Trayecto trayecto) {
        trayectoService.crearTrayecto(trayecto);
    }
}
