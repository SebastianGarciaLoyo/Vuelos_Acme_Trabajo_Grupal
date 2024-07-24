/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.acme.viajesacme;

// Importando las clases y paquetes necesarios
import com.acme.viajesacme.persona.infrastructure.in.signUpModules.ClienteController;
import com.acme.viajesacme.persona.infrastructure.in.loginModules.LoginController;


/**
 *
 * @author camper
 */
public class ViajesAcme {

    public static void main(String[] args) {
        // Definiendo las instancias necesarias
        ClienteController modernLogin = new ClienteController();
        
        //modernLogin.registrarUser();
        
        boolean example = new LoginController().getStateLogin();
    }
}
