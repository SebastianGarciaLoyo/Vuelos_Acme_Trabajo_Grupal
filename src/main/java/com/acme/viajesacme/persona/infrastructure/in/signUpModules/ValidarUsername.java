/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.infrastructure.in.signUpModules;

// Importando las clases y paquetes necesarios
import com.acme.viajesacme.persona.domain.exceptions.ErrWrongOperation;
import com.acme.viajesacme.persona.domain.exceptions.ErrWrongFormatProcess;
import java.lang.StringBuilder;
import java.util.ArrayList;


/**
 *
 * @author mateo
 */
public class ValidarUsername {
    // Declarando los atributos necesarios
    private String username;
    private boolean stateUsername;
    private int numOptionMenu;
    private String formatearUsername;
    private String resFinalUsername;
    
    
    // Definiendo los constructores de la clase
    public ValidarUsername() {
        
    }
    
    public ValidarUsername(String username, int numOptionMenu) {
        this.stateUsername = validarNombreUser(username, numOptionMenu);
    }
    
    
    // Definiendo los getter y setters de "username"
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    
    // Definiendo los getter y setters de "stateUsername"
    public boolean getStateUsername() {
        return stateUsername;
    }
    public void setStateUsername(boolean stateUsername) {
        this.stateUsername = stateUsername;
    }
    
    
    // Definiendo los getter y setters de "numOptionMenu"
    public int getNumOptionMenu() {
        return numOptionMenu;
    }
    public void setNumOptionMenu(int numOptionMenu) {
        this.numOptionMenu = numOptionMenu;
    }
    
    
    // Definiendo los getter y setters de "formatearUsername"
    public String getFormatearUsername() {
        return formatearUsername;
    }
    public void setFormatearUsername(String formatearUsername) {
        this.formatearUsername = formatearUsername;
    }
    
    
    // Definiendo los getter y setter de "resFinalUsername"
    public String getResFinalUsername() {
        return resFinalUsername;
    }
    public void setResFinalUsername(String resFinalUsername) {
        this.resFinalUsername = resFinalUsername;
    }
    
    
    
    
    
    // DEFINIENDO LAS FUNCIONES DE VALIDACIÓN NECESARIAS
    private static boolean validarNombreUser(String username, int numOptionMenu) {
        // Definiendo las instancias necesarias
        ValidarUsername validarUsername = new ValidarUsername();
        ClienteController clienteController = new ClienteController();
        
        
        // Definiendo los valores de los atributos necesarios
        validarUsername.setUsername(username);
        validarUsername.setNumOptionMenu(numOptionMenu);
        
        
        // Definiendo las variables necesarias
        boolean formatear;
        String strUsername = validarUsername.getUsername();
        
        
        // Verificar el estado del proceso de formateo
        while(true) {
            // Volver a realizar el proceso de formateo del string
            try {
                formatear = formatearUsername(strUsername, validarUsername);
                
                // Verificando el estado del booleano
                if(formatear) {
                    // Verificando el estado del booleano para "agregarEspaciosEntreMayusculas"
                    
                    String resFinalString = agregarEspaciosEntreMayusculas(validarUsername.getFormatearUsername());
                    boolean check = resFinalString != "";
                    
                    
                    if(check) {
                        clienteController.setResFinalString(resFinalString);
                        return true;
                        
                    } else { 
                        throw new ErrWrongOperation(); 
                    }
                    
                } else {
                    // Saltando error en caso de que "formatear" sea false
                    throw new ErrWrongFormatProcess();
                    
                }  //Fin if-else
                
            } catch(ErrWrongOperation e) {
                return false;
                
            } catch(ErrWrongFormatProcess ex) {
                return false;
                
            }  //Fin try-catch principal
        }  //Fin bucle while
    }  //Fin función "validarNombreUser()"
    
    
    // Paso 1: Estructurar el formateo del nombre de usuario
    private static boolean formatearUsername(String username, ValidarUsername validarUsername) {
        try {
            // Preparando el String para ser analizado y formateado
            StringBuilder sb = new StringBuilder();
            String strLower = username.toLowerCase();
            String[] lstPalabras = strLower.split(" ");

            
            // Recorriendo la lista "palabras" y filtrando los espacios sobrantes
            for(String elemento : lstPalabras) {
                if(elemento.length() != 0) {
                    sb.append(toTitle(elemento));
                }
            }
            
            
            // Agregando el stringbuilder a un atributo privado
            validarUsername.setFormatearUsername(sb.toString());
            

            // Retornando el estado de la función
            return true;
            
        } catch(Exception e) {
            // Retornando el estado de la función
            return false;
            
        }
    }
    
    
    // Paso 2: Convertir la primer letra de una palabra en mayúscula
    private static String toTitle(String palabra) {
        // Definiendo las variables de la función
        char[] lstPalabras = palabra.toCharArray();
        ArrayList<String> lstLetras = new ArrayList<>();
        StringBuilder sbLst = new StringBuilder();
        
        
        // Agregando los caracteres a la lista "lstLetras"
        for(char caracter : lstPalabras) {
            lstLetras.add(String.valueOf(caracter));
        }
        
        
        // Convirtiendo la lista a String formateado
        for(int i = 0; i < lstLetras.size(); i++) {
            if(i == 0) {
                // Agregar los caracteres al string en mayúscula
                sbLst.append(lstLetras.get(i).toUpperCase());
                
            } else {
                // Agregar los caracteres al string tal como está en la lista
                sbLst.append(lstLetras.get(i));
            }
        }
        
        
        // Retornando el valor final de la función
        return sbLst.toString();
    }
    
    
    // Paso n°3: Agregar los espacios antes del inicio de cada mayúscula
    private static String agregarEspaciosEntreMayusculas(String texto) {
        // Declarando las variables de la función
        StringBuilder resultado = new StringBuilder();
        boolean esMayusculaAnterior = false;
        
        
        try {
            // Agregando el espacio en su lugar correspondiente
            for(int i = 0; i < texto.length(); i++) {
                char caracter = texto.charAt(i);
                boolean esMayusculaActual = Character.isUpperCase(caracter);

                if(esMayusculaActual && !esMayusculaAnterior) {
                    resultado.append(' ');
                }

                // Definiendo los valores a las respectivas variables
                resultado.append(caracter);
                esMayusculaAnterior = esMayusculaActual;
            }

            // Retornando el valor final de la función
            return resultado.toString().trim();
            
        } catch(Exception e) {
            // Retornando el estado de la función
            return "";
            
        }
    }
}