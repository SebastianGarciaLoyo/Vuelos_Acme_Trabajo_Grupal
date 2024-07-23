package com.acme.viajesacme.avion.application;

import java.sql.ResultSet;

import com.acme.viajesacme.avion.domain.service.ExtraerRegistroService;

public class ExtraerRegistroAccion {
    private ExtraerRegistroService extraerRegistroService;

    public ExtraerRegistroAccion(ExtraerRegistroService extraerRegistroService) {
        this.extraerRegistroService = extraerRegistroService;
    }

    public ResultSet extraerInfo() {
        return this.extraerRegistroService.extraerInfo();
    }
}
