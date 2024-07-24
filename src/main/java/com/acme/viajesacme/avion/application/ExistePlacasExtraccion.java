package com.acme.viajesacme.avion.application;

import java.util.List;

import com.acme.viajesacme.avion.domain.service.PlacasExtraccionService;

public class ExistePlacasExtraccion {
    private PlacasExtraccionService placasExtraccionService;

    public ExistePlacasExtraccion(PlacasExtraccionService placasExtraccionService) {
        this.placasExtraccionService = placasExtraccionService;
    }

    public List<String> executeExtract() {
        return this.placasExtraccionService.extraerPlacas();
    }
}
