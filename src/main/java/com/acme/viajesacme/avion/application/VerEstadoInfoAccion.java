package com.acme.viajesacme.avion.application;

import java.sql.ResultSet;
import java.util.List;

import com.acme.viajesacme.avion.domain.service.VerInfoService;

public class VerEstadoInfoAccion {
    private VerInfoService verInfoService;

    public VerEstadoInfoAccion(VerInfoService verInfoService) {
        this.verInfoService = verInfoService;
    }

    public List<Integer> executeView(ResultSet resultSet) {
        return this.verInfoService.print(resultSet);
    }
}
