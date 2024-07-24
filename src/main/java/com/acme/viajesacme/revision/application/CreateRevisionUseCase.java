/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.revision.application;

import com.acme.viajesacme.revision.domain.entity.Revision;
import com.acme.viajesacme.revision.domain.service.RevisionService;

/**
 *
 * @author mateo
 */
public class CreateRevisionUseCase {
    private final RevisionService revisionService;

    public CreateRevisionUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;

    }

    public void execute(Revision revision) {
        revisionService.crearRevision(revision);
    }
}
