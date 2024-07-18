package com.acme.viajesacme.avion.infrastructure.in;

import com.acme.viajesacme.avion.application.CreateAvionUseCase;
import com.acme.viajesacme.avion.domain.entity.Avion;
import com.acme.viajesacme.avion.domain.entity.Estado;
import com.acme.viajesacme.avion.domain.entity.Aerolinea;
import com.acme.viajesacme.avion.domain.entity.Modelo;

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
            System.out.println("1. Registro de Avion");
            System.out.println("2. Salir");
            System.out.println("==============================");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Placa del avion: ");
                    int placa = Integer.parseInt(scanner.nextLine());
            
                    System.out.print("Capacidad del avion: ");
                    int capacidad = Integer.parseInt(scanner.nextLine());
            
                    System.out.print("Año de fabricacion: ");
                    int añoFabricacion = Integer.parseInt(scanner.nextLine());
            
                    System.out.print("Mes de fabricacion: ");
                    int mesFabricacion = Integer.parseInt(scanner.nextLine());
            
                    System.out.print("Dia de fabricacion: ");
                    int diaFabricacion = Integer.parseInt(scanner.nextLine());
            
                    System.out.print("Estado del avion: ");
                    String estadoNombre = scanner.nextLine();
            
                    System.out.print("Aerolinea del avion: ");
                    String aerolineaNombre = scanner.nextLine();
            
                    System.out.print("Modelo del avion: ");
                    String modeloNombre = scanner.nextLine();

                    // Crear objetos Estado, Aerolinea, y Modelo
                    Estado estado = new Estado();
                    estado.setEstado(estadoNombre);
                    
                    Aerolinea aerolinea = new Aerolinea();
                    aerolinea.setAerolinea(aerolineaNombre);
                    
                    Modelo modelo = new Modelo();
                    modelo.setModelo(modeloNombre);

                    // Crear objeto Avion
                    Avion avion = new Avion();
                    avion.setPlaca(placa);
                    avion.setCapacidad(capacidad);
                    avion.setAño_fabricacion(añoFabricacion);
                    avion.setMes_fabricacion(mesFabricacion);
                    avion.setDia_fabricacion(diaFabricacion);
                    avion.setEstado(estado);
                    avion.setAerolinea(aerolinea);
                    avion.setModelo(modelo);
            
                    // Ejecutar caso de uso para crear avion
                    createAvionUseCase.execute(avion);
            
                    System.out.println("Avion registrado exitosamente!");

                    break;
                case 2:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
            
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
