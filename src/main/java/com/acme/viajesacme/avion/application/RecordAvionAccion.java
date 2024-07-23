package com.acme.viajesacme.avion.application;

import com.acme.viajesacme.avion.domain.entity.Avion;
import com.acme.viajesacme.avion.domain.service.AvionRecordService;

public class RecordAvionAccion {
    private AvionRecordService avionRecordService;
    
    public RecordAvionAccion(AvionRecordService avionRecordService) {
        this.avionRecordService = avionRecordService;
    }

    public int excuteRecord(Avion avion) {
        return this.avionRecordService.record(avion);
    }
}
