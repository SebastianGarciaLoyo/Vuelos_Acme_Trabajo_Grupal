/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.infrastructure.in.signUpModules;

// Importando las clases y paquetes necesarios
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 *
 * @author mateo
 */
public class ValidarDocumentoIdentidad {
    // Declarando los atributos necesarios
    private String numId;
    private String typeId;
    private boolean stateIdNum;
    private boolean stateIdType;
    private boolean stateIdTgs;
    private int numOptionMenu;
    private ArrayList<String> lstIdValidos = new ArrayList<>();
    private ArrayList<String> lstTgs = new ArrayList<>();
    
    
    
    // Definiendo los constructores de la clase
    public ValidarDocumentoIdentidad() {
        // Inicializando los valores de la lista "lstIdValidos"
        this.lstIdValidos.add("tarjeta identidad");
        this.lstIdValidos.add("cédula ciudadanía");
        this.lstIdValidos.add("pasaporte");
        this.lstIdValidos.add("cédula extranjería");
        
        
        // Inicializando los valores de la lista "lstTgs"
        this.lstTgs.add("A+");
        this.lstTgs.add("A-");
        this.lstTgs.add("B+");
        this.lstTgs.add("B-");
        this.lstTgs.add("O+");
        this.lstTgs.add("O-");
        this.lstTgs.add("AB+");
        this.lstTgs.add("AB-");
    }
    
    public ValidarDocumentoIdentidad(long numId, int numOptionMenu) {
        // Definiendo los valores necesarios a sus respectivos atributos
        this.numId = Long.toString(numId);
        this.numOptionMenu = numOptionMenu;
        
        // Definiendo el booleano a partir de la función de validación principal
        this.stateIdNum = validarNumId(Long.toString(numId));
    }
    
    public ValidarDocumentoIdentidad(String typeId, int numOptionMenu) {
        // Definiendo los valores necesarios a sus respectivos atributos
        this.typeId = typeId;
        this.numOptionMenu = numOptionMenu;
        
        // Definiendo el booleano a partir de la función de validación principal
        this.stateIdType = validarTipoDocumento(typeId);
    }
    
    public ValidarDocumentoIdentidad(String tgs, int numOptionMenu, int relleno) {
        // Definiendo los valores necesarios a sus respectivos atributos
        this.typeId = tgs;
        this.numOptionMenu = numOptionMenu;
        
        // Definiendo el booleano a partir de la función de validación principal
        this.stateIdTgs = validarTipoSangre(tgs);
    }
    
    
    // Definiendo los getter y setter de "typeId"
    public String getTypeId() {
        return typeId;
    }
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    
    
    // Definiendo los getter y setter de "numId"
    public String getNumId() {
        return numId;
    }
    public void setNumId(String numId) {
        this.numId = numId;
    }
    
    
    // Definiendo los getter y setter de "stateIdNum"
    public boolean getStateIdNum() {
        return stateIdNum;
    }
    public void setStateIdNum(boolean stateIdNum) {
        this.stateIdNum = stateIdNum;
    }
    
    
    // Definiendo los getter y setter de "stateIdType"
    public boolean getStateIdtype() {
        return stateIdType;
    }
    public void setStateIdType(boolean stateIdType) {
        this.stateIdType = stateIdType;
    }
    
    
    // Definiendo los getter y setter de "stateIdTgs"
    public boolean getStateIdTgs() {
        return stateIdTgs;
    }
    public void setStateIdTgs(boolean stateIdTgs) {
        this.stateIdTgs = stateIdTgs;
    }
    
    
    // Definiendo los getter y setter de "numOptionMenu"
    public int getNumOptionMenu() {
        return numOptionMenu;
    }
    public void setNumOptionMenu(int numOptionMenu) {
        this.numOptionMenu = numOptionMenu;
    }
    
    
    // Definiendo los getter y setter de "lstIdValidos"
    public ArrayList<String> getLstIdValidos() {
        return lstIdValidos;
    }
    public void setLstIdValidos(String strIdValidos) {
        this.lstIdValidos.add(strIdValidos);
    }
    
    
    // Definiendo los getter y setter de "lstTgs"
    public ArrayList<String> getLstTgs() {
        return lstTgs;
    }
    public void setLstTgs(String lstTgs) {
        this.lstTgs.add(lstTgs);
    }
    
    
    
    // DEFINIENDO LAS FUNCIONES DE VALIDACIÓN NECESARIAS
    private static boolean validarNumId(String numId) {
        try {
            // Definiendo el patrón para la validación
            Pattern pattern = Pattern.compile("^\\d{7,15}$");

            // Definiendo si encuentra la coincidencia con "Matcher"
            Matcher matcher = pattern.matcher(numId);


            // Realizando la verificación de la coincidencia
            if(numId == null || numId.isEmpty()) {
                return false;

            } else if(numId.length() < 6 || numId.length() > 16) {
                return false;

            } else if(matcher.find()) {

                return true;

            } else {
                return false;
            }  //Fin estructura if-else
            
        } catch(PatternSyntaxException e) {
            return false;
            
        }  //Fin bloque principal try-catch
    }  //Fin función "validarNumId"
    
    
    private static boolean validarTipoDocumento(String typeId) {
        try {
            String strTypeIdLower = typeId.toLowerCase();
            
            if(strTypeIdLower == null || strTypeIdLower.isEmpty()) {
                return false;   
            }
            
            return new ValidarDocumentoIdentidad().getLstIdValidos().contains(strTypeIdLower);
            
        } catch(Exception e) {
            System.out.println(
                MessageFormat.format(
                    "Error al validar el documento.\nMensaje de error: {0}",
                    e.getMessage()
            ));
            return false;
        }
    }
    
    
    private static boolean validarTipoSangre(String tgs) {
        try {
            ArrayList<String> lstTgsInfo = new ValidarDocumentoIdentidad().getLstTgs();
            int cantTgs = lstTgsInfo.size();
            String strTgsLower = tgs.toLowerCase();
            boolean isCheck = false;
            
            if(strTgsLower == null || strTgsLower.isEmpty()) {
                return false;   
            }
            
            for(int i = 0; i < cantTgs; i++) {
                if(tgs.equals(lstTgsInfo.get(i))) {
                    isCheck = true;
                }
            }
            
            if(isCheck) {
                return true;
            } else {
                return false;
            }
            
        } catch(Exception e) {
            System.out.println(
                MessageFormat.format(
                    "Error al validar el documento.\nMensaje de error: {0}",
                    e.getMessage()
            ));
            return false;
        }
    }
}  //Fin función validarDocumentoIdentidad