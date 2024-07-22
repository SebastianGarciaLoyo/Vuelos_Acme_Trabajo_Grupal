package com.acme.viajesacme.avion.infrastructure.in;

import com.acme.viajesacme.avion.application.CreateAvionUseCase;
import com.acme.viajesacme.avion.domain.entity.Avion;


import java.util.Scanner;

public class AvionController {

    private CreateAvionUseCase createAvionUseCase;

    public AvionController(CreateAvionUseCase createAvionUseCase) {
        this.createAvionUseCase = createAvionUseCase;
    }

    public void menuAvion() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + //
                                "___  ___                    ___        _             \n" + //
                                "|  \\/  |                   / _ \\      (_)            \n" + //
                                "| .  . | ___ _ __  _   _  / /_\\ \\_   ___  ___  _ __  \n" + //
                                "| |\\/| |/ _ \\ '_ \\| | | | |  _  \\ \\ / / |/ _ \\| '_ \\ \n" + //
                                "| |  | |  __/ | | | |_| | | | | |\\ V /| | (_) | | | |\n" + //
                                "\\_|  |_/\\___|_| |_|\\__,_| \\_| |_/ \\_/ |_|\\___/|_| |_|\n" + //
                                "                                                     \n" + //
                                "                                                     \n" + //
                                "");
            System.out.println("==============================");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registro de Avion");
            System.out.println("2. Actualizar Avion (MANTENIMIENTO)");
            System.out.println("3. Eliminar Avion (MANTENIMIENTO)");
            System.out.println("4. Consultar Avion (MANTENIMIENTO)");
            System.out.println("5. Listar Aviones (MANTENIMIENTO)");
            System.out.println("6. Volver al menu principal");
            System.out.println("==============================");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Placa del avion: ");
                    int placa = Integer.parseInt(scanner.nextLine());
                    scanner.nextLine();
            
                    System.out.print("Capacidad del avion: ");
                    int capacidad = Integer.parseInt(scanner.nextLine());
            
                    System.out.println("Fecha de fabricacion del avion: ");
                    String fecha_fabricacion = scanner.nextLine();
            
                    System.out.print("Id del estado del avion: ");
                    int estado_id = Integer.parseInt(scanner.nextLine());
                    scanner.nextLine();
            
                    System.out.print("Id del modelo del avion ");
                    int modelo_id = Integer.parseInt(scanner.nextLine());
                    scanner.nextLine();


                    // Crear objeto Avion
                    Avion avion = new Avion();
                    avion.setPlaca(placa);
                    avion.setCapacidad(capacidad);
                    avion.setFecha_fabricacion(fecha_fabricacion);
                    avion.setModelo_id(modelo_id);
                    avion.setEstado_id(estado_id);
                    // Ejecutar caso de uso para crear avion
                    createAvionUseCase.execute(avion);
            
                    System.out.println("Avion registrado exitosamente!");

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