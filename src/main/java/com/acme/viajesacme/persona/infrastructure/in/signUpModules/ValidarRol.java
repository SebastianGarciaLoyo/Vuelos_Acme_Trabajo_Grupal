/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.infrastructure.in.signUpModules;

// Importando las clases y paquetes necesarios
import java.util.ArrayList;


/**
 *
 * @author mateo
 */
public class ValidarRol {
    // Declarando los atributos necesarios
    private String rol;
    private boolean stateRol;
    private int numOptionMenu;
    private String rightRol;
    private ArrayList<String> lstRoles = new ArrayList<>();
    
    
    
    // Definiendo los constructores de la clase
    public ValidarRol() {
        // Inicializando los roles del sistema
        this.lstRoles.add("Administrador");
        this.lstRoles.add("Agente de ventas");
        this.lstRoles.add("Técnico de Mantenimiento");
        this.lstRoles.add("Cliente");
        this.lstRoles.add("Tripulación");
    }
    
    public ValidarRol(String rol, int numOptionMenu) {
        // Definiendo los valores necesarios a sus respectivos atributos
        this.rol = rol;
        this.numOptionMenu = numOptionMenu;
        
        
        // Definiendo el booleano a partir de la función de validación principal
        this.stateRol = validacionRol(rol, numOptionMenu);
    }
    
    
    
    // Definiendo los getter y setter de "rol"
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    // Definiendo los getter y setter de "stateRol"
    public boolean getStateRol() {
        return stateRol;
    }
    public void setStateRol(boolean stateRol) {
        this.stateRol = stateRol;
    }
    
    
    // Definiendo los getter y setter de "numOptionMenu"
    public int getNumOptionMenu() {
        return numOptionMenu;
    }
    public void setNumOptionMenu(int numOptionMenu) {
        this.numOptionMenu = numOptionMenu;
    }
    
    
    // Definiendo los getter y setter de "rightRol"
    public String getRightRol() {
        return rightRol;
    }
    public void setRightRol(String rightRol) {
        this.rightRol = rightRol;
    }
    
    
    // Definiendo los getter y setter de "lstRoles"
    public ArrayList<String> getLstRoles() {
        return lstRoles;
    }
    public void setLstRoles(String rolUser) {
        this.lstRoles.add(rolUser);
    }
    
    
    
    // DEFINIENDO LAS FUNCIONES DE VALIDACIÓN NECESARIAS
    private static boolean validacionRol(String rol, int numOptionMenu) {        
        try {
            // Definiendo las variables necesarias
            ValidarRol validarRol = new ValidarRol();
            ArrayList<String> lstRolesUser = validarRol.getLstRoles();
            boolean isCheck = false;
            
            
            // Recorriendo la lista de roles en busca de coincidencias
            for(int i = 0; i < lstRolesUser.size(); i++) {
                if(rol.equals(lstRolesUser.get(i))) {
                    isCheck = true;
                    validarRol.setRightRol(rol);
                }
            }
            
            
            // Verificando el estado de la variable "isCheck"
            if(isCheck) {
                return true;
                
            } else {
                return false;
            }
            
        } catch(Exception e) {
            System.out.println("Ha ocurrido un error inesperado, inténtelo de nuevo");
            return false;
        }
        
    }
}