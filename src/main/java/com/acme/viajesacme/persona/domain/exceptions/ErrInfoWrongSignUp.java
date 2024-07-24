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
public class ErrInfoWrongSignUp extends Exception {
    // Creando el constructor
    public ErrInfoWrongSignUp(String opInput, String rightInfo) {
        super(
            MessageFormat.format(
                "Error de digitación. Usted digitó \"{0}\", pero el campo es de tipo \"{1}\"", 
                opInput, rightInfo
        ));
    }
    
    public ErrInfoWrongSignUp(Long opInput, String rightInfo) {
        super(
            MessageFormat.format(
                "Error de digitación. Usted digitó \"{0}\", pero el campo es de tipo \"{1}\"",
                    opInput, rightInfo
        ));
    }
}
