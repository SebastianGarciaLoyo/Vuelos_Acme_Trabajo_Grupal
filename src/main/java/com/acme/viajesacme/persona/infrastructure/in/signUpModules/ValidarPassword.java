/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.infrastructure.in.signUpModules;

// Importando las clases y paquetes necesarios
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 *
 * @author mateo
 */
public class ValidarPassword {
    // Declarando los atributos necesarios
    private String password;
    private boolean statePassword;
    private int numOptionMenu;
    
    
    
    // Definiendo los constructores de la clase
    public ValidarPassword() {
        
    }
    
    public ValidarPassword(String password, int numOptionMenu) {
        // Definiendo los valores necesarios a sus respectivos atributos
        this.password = password;
        this.numOptionMenu = numOptionMenu;
        
        
        // Definiendo el booleano a partir de la función de validación principal
        this.setStatePassword(validarPassword(password, numOptionMenu));
    }
    
    
    
    // Definiendo los getter y setter de "email"
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    // Definiendo los getter y setter de "stateEmail"
    public boolean getStatePassword() {
        return statePassword;
    }
    public void setStatePassword(boolean statePassword) {
        this.statePassword = statePassword;
    }
    
    
    // Definiendo los getter y setter de "numOptionMenu"
    public int getNumOptionMenu() {
        return numOptionMenu;
    }
    public void setNumOptionMenu(int numOptionMenu) {
        this.numOptionMenu = numOptionMenu;
    }
    
    
    
    // DEFINIENDO LAS FUNCIONES DE VALIDACIÓN NECESARIAS
    private static boolean validarPassword(String password, int numOptionMenu) {
        // Verificar el cumplimiento de requerimientos mediante RegEx
        try {
            // Definiendo el patrón para la validación
            Pattern pattern = Pattern.compile(
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])" +
                "(?=.*[~!@#$%^&*-+?:])[A-Za-z0-9~!@#$%^&*-+?:]{8,}$"
            );
            
            // Definiendo si encuentra la coincidencia con "Matcher"
            Matcher matcher = pattern.matcher(password);
            
            // Realizando la verificación
            if(matcher.find()) {
                // Retornando el valor de true
                return true;
            } else {
                // Retornando el valor de false
                return false;
            }
            
        } catch(PatternSyntaxException e) {
            System.out.println("Error: Algo ha ido mal al verificar la contraseña.");
            return false;
        }
        
    }
}
