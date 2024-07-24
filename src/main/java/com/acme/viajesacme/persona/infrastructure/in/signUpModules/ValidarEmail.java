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
public class ValidarEmail {
    // Declarando los atributos necesarios
    private String email;
    private boolean stateEmail;
    private int numOptionMenu;
    
    
    
    // Definiendo los constructores de la clase
    public ValidarEmail() {
        
    }
    
    public ValidarEmail(String email, int numOptionMenu) {
        // Definiendo los valores necesarios a sus respectivos atributos
        this.email = email;
        this.numOptionMenu = numOptionMenu;
        
        
        // Definiendo el booleano a partir de la función de validación principal
        this.setStateEmail(validarEmail(email, numOptionMenu));
    }
    
    
    
    // Definiendo los getter y setter de "email"
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    // Definiendo los getter y setter de "stateEmail"
    public boolean getStateEmail() {
        return stateEmail;
    }
    public void setStateEmail(boolean stateEmail) {
        this.stateEmail = stateEmail;
    }
    
    
    // Definiendo los getter y setter de "numOptionMenu"
    public int getNumOptionMenu() {
        return numOptionMenu;
    }
    public void setNumOptionMenu(int numOptionMenu) {
        this.numOptionMenu = numOptionMenu;
    }
    
    
    // DEFINIENDO LAS FUNCIONES DE VALIDACIÓN NECESARIAS
    private static boolean validarEmail(String email, int numOptionMenu) {
        // Definiendo los valores de los atributos necesarios
        ValidarEmail validarEmail = new ValidarEmail();
        validarEmail.setEmail(email);
        validarEmail.setNumOptionMenu(numOptionMenu);
        
        
        // Testeando la validación a partir de RegEx utilizando "try-catch"
        try {
            // Definiendo el patrón para la validación
            Pattern pattern = Pattern.compile(
                "[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
            );  //Fin patrón RegEx
            
            
            // Definiendo si se encuentra la coincidencia con "matcher"
            Matcher matcher = pattern.matcher(email);
            
            if(matcher.find()) { 
                return true;
                
            } else { 
                return false; 
            }
            
        } catch(PatternSyntaxException e) {
            return false;
            
        }  //Fin try-catch principal
    }  //Fin función "validarEmail()"
}  //Fin clase "ValidarEmail()"
