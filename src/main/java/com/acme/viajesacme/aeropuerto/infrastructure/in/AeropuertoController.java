package com.acme.viajesacme.aeropuerto.infrastructure.in;

import java.util.Scanner;

import com.acme.viajesacme.aeropuerto.application.CreateAeropuertoUseCase;
import com.acme.viajesacme.aeropuerto.domain.entity.Aeropuerto;

public class AeropuertoController {
    private CreateAeropuertoUseCase createAeropuertoUseCase;

    public AeropuertoController(CreateAeropuertoUseCase createAeropuertoUseCase) {
        this.createAeropuertoUseCase = createAeropuertoUseCase;
    }

    public void menuAeropuerto() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + //
                                "___  ___                    ___                                       _        \n" + //
                                "|  \\/  |                   / _ \\                                     | |       \n" + //
                                "| .  . | ___ _ __  _   _  / /_\\ \\ ___ _ __ ___  _ __  _   _  ___ _ __| |_ ___  \n" + //
                                "| |\\/| |/ _ \\ '_ \\| | | | |  _  |/ _ \\ '__/ _ \\| '_ \\| | | |/ _ \\ '__| __/ _ \\ \n" + //
                                "| |  | |  __/ | | | |_| | | | | |  __/ | | (_) | |_) | |_| |  __/ |  | || (_) |\n" + //
                                "\\_|  |_/\\___|_| |_|\\__,_| \\_| |_/\\___|_|  \\___/| .__/ \\__,_|\\___|_|   \\__\\___/ \n" + //
                                "                                               | |                             \n" + //
                                "                                               |_|                             \n" + //
                                "");
            System.out.println("=================================");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registro Aeropuerto");
            System.out.println("2. Actualizar Aeropuerto (MANTENIMIENTO)");
            System.out.println("3. Eliminar Aeropuerto (MANTENIMIENTO)");
            System.out.println("4. Consultar Aeropuerto (MANTENIMIENTO)");
            System.out.println("5. Listar Aeropuerto (MANTENIMIENTO)");
            System.out.println("6. Volver al menu principal");
            System.out.println("=================================");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:

                    System.out.println("Id del Aeropuerto: ");
                    String id_aeropuerto = scanner.nextLine();

                    System.out.println("Nombre del Aeropuerto: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Nombre de la ciudad: ");
                    String ciudad = scanner.nextLine();

                    System.out.println("Nombre del pais: ");
                    String pais = scanner.nextLine();

                    Aeropuerto aeropuerto = new Aeropuerto();
                    aeropuerto.setId_aeropuerto(id_aeropuerto);
                    aeropuerto.setNombre(nombre);
                    aeropuerto.setCiudad(ciudad);
                    aeropuerto.setPais(pais);

                    createAeropuertoUseCase.execute(aeropuerto);

                    System.out.println("Aeropuerto registrado exitosamente!");
                    
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
