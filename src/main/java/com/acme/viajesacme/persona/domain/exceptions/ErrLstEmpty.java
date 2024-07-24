/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.domain.exceptions;

/**
 *
 * @author mateo
 */
public class ErrLstEmpty extends Exception {
    // Creando el constructor
    public ErrLstEmpty() {
        super("La lista destinada a almacenar la información de la base de datos está vacía. Verifique que las credenciales sean correctas e inténtelo de nuevo");
    }
}
