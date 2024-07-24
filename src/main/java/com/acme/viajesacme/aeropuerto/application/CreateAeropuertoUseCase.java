package com.acme.viajesacme.aeropuerto.application;

import com.acme.viajesacme.aeropuerto.domain.entity.Aeropuerto;
import com.acme.viajesacme.aeropuerto.domain.service.AeropuertoService;

public class CreateAeropuertoUseCase {
    private final AeropuertoService aeropuertoService;

    public CreateAeropuertoUseCase(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;

    }

    public void execute(Aeropuerto aeropuerto) {
        aeropuertoService.crearAeropuerto(aeropuerto);
    }
}
