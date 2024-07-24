/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.infrastructure.in.signUpModules;

// Importando las clases y paquetes necesarios
import com.acme.viajesacme.persona.application.ClienteUseCase;
import com.acme.viajesacme.persona.domain.entity.Cliente;
import com.acme.viajesacme.persona.domain.exceptions.ErrInfoWrongSignUp;
import com.acme.viajesacme.persona.domain.exceptions.ErrCountIntentos;
import com.acme.viajesacme.persona.domain.service.ClienteService;
import com.acme.viajesacme.persona.infrastructure.in.signUpModules.ValidarUsername;
import com.acme.viajesacme.persona.infrastructure.in.signUpModules.ValidarEmail;
import com.acme.viajesacme.persona.infrastructure.in.signUpModules.ValidarPassword;
import com.acme.viajesacme.persona.infrastructure.in.signUpModules.ValidarRol;
import com.acme.viajesacme.persona.infrastructure.in.signUpModules.ValidarTelefono;
import com.acme.viajesacme.persona.infrastructure.in.signUpModules.ValidarDocumentoIdentidad;
import com.acme.viajesacme.persona.infrastructure.out.AppRepository;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author camper
 */
public class ClienteController {
    // Definiendo las constantes para los colores de texto en consola
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    
    
    // Definiendo los atributos necesarios
    private String resFinalString;
    private ClienteUseCase registroUsuario;
    private ArrayList<Object> lstInfoUser = new ArrayList<>();
    
    
    
    // Definiendo los constructores de la clase
    public ClienteController() {
        
    }
    
    
    public ClienteController(ClienteUseCase registroUsuario) {
        this.registroUsuario = registroUsuario;
    }
    
    
    
    // Declarando los getter y setter del atributo "lstInfoUser"
    public ArrayList<Object> getLstInfoUser() {
        return lstInfoUser;
    }
    public void setLstInfoUser(Object lstInfoUser) {
        this.lstInfoUser.add(lstInfoUser);
    }
    
    
    // Declarando los getter y setter del atributo "resFinalString"
    public String getResFinalString() {
        return resFinalString;
    }
    public void setResFinalString(String resFinalString) {
        this.resFinalString = resFinalString;
    }
    
    
    
    // Declarando la función "registrarUser"
    public void registrarUser() {
        // Declarando las variables necesarias
        boolean isUsername;
        boolean isEmail;
        boolean isPassword;
        boolean isTel;
        boolean isCodTel;
        boolean isRolUser;
        boolean isNumId;
        boolean isTypeId;
        boolean isTgs;
        
        
        // Imprimiendo el nombre de la sección
        System.out.println( "______           _     _               _   _                      _       \n" +
                            "| ___ \\         (_)   | |             | | | |                    (_)      \n" +
                            "| |_/ /___  __ _ _ ___| |_ _ __ ___   | | | |___ _   _  __ _ _ __ _  ___  \n" +
                            "|    // _ \\/ _` | / __| __| '__/ _ \\  | | | / __| | | |/ _` | '__| |/ _ \\ \n" +
                            "| |\\ \\  __/ (_| | \\__ \\ |_| | | (_) | | |_| \\__ \\ |_| | (_| | |  | | (_) |\n" +
                            "\\_| \\_\\___|\\__, |_|___/\\__|_|  \\___/   \\___/|___/\\__,_|\\__,_|_|  |_|\\___/ \n" +
                            "            __/ |                                                         \n" +
                            "           |___/                                                          ");
        System.out.println("\n");
        
        
        
        ClienteController clienteController = new ClienteController();
        
        // Recogiendo la información del usuario
        isUsername = checkStateUsername(clienteController);
        isEmail = checkStateEmail(clienteController);
        isPassword = checkStatePassword(clienteController);
        isTel = checkStateTel(clienteController);
        isCodTel = checkStateCodTel(clienteController);
        isRolUser = checkStateRolUser(clienteController);
        isNumId = checkStateNumId(clienteController);
        isTypeId = checkStateTypeId(clienteController);
        isTgs = checkStateTgs(clienteController);
        
        
        // Almacenando la información guardada a la base de datos
        AppRepository.crearCliente(clienteController.getLstInfoUser());
    }
    
    
    // Checkear el estado de la operación de validación del username
    public static boolean checkStateUsername(ClienteController clienteController) {
        // Declarando las variables necesarias
        int countErr = 0;
        Scanner sc = new Scanner(System.in);
        
        
        // Bucle infinito hasta que la validación sea correcta o termine por intentos fallidos
        while(true) {
            try {
                System.out.print("Nombre de usuario: ");
                String user = sc.nextLine();
                ValidarUsername validarUsername = new ValidarUsername(user, 0);
                
                
                // Verificar si la operación fue exitosa
                if(validarUsername.getStateUsername()) {
                    // Agregar la información al ArrayList<>()
                    clienteController.setLstInfoUser(user);
                    return true;
                    
                } else {
                    throw new ErrInfoWrongSignUp(user, "Texto. Ej: DavMateo");
                    
                }  //Fin if-else
                
            } catch(ErrInfoWrongSignUp e) {
                // Verificar si el usuario alcanzó el limite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);
                        
                    } else {
                        System.out.println(
                            MessageFormat.format(
                                "{0}Error: El usuario ingresado no corresponde a un nombre de usuario.\nMensaje de error: {1}{2}\n",
                                ANSI_RED, e.getMessage(), ANSI_RESET
                        ));
                        countErr++;
                        continue;
                    }  // Fin if-else
                    
                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                            "{0}Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador.\nMensaje de error: {1}{2}",
                            ANSI_RED, ex.getMessage(), ANSI_RESET
                        ));
                    return false;
                    
                }  //Fin bloque catch secundario
                
            } catch(java.util.InputMismatchException exIn) {
                System.out.println(
                    MessageFormat.format(
                        "Error al ingresar la información requerida.\nMensaje de error: {0}",
                        exIn.getMessage()
                ));
                continue;
                
            }  //Fin bloque catch principal
        }  //Fin ciclo While
    }  //Fin de la función "checkStateUsername"
    
    
    // Checkear el estado de la operación de validación del stateEmail
    public static boolean checkStateEmail(ClienteController clienteController) {
        // Declarando las variables necesarias
        int countErr = 0;
        Scanner sc = new Scanner(System.in);
        
        
        // Bucle infinito hasta que la validación sea correcta o termine por intentos fallidos
        while(true) {
            try {
                System.out.print("\nCorreo Electrónico: ");
                String email = sc.nextLine();
                ValidarEmail validarEmail = new ValidarEmail(email, 1);
                
                
                // Verificar si la operación fue exitosa
                if(validarEmail.getStateEmail()) {
                    // Agregar la información al ArrayList<>()
                    clienteController.setLstInfoUser(email);
                    return true;
                    
                } else {
                    throw new ErrInfoWrongSignUp(email, "Dirección de email. Ej: davmateo@gmail.com");
                    
                }  //Fin if-else
                
            } catch(ErrInfoWrongSignUp e) {
                // Verificar si el usuario alcanzó el limite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);
                        
                    } else {
                        System.out.println(
                            MessageFormat.format("{0}Error: El usuario ingresado no corresponde a una dirección de correo electrónico.\nMensaje de error: {1}{2}",
                            ANSI_RED, e.getMessage(), ANSI_RESET
                        ));
                        countErr++;
                        continue;
                    }  // Fin if-else
                    
                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                                "{0}Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador\nMensaje de error: {1}{2}",
                                ANSI_RED, ex.getMessage(), ANSI_RESET
                    ));
                    return false;
                    
                }  //Fin bloque catch secundario
                
            }  catch(java.util.InputMismatchException exIn) {
                System.out.println(
                    MessageFormat.format(
                        "Error al ingresar la información requerida.\nMensaje de error: {0}",
                        exIn.getMessage()
                ));
                continue;
                
            }  //Fin bloque catch principal
        }  //Fin ciclo While    
    }  //Fin de la función "checkStateEmail"
    
    
    // Checkear el estado de la operación de validación del password
    public static boolean checkStatePassword(ClienteController clienteController) {
        // Declarando las variables necesarias
        int countErr = 0;
        Scanner sc = new Scanner(System.in);
        ValidarPassword validarPassword;
        
        
        // Bucle infinito hasta que la validación sea correcta o termine por intentos fallidos
        while(true) {
            try {
                System.out.print("\nContraseña: ");
                String password = sc.nextLine();
                validarPassword = new ValidarPassword(password, 2);
                
                
                // Verificar si la operación fue exitosa
                if(validarPassword.getStatePassword()) {
                    // Agregar la información al ArrayList<>()
                    clienteController.setLstInfoUser(password);
                    return true;
                    
                } else {
                    throw new ErrInfoWrongSignUp(password, "\nContraseña. Debe contener por lo menos: 8 dígitos, 1 caracter especial, 1 número, letras mayúsculas y letras minúsculas");
                }  //Fin if-else
                
            } catch(ErrInfoWrongSignUp e) {
                // Verificar si el usuario alcanzó el limite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);
                        
                    } else {
                        System.out.println(
                            MessageFormat.format("{0}Error: La contraseña ingresada no cumple con los requerimientos.\nMensaje de error: {1}{2}",
                            ANSI_RED, e.getMessage(), ANSI_RESET
                        ));
                        countErr++;
                        continue;
                    }  // Fin if-else
                    
                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                                "{0}Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador\nMensaje de error: {1}{2}",
                                ANSI_RED, ex.getMessage(), ANSI_RESET
                    ));
                    return false;
                    
                }  //Fin bloque catch secundario
                
            } catch(java.util.InputMismatchException exIn) {
                System.out.println(
                    MessageFormat.format(
                        "Error al ingresar la información requerida.\nMensaje de error: {0}",
                        exIn.getMessage()
                ));
                continue;
                
            }  //Fin bloque catch principal
        }  //Fin ciclo While 
        
    }  //Fin de la función "checkStatePassword"
    
    
    // Checkear el estado de la operación de validación del teléfono
    public static boolean checkStateTel(ClienteController clienteController) {
        // Declarando las variables necesarias
        int countErr = 0;
        Scanner sc = new Scanner(System.in);
        ValidarTelefono validarTelefono;
        
        
        // Bucle infinito hasta que la validación sea correcta o termine por intentos fallidos
        while(true) {
            try {
                System.out.print("\nNúmero Telefónico: ");
                long telefono = sc.nextLong();
                sc.nextLine();  //Limpiando buffer
                validarTelefono = new ValidarTelefono((int)(long)telefono, 3);
                
                
                // Verificar si la operación fue exitosa
                if(validarTelefono.getStateTelefono()) {
                    // Agregar la información al ArrayList<>()
                    clienteController.setLstInfoUser(telefono);
                    return true;
                    
                } else {
                    throw new ErrInfoWrongSignUp(telefono, "Número telefónico. Debe contener únicamente números.");
                }  //Fin if-else
                
            } catch(ErrInfoWrongSignUp e) {
                // Verificar si el usuario alcanzó el limite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);
                        
                    } else {
                        System.out.println(
                            MessageFormat.format("{0}Error: El número de teléfono ingresado es erróneo.\nMensaje de error: {1}{2}",
                            ANSI_RED, e.getMessage(), ANSI_RESET
                        ));
                        countErr++;
                        continue;
                    }  // Fin if-else
                    
                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                                "{0}Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador\nMensaje de error: {1}{2}",
                                ANSI_RED, ex.getMessage(), ANSI_RESET
                    ));
                    return false;
                    
                }  //Fin bloque catch secundario
                
            } catch(java.util.InputMismatchException exIn) {
                System.out.println(
                    MessageFormat.format(
                        "Error al ingresar la información requerida.\nMensaje de error: {0}",
                        exIn.getMessage()
                ));
                continue;
                
            }  //Fin bloque catch principal
        }  //Fin ciclo While
    }  //Fin de la función "checkStateTel"
    
    
    // Checkear el estado de la operación de validación del código de teléfono
    public static boolean checkStateCodTel(ClienteController clienteController) {
        // Declarando las variables necesarias
        int countErr = 0;
        Scanner sc = new Scanner(System.in);
        ValidarTelefono validarTelefono;
        
        
        // Bucle infinito hasta que la validación sea correcta o termine por intentos fallidos
        while(true) {
            try {
                System.out.print("\nCódigo de Teléfono: ");
                String codtelefono = sc.nextLine();
                validarTelefono = new ValidarTelefono(codtelefono, 4);
                
                
                // Verificar si la operación fue exitosa
                if(validarTelefono.getStateCodTel()) {
                    // Agregar la información al ArrayList<>()
                    clienteController.setLstInfoUser(codtelefono);
                    return true;
                    
                } else {
                    throw new ErrInfoWrongSignUp(codtelefono, "Código telefónico. Debe tener el indicativo según el país. Ej: +57");
                }  //Fin if-else
                
            } catch(ErrInfoWrongSignUp e) {
                // Verificar si el usuario alcanzó el limite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);
                        
                    } else {
                        System.out.println(
                            MessageFormat.format("{0}Error: El código telefónico no existe.\nMensaje de error: {1}{2}",
                            ANSI_RED, e.getMessage(), ANSI_RESET
                        ));
                        countErr++;
                        continue;
                    }  // Fin if-else
                    
                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                                "{0}Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador\nMensaje de error: {1}{2}",
                                ANSI_RED, ex.getMessage(), ANSI_RESET
                    ));
                    return false;
                    
                }  //Fin bloque catch secundario
                
            } catch(java.util.InputMismatchException exIn) {
                System.out.println(
                    MessageFormat.format(
                        "Error al ingresar la información requerida.\nMensaje de error: {0}",
                        exIn.getMessage()
                ));
                continue;
                
            }  //Fin bloque catch principal
        }  //Fin ciclo While
    }  //Fin de la función "checkStateCodTel"
    
    
    // Checkear el estado de la operación de validación del código de rolUSer
    public static boolean checkStateRolUser(ClienteController clienteController) {
        // Declarando las variables necesarias
        int countErr = 0;
        Scanner sc = new Scanner(System.in);
        ValidarRol validarRol = new ValidarRol();
        
        
        // Bucle infinito hasta que la validación sea correcta o termine por intentos fallidos
        while(true) {
            try {
                System.out.print("\nRol usuario: ");
                String rol = sc.nextLine();
                validarRol = new ValidarRol(rol, 5);
                
                
                // Verificar si la operación fue exitosa
                if(validarRol.getStateRol()) {
                    // Agregar la información al ArrayList<>()
                    clienteController.setLstInfoUser(rol);
                    return true;
                    
                } else {
                    throw new ErrInfoWrongSignUp(rol, "Cadena de texto. Elige un tipo de rol válido");
                }  //Fin if-else
                
            } catch(ErrInfoWrongSignUp e) {
                // Verificar si el usuario alcanzó el limite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);
                        
                    } else {
                        System.out.println(
                            MessageFormat.format("El rol de usuario no está registrado.\nMensaje de error: {1}{2}",
                            ANSI_RED, e.getMessage(), ANSI_RESET
                        ));
                        countErr++;
                        continue;
                    }  // Fin if-else
                    
                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                                "{0}Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador\nMensaje de error: {1}{2}",
                                ANSI_RED, ex.getMessage(), ANSI_RESET
                    ));
                    return false;
                    
                }  //Fin bloque catch secundario
            }  //Fin bloque catch principal
        }  //Fin ciclo While
    }  //Fin de la función "checkStateRolUser"
    
    
    public static boolean checkStateNumId(ClienteController clienteController) {
        // Declarando las variables necesarias
        int countErr = 0;
        Scanner sc = new Scanner(System.in);
        ValidarDocumentoIdentidad validarDocumentoIdentidad = new ValidarDocumentoIdentidad();
        
        
        // Bucle infinito hasta que la validación sea correcta o termine por intentos fallidos
        while(true) {
            try {
                System.out.print("\nNúmero de documento de identidad: ");
                Long numId = sc.nextLong();
                sc.nextLine();
                validarDocumentoIdentidad = new ValidarDocumentoIdentidad(numId, 6);
                
                
                // Verificar si la operación fue exitosa
                if(validarDocumentoIdentidad.getStateIdNum()) {
                    // Agregar la información al ArrayList<>()
                    clienteController.setLstInfoUser(numId);
                    return true;
                    
                } else {
                    throw new ErrInfoWrongSignUp(numId, "Número. Digita el número de identificación. EJ: 1234567890");
                }  //Fin if-else
                
            } catch(ErrInfoWrongSignUp e) {
                // Verificar si el usuario alcanzó el limite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);
                        
                    } else {
                        System.out.println(
                            MessageFormat.format("El número de documento parece ser incorrecto.\nMensaje de error: {1}{2}",
                            ANSI_RED, e.getMessage(), ANSI_RESET
                        ));
                        countErr++;
                        continue;
                    }  // Fin if-else
                    
                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                                "{0}Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador\nMensaje de error: {1}{2}",
                                ANSI_RED, ex.getMessage(), ANSI_RESET
                    ));
                    return false;
                    
                }  //Fin bloque catch secundario
            }  //Fin bloque catch principal
        }  //Fin ciclo While
    }  //Fin de la función "checkStateNumId"
    
    
    public static boolean checkStateTypeId(ClienteController clienteController) {
        // Declarando las variables necesarias
        int countErr = 0;
        Scanner sc = new Scanner(System.in);
        ValidarDocumentoIdentidad validarDocumentoIdentidad = new ValidarDocumentoIdentidad();
        
        
        // Bucle infinito hasta que la validación sea correcta o termine por intentos fallidos
        while(true) {
            try {
                System.out.print("\nTipo de documento de identidad: ");
                String typeId = sc.nextLine();
                validarDocumentoIdentidad = new ValidarDocumentoIdentidad(typeId, 7);
                
                
                // Verificar si la operación fue exitosa
                if(validarDocumentoIdentidad.getStateIdtype()) {
                    // Agregar la información al ArrayList<>()
                    clienteController.setLstInfoUser(typeId);
                    return true;
                    
                } else {
                    throw new ErrInfoWrongSignUp(typeId, "Texto. Ingrese una opción válida. EJ: Cédula Ciudadanía");
                }  //Fin if-else
                
            } catch(ErrInfoWrongSignUp e) {
                // Verificar si el usuario alcanzó el limite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);
                        
                    } else {
                        System.out.println(
                            MessageFormat.format("Digite un tipo de documento válido.\nMensaje de error: {1}{2}",
                            ANSI_RED, e.getMessage(), ANSI_RESET
                        ));
                        countErr++;
                        continue;
                    }  // Fin if-else
                    
                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                                "{0}Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador\nMensaje de error: {1}{2}",
                                ANSI_RED, ex.getMessage(), ANSI_RESET
                    ));
                    return false;
                    
                }  //Fin bloque catch secundario
            }  //Fin bloque catch principal
        }  //Fin ciclo While
    }  //Fin de la función "checkStateTypeId"
    
    
    public static boolean checkStateTgs(ClienteController clienteController) {
        // Declarando las variables necesarias
        int countErr = 0;
        Scanner sc = new Scanner(System.in);
        ValidarDocumentoIdentidad validarDocumentoIdentidad = new ValidarDocumentoIdentidad();
        
        
        // Bucle infinito hasta que la validación sea correcta o termine por intentos fallidos
        while(true) {
            try {
                System.out.print("\nTipo de grupo sanguíneo: ");
                String tgs = sc.nextLine();
                validarDocumentoIdentidad = new ValidarDocumentoIdentidad(tgs, 8, 0);
                
                
                // Verificar si la operación fue exitosa
                if(validarDocumentoIdentidad.getStateIdTgs()) {
                    // Agregar la información al ArrayList<>()
                    clienteController.setLstInfoUser(tgs);
                    return true;
                    
                } else {
                    throw new ErrInfoWrongSignUp(tgs, "Texto. Ingrese una opción válida. EJ: A+");
                }  //Fin if-else
                
            } catch(ErrInfoWrongSignUp e) {
                // Verificar si el usuario alcanzó el limite de errores, para romper el bucle while
                try {
                    if(countErr == 5) {
                        throw new ErrCountIntentos(countErr, 5);
                        
                    } else {
                        System.out.println(
                            MessageFormat.format("El grupo sanguíneo ingresado no existe.\nMensaje de error: {1}{2}",
                            ANSI_RED, e.getMessage(), ANSI_RESET
                        ));
                        countErr++;
                        continue;
                    }  // Fin if-else
                    
                } catch(ErrCountIntentos ex) {
                    System.out.println(
                        MessageFormat.format(
                                "{0}Error: Ha ocurrido un error inesperado. Inténtelo de nuevo más tarde o comuníquese con un administrador\nMensaje de error: {1}{2}",
                                ANSI_RED, ex.getMessage(), ANSI_RESET
                    ));
                    return false;
                    
                }  //Fin bloque catch secundario
            }  //Fin bloque catch principal
        }  //Fin ciclo While
    }  //Fin de la función "checkStateTgs"    
}  //Fin del programa