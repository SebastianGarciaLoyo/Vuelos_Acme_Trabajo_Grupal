package com.acme.viajesacme.vuelo.infrastructure.in;

import com.acme.viajesacme.vuelo.application.CreateVueloUseCase;
import com.acme.viajesacme.vuelo.domain.entity.Vuelo;

import java.util.Scanner;

public class VueloController {

    private CreateVueloUseCase createVueloUseCase;

    public VueloController(CreateVueloUseCase createVueloUseCase) {
        this.createVueloUseCase = createVueloUseCase;
    }

    public void menuVuelo() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + //
                                "___  ___                   _   _            _           \n" + //
                                "|  \\/  |                  | | | |          | |          \n" + //
                                "| .  . | ___ _ __  _   _  | | | |_   _  ___| | ___  ___ \n" + //
                                "| |\\/| |/ _ \\ '_ \\| | | | | | | | | | |/ _ \\ |/ _ \\/ __|\n" + //
                                "| |  | |  __/ | | | |_| | \\ \\_/ / |_| |  __/ | (_) \\__ \\\n" + //
                                "\\_|  |_/\\___|_| |_|\\__,_|  \\___/ \\__,_|\\___|_|\\___/|___/\n" + //
                                "                                                        \n" + //
                                "                                                        \n" + //
                                "");
            System.out.println("==============================");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registro de Vuelos");
            System.out.println("2. Actualizar Vuelos (MANTENIMIENTO)");
            System.out.println("3. Eliminar Vuelos (MANTENIMIENTO)");
            System.out.println("4. Consultar Vuelo (MANTENIMIENTO)");
            System.out.println("5. Listar Vuelos (MANTENIMIENTO)");
            System.out.println("6. Volver al menu principal");
            System.out.println("==============================");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:

                    System.out.print("Código del vuelo: ");
                    int id_vuelo = scanner.nextInt();
                    scanner.nextLine();
            
                    System.out.print("Nombre del cliente: ");
                    String cliente = scanner.nextLine();
            
                    System.out.print("Trayecto del vuelo: ");
                    String trayecto = scanner.nextLine();
            
                    System.out.print("Año del vuelo: ");
                    int año = scanner.nextInt();
                    scanner.nextLine();
            
                    System.out.println("Mes del vuelo: ");
                    int mes = scanner.nextInt();
                    scanner.nextLine();
            
                    System.out.println("Dia del vuelo: ");
                    int dia = scanner.nextInt();
                    scanner.nextLine();
            
                    System.out.println("Tarifa del vuelo: ");
                    int tarifa = scanner.nextInt();
                    scanner.nextLine();
            
            
                    // Crear objeto Vuelo
                    Vuelo vuelo = new Vuelo();
                    vuelo.setId_vuelo(id_vuelo);
                    vuelo.setCliente(cliente);
                    vuelo.setTrayecto(trayecto);
                    vuelo.setAño(año);
                    vuelo.setMes(mes);
                    vuelo.setDia(dia);
                    vuelo.setTarifa(tarifa);
            
                    // Ejecutar caso de uso para crear vuelo
                    createVueloUseCase.execute(vuelo);
            
                    System.out.println("Vuelo registrado exitosamente!");
            
                    break;
                    
                    case 6:
                        System.out.println("Volviendo al menu principal...");
                    return;
                
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                
                }    

            }
        }
    }

