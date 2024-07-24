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
import java.util.List;
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
    private String rolUser;
    
    
    // Definiendo los constructores de la clase
    public ValidarCredenciales() {
        
    }
    
    public String ValidarCredenciales(String email, String password) {
        ArrayList<Object> lstResValidarLogin = new ArrayList<>();
        lstResValidarLogin = validarLogin(email, password);
        
        this.checkLogin = (boolean) lstResValidarLogin.get(0);
        this.rolUser = (String) lstResValidarLogin.get(1);
        
        return (String) lstResValidarLogin.get(1);
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
    
    
    // Definiendo los getter y setter de "rolUser"
    public String getRolUser() {
        return rolUser;
    }
    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }
    
    
    
    
    // DEFINIENDO LAS FUNCIONES NECESARIAS
    private ArrayList<Object> validarLogin(String email, String password) {
        // Definiendo las instancias necesarias
        ValidarCredenciales validarCrendenciales = new ValidarCredenciales();
        validarCrendenciales.setEmail(email);
        validarCrendenciales.setPassword(password);
        
        
        // Verificando la validez del inicio de sesión
        try {
            return checkLogin(validarCrendenciales);
            
        } catch(Exception e) {
            System.out.println(
                MessageFormat.format(
                    "Ha ocurrido un error inesperado.\nMensaje de error: {0}",
                    e.getMessage()
            ));
            
            return new ArrayList<>(List.of(true));
        }
    }
    
    
    
    private ArrayList<Object> checkLogin(ValidarCredenciales validarCredenciales) {        
        // Declarando las variables de la función
        boolean stateLogIn = false;
        String rolUser = "";
        
        
        // Definiendo las instancias necesarias
        AppRepository appRepository = new AppRepository();
        ArrayList<Object> lstResultFunction = new ArrayList<>();
        ArrayList<String> lstInfoUser = new ArrayList<>();
        ArrayList<String> lstResInfoUser = new ArrayList<>();
        
        
        // Agregando la información a "lstInfoUser"
        lstInfoUser.add(validarCredenciales.getEmail());
        lstInfoUser.add(validarCredenciales.getPassword());
        
        
        // Verificar si el inicio de sesión puede continuar
        try {
            lstResInfoUser = appRepository.findClientById(lstInfoUser);

            if(lstResInfoUser.size() == 0) {
                throw new ErrLstEmpty();

            } else {
                // Validando la existencia del usuario                
                if(lstInfoUser.get(0).equals(lstResInfoUser.get(1)) && lstInfoUser.get(1).equals(lstResInfoUser.get(2))) {
                    validarCredenciales.setCheckLogin(true);
                    validarCredenciales.setRolUser(lstResInfoUser.get(3));
                    stateLogIn = true;
                    rolUser = lstResInfoUser.get(3);

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

        }  //Fin bloque principal try-catch
        
        // Retornando los valores necesarios en un ArrayList
        lstResultFunction.add(stateLogIn);
        lstResultFunction.add(rolUser);
        
        return lstResultFunction;
    }  //Fin función "checkLogin"
}  //Fin clase "validarCredenciales"
