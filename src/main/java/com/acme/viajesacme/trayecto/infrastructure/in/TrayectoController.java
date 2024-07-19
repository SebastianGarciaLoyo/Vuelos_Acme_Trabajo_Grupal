/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.trayecto.infrastructure.in;

import java.util.Scanner;

import com.acme.viajesacme.trayecto.application.CreateTrayectoUseCase;
import com.acme.viajesacme.trayecto.domain.entity.Trayecto;

/**
 *
 * @author camper
 */
public class TrayectoController {
    private CreateTrayectoUseCase createTrayectoUseCase;

    public TrayectoController(CreateTrayectoUseCase createTrayectoUseCase) {
        this.createTrayectoUseCase = createTrayectoUseCase;
    }

    public void menuTrayecto() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + //
                                "___  ___                   _____                         _        \n" + //
                                "|  \\/  |                  |_   _|                       | |       \n" + //
                                "| .  . | ___ _ __  _   _    | |_ __ __ _ _   _  ___  ___| |_ ___  \n" + //
                                "| |\\/| |/ _ \\ '_ \\| | | |   | | '__/ _` | | | |/ _ \\/ __| __/ _ \\ \n" + //
                                "| |  | |  __/ | | | |_| |   | | | | (_| | |_| |  __/ (__| || (_) |\n" + //
                                "\\_|  |_/\\___|_| |_|\\__,_|   \\_/_|  \\__,_|\\__, |\\___|\\___|\\__\\___/ \n" + //
                                "                                          __/ |                   \n" + //
                                "                                         |___/                    \n" + //
                                "");
            System.out.println("=================================");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registro Trayecto");
            System.out.println("2. Actualizar Trayecto (MANTENIMIENTO)");
            System.out.println("3. Eliminar Trayecto (MANTENIMIENTO)");
            System.out.println("4. Consultar Trayecto (MANTENIMIENTO)");
            System.out.println("5. Listar Trayectos (MANTENIMIENTO)");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    
                    System.out.println("Descripcion del Trayecto: ");
                    String descripcion = scanner.nextLine();

                    System.out.println("Valor del Trayecto: ");
                    int valor = Integer.parseInt(scanner.nextLine());

                    Trayecto trayecto = new Trayecto();
                    trayecto.setDescripcion(descripcion);
                    trayecto.setValor(valor);

                    createTrayectoUseCase.execute(trayecto);

                    System.out.println("Trayecto registrado exitosamente!");

                    break;

                case 6:
                    System.out.println("Volviendo al menu Principal...");
                    return;
            
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
