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
public class ErrVerifyEmail extends Exception {
    // Creando el constructor
    public ErrVerifyEmail(String opInput, String rightInfo) {
        super(
            MessageFormat.format(
                "Error en la validación del email. Usted ingresó \"{0}\", pero es de tipo \"{1}\"",
                opInput, rightInfo
        ));
    }
}
