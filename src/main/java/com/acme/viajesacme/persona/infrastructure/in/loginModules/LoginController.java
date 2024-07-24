/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.infrastructure.in.loginModules;

// Importando las clases y paquetes necesarios
import com.acme.viajesacme.persona.infrastructure.in.signUpModules.ValidarEmail;
import com.acme.viajesacme.persona.infrastructure.in.signUpModules.ValidarPassword;
import com.acme.viajesacme.persona.domain.exceptions.ErrCountIntentos;
import com.acme.viajesacme.persona.domain.exceptions.ErrWrongLogin;
import com.acme.viajesacme.persona.infrastructure.in.loginModules.ValidarCredenciales;
import java.util.Scanner;
import java.text.MessageFormat;
import java.util.InputMismatchException;


/**
 *
 * @author mateo
 */
public class LoginController {
    // Definiendo los atributos necesarios
    private String emailLogin;
    private String passwordLogin;
    private String rolUserLogin;
    private boolean stateLogin;
    
    
    // Declarando los constructores de la clase
    public LoginController() {
        initLogin();
    }
    
    public LoginController(int relleno) {
        
    }
    
    
    // Definiendo los getter y setter de "email"
    public String getEmailLogin() {
        return emailLogin;
    }
    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }
    
    
    // Definiendo los getter y setter de "password"
    public String getPasswordLogin() {
        return passwordLogin;
    }
    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }
    
    
    // Definiendo los getter y setter de "rolUser"
    public String getRolUserLogin() {
        return rolUserLogin;
    }
    public void setRolUser(String rolUserLogin) {
        this.rolUserLogin = rolUserLogin;
    }
    
    
    // Definiendo los getter y setter de "stateLogin"
    public boolean getStateLogin() {
        return stateLogin;
    }
    public void setStateLogin(boolean stateLogin) {
        this.stateLogin = stateLogin;
    }
    
    
    
    
    // DECLARANDO LAS FUNCIONES NECESARIAS
    public static String initLogin() {
        // Definiendo las variables necesarias
        int countErr = 0;
        Scanner sc = new Scanner(System.in);
        LoginController loginController = new LoginController(0);
        
        
        // Validando la información ingresada en el email
        while(true) {
            try {
                System.out.print("\nCorreo Electrónico: ");
                String emailUser = sc.nextLine();

                
                // Verificando el estado del email ingresado
                boolean checkState = new ValidarEmail(emailUser, 1).getStateEmail();
                
                if(checkState) {
                    loginController.setEmailLogin(emailUser);
                    break;

                } else {
                    throw new ErrWrongLogin();
                }

            } catch(ErrWrongLogin e) {
                // Verificar si el usuario alcanzó el límite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);

                    } else {
                        System.out.println(
                            MessageFormat.format(
                                "Error: El correo electrónico ingresado es incorrecto.\nMensaje de error: {0}",
                                e.getMessage()
                        ));
                        countErr++;
                        continue;
                    }  //Fin condicional if-else

                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                            "Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador.\nMensaje de error: {0}",
                            ex.getMessage()
                    ));
                    break;
                }  //Fin bloque secundario try-catch

            } catch(InputMismatchException exIn) {
                System.out.println(
                    MessageFormat.format(
                        "Error al ingresar la información requerida.\nMensaje de error: {0}",
                        exIn.getMessage()
                ));
                break;
            }  //Fin bloque principal try-catch
        }  //Fin bucle while
        
        
        // Validando la información ingresada en el email
        while(true) {
            try {
                System.out.print("\nContraseña: ");
                String passwordUser = sc.nextLine();

                
                // Verificando el estado del email ingresado
                boolean checkState = new ValidarPassword(passwordUser, 2).getStatePassword();
                
                if(checkState) {
                    loginController.setPasswordLogin(passwordUser);
                    break;

                } else {
                    throw new ErrWrongLogin();
                }

            } catch(ErrWrongLogin e) {
                // Verificar si el usuario alcanzó el límite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);

                    } else {
                        System.out.println(
                            MessageFormat.format(
                                "Error: La contraseña ingresada es inválida.\nMensaje de error: {0}",
                                e.getMessage()
                        ));
                        countErr++;
                        continue;
                    }  //Fin condicional if-else

                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                            "Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador.\nMensaje de error: {0}",
                            ex.getMessage()
                    ));
                    break;
                }  //Fin bloque secundario try-catch

            } catch(InputMismatchException exIn) {
                System.out.println(
                    MessageFormat.format(
                        "Error al ingresar la información requerida.\nMensaje de error: {0}",
                        exIn.getMessage()
                ));
                
                break;
            }  //Fin bloque principal try-catch
        }  //Fin bucle while
        
        
        // Validando la existencia de las credenciales
        ValidarCredenciales validador = new ValidarCredenciales();
        
        return validador.ValidarCredenciales(
            loginController.getEmailLogin(), loginController.getPasswordLogin()
        );
        
    }  //Fin función initLogin
}  //Fin clase LoginController
