/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.vuelo.application;

import com.acme.viajesacme.vuelo.domain.entity.Vuelo;
import com.acme.viajesacme.vuelo.domain.service.VueloService;

/**
 *
 * @author mateo
 */
public class CreateVueloUseCase {
    private final VueloService vueloService;

    public CreateVueloUseCase(VueloService vueloService) {
            this.vueloService = vueloService;
    }

    public void execute(Vuelo vuelo) {
        vueloService.createVuelo(vuelo);
    }
}
