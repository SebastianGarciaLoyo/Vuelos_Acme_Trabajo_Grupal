/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.domain.exceptions;

// Importando las clases y paquetes necesarios
import java.text.MessageFormat;


/**
 *
 * @author mateo
 */
public class ErrWrongTel extends Exception {
    // Creando el constructor
    public ErrWrongTel(long numTel, String rightInfo) {
        super(
            MessageFormat.format(
                "Error al validar el número de teléfono. Usted ingreso el teléfono \"{0}\", pero su formato debe ser \"{1}\"",
                numTel, rightInfo
        ));
    }
}
