/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.infrastructure.in.loginModules;

// Importando las clases y paquetes necesarios
import com.acme.viajesacme.persona.infrastructure.out.AppRepository;
import com.acme.viajesacme.persona.domain.exceptions.ErrLstEmpty;
import com.acme.viajesacme.persona.domain.exceptions.ErrCredLoginUser;
import com.acme.viajesacme.persona.domain.exceptions.ErrCountIntentos;
import java.text.MessageFormat;
import java.util.ArrayList;


/**
 *
 * @author mateo
 */
public class ValidarCredenciales {
    // Definiendo los atributos necesarios
    private boolean checkLogin;
    private String email;
    private String password;
    
    
    // Definiendo los constructores de la clase
    public ValidarCredenciales() {
        
    }
    
    public ValidarCredenciales(String email, String password) {
        this.checkLogin = validarLogin(email, password);
    }
    
    
    
    // Definiendo los getter y setter de "checkLogin"
    public boolean getCheckLogin() {
        return checkLogin;
    }
    public void setCheckLogin(boolean checkLogin) {
        this.checkLogin = checkLogin;
    }
    
    
    // Definiendo los getter y setter de "email"
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    // Definiendo los getter y setter de "password"
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    // DEFINIENDO LAS FUNCIONES NECESARIAS
    private static boolean validarLogin(String email, String password) {
        // Definiendo las instancias necesarias
        ValidarCredenciales validarCrendenciales = new ValidarCredenciales();
        validarCrendenciales.setEmail(email);
        validarCrendenciales.setPassword(password);
        
        
        // Verificando la validez del inicio de sesión
        try {
            if(checkLogin(validarCrendenciales)) { return true; } 
            else { return false; }
            
        } catch(Exception e) {
            System.out.println(
                MessageFormat.format(
                    "Ha ocurrido un error inesperado.\nMensaje de error: {0}",
                    e.getMessage()
            ));
            
            return false;
        }
    }
    
    
    
    private static boolean checkLogin(ValidarCredenciales validarCredenciales) {        
        // Definiendo las instancias necesarias
        AppRepository appRespository = new AppRepository();
        ArrayList<String> lstInfoUser = new ArrayList<>();
        ArrayList<String> lstResInfoUser = new ArrayList<>();
        
        
        // Agregando la información a "lstInfoUser"
        lstInfoUser.add(validarCredenciales.getEmail());
        lstInfoUser.add(validarCredenciales.getPassword());
        
        
        // Verificar si el inicio de sesión puede continuar
        try {
            lstResInfoUser = appRespository.findClientById(lstInfoUser);

            if(lstResInfoUser.size() == 0) {
                throw new ErrLstEmpty();

            } else {
                // Validando la existencia del usuario                
                if(lstInfoUser.get(0).equals(lstResInfoUser.get(1)) && lstInfoUser.get(1).equals(lstResInfoUser.get(2))) {
                    validarCredenciales.setCheckLogin(true);
                    // Aquí llamar a la clase de gestión de roles de usuario

                } else {
                    throw new ErrCredLoginUser();
                }
            }

        } catch(ErrLstEmpty e) {
            System.out.println(
                MessageFormat.format(
                    "El usuario ingresado no existe. Verifique e inténtelo nuevamente.\nMensaje de Error: {0}",
                    e.getMessage()
            ));

        } catch(ErrCredLoginUser ex) {

                    System.out.println(
                        MessageFormat.format(
                            "Error: La información de inicio de sesión es errónea o el usuario no es encuentra registrado.\nMensaje de error: {0}",
                            ex.getMessage()
                    ));

        } catch(Exception exApp) {
            System.out.println(
                MessageFormat.format(
                    "Ha ocurrido un error inesperado.\nMensaje de error: {0}\nTrazado del error: {1}",
                    exApp.getMessage(), exApp.getStackTrace()
                )
            );
            System.exit(1);
            return false;

        }  //Fin bloque principal try-catch
        
        return true;
    }  //Fin función "checkLogin"
}  //Fin clase "validarCredenciales"
