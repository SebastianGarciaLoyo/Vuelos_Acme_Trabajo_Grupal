/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.domain.exceptions;

/**
 *
 * @author mateo
 */
public class ErrWrongFormatProcess extends Exception {
    // Creando el constructor
    public ErrWrongFormatProcess() {
        super("Ha ocurrido un error inesperado al realizar el proceso de formateo necesario. Reintentando...");
    }
}
