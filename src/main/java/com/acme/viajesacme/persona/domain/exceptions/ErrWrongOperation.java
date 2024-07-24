/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.domain.exceptions;


/**
 *
 * @author mateo
 */
public class ErrWrongOperation extends Exception {
    // Creando el constructor
    public ErrWrongOperation() {
        super("Ha ocurrido un error inesperado al agregar formato de texto. Reintentando...");
    }
}
