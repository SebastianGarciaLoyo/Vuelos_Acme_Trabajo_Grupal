package com.acme.viajesacme;

import com.acme.viajesacme.persona.infrastructure.in.signUpModules.ClienteController;
import com.acme.viajesacme.persona.infrastructure.in.loginModules.LoginController;

import com.acme.viajesacme.vuelo.application.CreateVueloUseCase;
import com.acme.viajesacme.vuelo.domain.service.VueloService;
import com.acme.viajesacme.vuelo.infrastructure.in.VueloController;
import com.acme.viajesacme.vuelo.infrastructure.out.VueloRepository;
import java.util.Scanner;

public class ViajesAcme {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginController loginController = new LoginController(0);
        MenuCaracteristicasOp menuCaracteristicasOpLogin = new MenuCaracteristicasOp();

        while (true) {
            System.out.println("\n" + //
                                " _   _ _       _              ___                      \n" + //
                                "| | | (_)     (_)            / _ \\                     \n" + //
                                "| | | |_  __ _ _  ___  ___  / /_\\ \\ ___ _ __ ___   ___ \n" + //
                                "| | | | |/ _` | |/ _ \\/ __| |  _  |/ __| '_ ` _ \\ / _ \\\n" + //
                                "\\ \\_/ / | (_| | |  __/\\__ \\ | | | | (__| | | | | |  __/\n" + //
                                " \\___/|_|\\__,_| |\\___||___/ \\_| |_/\\___|_| |_| |_|\\___|\n" + //
                                "             _/ |                                      \n" + //
                                "            |__/                                       \n" + //
                                "");
            System.out.println("===================================");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrar cuenta");
            System.out.println("3. Salir");
            System.out.println("===================================");
            System.out.print("Opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    String rolUserLogin = loginController.initLogin();
                    
                    
                    // Redirigir a los menús
                    System.out.println("Redirigiéndolo a la selección de menús...");
                    
                    menuCaracteristicasOpLogin.elegirMenu(rolUserLogin);
                    break;

                case 2:
                    ClienteController clienteController = new ClienteController();
                    clienteController.registrarUser();
                    
                    if(clienteController.getCheckEstadoSignUp()) {
                        System.out.println("Redirigiéndolo a la selección de menús...");
                        
                        // Obteniendo el rol del usuario
                        String rolUser = (String) clienteController.getLstInfoUser().get(5);
                        
                        // Llamando a la función de elección de menús
                        MenuCaracteristicasOp menuCaracteristicasOp = new MenuCaracteristicasOp();
                        menuCaracteristicasOp.elegirMenu(rolUser);
                        
                    } else {
                        System.out.println("La información no pudo validarse correctamente.");
                        System.out.println("Saliendo...");
                        break;
                    }

                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }  //Fin condicional switch-case
        }  //Fin ciclo while
    }  //Fin funcion main
}  //Fin clase ViajesAcme