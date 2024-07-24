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
public class ValidarTelefono {
    // Declarando los atributos necesarios
    private long telefono;
    private String codTelefono;
    private boolean stateTelefono;
    private boolean stateCodTel;
    private int numOptionMenu;
    
    
    
    // Definiendo los constructores de la clase
    public ValidarTelefono() {
        
    }
    
    public ValidarTelefono(long telefono, int numOptionMenu) {
        // Definiendo los valores necesarios a sus respectivos atributos
        this.telefono = telefono;
        this.numOptionMenu = numOptionMenu;
        // Definiendo el booleano a partir de la función de validación principal
        this.stateTelefono = validacionTelefono(telefono, numOptionMenu);
    }
    
    public ValidarTelefono(String codTelefono, int numOptionMenu) {
        // Definiendo los valores necesarios a sus respectivos atributos
        this.codTelefono = codTelefono;
        this.numOptionMenu = numOptionMenu;
        
        
        // Definiendo el booleano a partir de la función de validación principal
        this.stateCodTel = validacionCodTel(codTelefono);
    }
    
    
    
    // Definiendo los getter y setter de "telefono"
    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    
    // Definiendo los getter y setter de "codTelefono"
    public String getCodTelefono() {
        return codTelefono;
    }
    public void setCodTelefono(String codTelefono) {
        this.codTelefono = codTelefono;
    }
    
    
    // Definiendo los getter y setter de "stateTelefono"
    public boolean getStateTelefono() {
        return stateTelefono;
    }
    public void setStateTelefono(boolean stateTelefono) {
        this.stateTelefono = stateTelefono;
    }
    
    
    // Definiendo los getter y setter de "numOptionMenu"
    public int getNumOptionMenu() {
        return numOptionMenu;
    }
    public void setNumOptionMenu(int numOptionMenu) {
        this.numOptionMenu = numOptionMenu;
    }
    
    
    // Definiendo los getter y setter de "stateCodTel"
    public boolean getStateCodTel() {
        return stateCodTel;
    }
    public void setStateCodTel(boolean stateCodTel) {
        this.stateCodTel = stateCodTel;
    }
    
    
    // DEFINIENDO LAS FUNCIONES DE VALIDACIÓN NECESARIAS
    private static boolean validacionTelefono(long numTel, int numOptionMenu) {
        try {
            int countNumTel = countNums(numTel);
            
            // Validar que el número de teléfono tenga la cantidad correcta de dígitos
            if(countNumTel >= 16 || countNumTel <= 5) { return false; } 
            else { return true; }
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
            
        }  //Fin try-catch principal
    }  //Fin función "validacionTelefono"
    
    
    // Contando la cantidad de números en una variable "long"
    private static int countNums(long numTel) {
        // Definiendo las variables necesarias
        String strLong = String.valueOf(numTel);
        int count = 0;
        
        
        // Bucle for para contar cantidad de números
        for(char num : strLong.toCharArray()) {
            if(!Character.isWhitespace(num)) {
                count++;
            }
        }
        
        return count;
    }  //Fin función "countNums"
    
    
    private static boolean validacionCodTel(String codTel) {
        try {
            // Definiendo el patrón para la validación
            Pattern pattern = Pattern.compile("^\\+\\d{1,3}$");
            
            // Definiendo si encuentra la coincidencia con "Matcher"
            Matcher matcher = pattern.matcher(codTel);
            
            
            // Realizando la verificación de la coincidencia
            if(matcher.find()) {
                // Retornando true
                return true;
                
            } else {
                // Retornando false
                return false;
            }
            
        } catch(PatternSyntaxException e) {
            System.out.println("Error: Algo ha ido mal al verificar el código telefónico.");
            return false;
            
        }  //Fin try-catch principal
    }  //Fin función "validacionCodTel"    
}  //Fin función "validarTelefono"
