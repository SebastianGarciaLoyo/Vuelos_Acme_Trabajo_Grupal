/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.domain.exceptions;

// Importando las clases y paquetes necesarios
import java.text.MessageFormat;


/**
 *
 * @author mateo
 */
public class ErrCountIntentos extends Exception {
    // Creando el constructor
    public ErrCountIntentos(int intentosUser, int intentosMax) {
        super(
            MessageFormat.format(
                "Has alcanzado el límite de errores por sección: Tienes {0} intentos de {1}",
                intentosUser, intentosMax
            )
        );
    }
}




/*
// Recogiendo el número de teléfono
System.out.print("Número tel: ");
String numTel = scanner.nextLine();


// Recogiendo el código de país para el número de teléfono
String[] codTel = { "+57", "+63", "+52", "+1" };
System.out.println("Seleccione el código de país: ");
for (int i = 0; i < codTel.length; i++) {
    System.out.println((i + 1) + ". " + codTel[i]);
}
int codNumIndex = scanner.nextInt() - 1;
scanner.nextLine(); // Consumir el newline
String codNumTel = codTel[codNumIndex];


// Recogiendo el rol de usuario
String[] roles = { "Administrador", "Empleado", "Cliente", "Tripulación" };
System.out.println("Seleccione el rol de usuario: ");
for (int i = 0; i < roles.length; i++) {
    System.out.println((i + 1) + ". " + roles[i]);
}
int roleIndex = scanner.nextInt() - 1;
scanner.nextLine(); // Consumir el newline
String role = roles[roleIndex];


// Recogiendo el número de documento
System.out.print("Número documento: ");
String numId = scanner.nextLine();


// Recogiendo el tipo de documento
String[] opcionesId = { "Tarjeta Identidad", "Cédula Ciudadanía", "Pasaporte" };
System.out.println("Seleccione el tipo de documento: ");
for (int i = 0; i < opcionesId.length; i++) {
    System.out.println((i + 1) + ". " + opcionesId[i]);
}
int tipoIdIndex = scanner.nextInt() - 1;
scanner.nextLine(); // Consumir el newline
String opTipoId = opcionesId[tipoIdIndex];


// Recogiendo el tipo de grupo sanguíneo
String[] opcionesTgs = { "A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-" };
System.out.println("Seleccione el tipo de grupo sanguíneo: ");
for (int i = 0; i < opcionesTgs.length; i++) {
    System.out.println((i + 1) + ". " + opcionesTgs[i]);
}
int tipoGsIndex = scanner.nextInt() - 1;
scanner.nextLine(); // Consumir el newline
String opTipoGs = opcionesTgs[tipoGsIndex];

// Cerrar el scanner
scanner.close();
*/







/*
// Checkear el estado de la operación de validación del username
    public static boolean checkStateUsername() {
        // Declarando las variables necesarias
        int countErr = 0;
        
        
        // Definiendo las instancias necesarias
        Scanner sc = new Scanner(System.in);
        ClienteController clienteController = new ClienteController();
        ValidarUsername validarUsername;
        
        
        // Bucle infinito hasta que la validación sea correcta o termine por intentos fallidos
        while(true) {
            try {
                System.out.print("Nombre de usuario: ");
                String user = sc.nextLine();
                validarUsername = new ValidarUsername(user, 0);
                
                
                // Verificar si la operación fue exitosa
                if(validarUsername.getStateUsername()) {
                    // Agregar la información al ArrayList<>()
                    clienteController.setLstInfoUser(validarUsername.getUsername());
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
                                "{0}Error: El usuario ingresado no corresponde a un nombre de usuario.\nMensaje de error: {1}{2}",
                                ANSI_RED, e.getMessage(), ANSI_RESET
                        ));
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
            }  //Fin bloque catch principal
        }  //Fin ciclo While
    }  //Fin de la función "checkStateUsername"
*/