package com.acme.viajesacme.avion.infrastructure.in;

import com.acme.viajesacme.avion.application.ExistePlacasExtraccion;
import com.acme.viajesacme.avion.application.ExtraerRegistroAccion;
import com.acme.viajesacme.avion.application.RecordAvionAccion;
import com.acme.viajesacme.avion.application.VerEstadoInfoAccion;
import com.acme.viajesacme.avion.application.VerModeloInfoAccion;
import com.acme.viajesacme.avion.domain.entity.Avion;
import com.acme.viajesacme.avion.application.verifiers.CheckDate;
import com.acme.viajesacme.avion.application.verifiers.CheckString;
import com.acme.viajesacme.avion.application.verifiers.CheckInt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AvionController {

    private ExistePlacasExtraccion existePlacasExtraccion;
    private VerModeloInfoAccion verModeloInfoAccion;
    private ExtraerRegistroAccion extractRegisterModelsAction;
    private VerEstadoInfoAccion verEstadoInfoAccion;
    private ExtraerRegistroAccion extractRegisterStatusAction;
    private RecordAvionAccion recordAvionAccion;

    public AvionController(
                           ExistePlacasExtraccion existePlacasExtraccion,
                           VerModeloInfoAccion verModeloInfoAccion,
                           ExtraerRegistroAccion extractRegisterModelsAction,
                           VerEstadoInfoAccion verEstadoInfoAccion,
                           ExtraerRegistroAccion extractRegisterStatusAction,
                           RecordAvionAccion recordAvionAccion) {
        this.existePlacasExtraccion = existePlacasExtraccion;
        this.verModeloInfoAccion = verModeloInfoAccion;
        this.extractRegisterModelsAction = extractRegisterModelsAction;
        this.verEstadoInfoAccion = verEstadoInfoAccion;
        this.extractRegisterStatusAction = extractRegisterStatusAction;
        this.recordAvionAccion = recordAvionAccion;
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

            int opcion = CheckInt.check(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarAvion(scanner);
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal...");
                    scanner.close(); // Cerrar el escáner cuando se sale del menú
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private void registrarAvion(Scanner scanner) {
        List<String> listRegisteredPlates = this.existePlacasExtraccion.executeExtract();
        ResultSet infoModels = this.extractRegisterModelsAction.extraerInfo();
        ResultSet infoStatus = this.extractRegisterStatusAction.extraerInfo();
        
        boolean checkPlaca = false;
        String placa = "";
        
        // Registro de la placa
        while (!checkPlaca) {
            System.out.println("======================");
            System.out.print("Placa del avion: ");
            System.out.println("\n======================");
            System.out.println("\nEscriba EXIT o exit para cancelar el registro");
            try {
                placa = CheckString.check(scanner.nextLine());
                if (placa.equalsIgnoreCase("exit")) {
                    System.out.println("Registro cancelado");
                    return;
                }
    
                if (listRegisteredPlates.contains(placa)) {
                    System.out.println("Esta placa ya se encuentra registrada.");
                } else {
                    checkPlaca = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    
        // Registro de la capacidad
        int capacidad = 0;
        boolean checkCapacidad = false;
        while (!checkCapacidad) {
            System.out.println("======================");
            System.out.print("Capacidad del avion: ");
            System.out.println("\n======================");
            System.out.println("\nEscriba -1 para cancelar el registro");
            try {
                capacidad = CheckInt.check(scanner.nextLine());
                if (capacidad == -1) {
                    System.out.println("Registro cancelado");
                    return;
                } else if (capacidad > 0) {
                    checkCapacidad = true;
                } else {
                    System.out.println("La capacidad no puede ser negativa o cero.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    
        // Registro de la fecha de fabricación
        String fechaFabricacion = "";
        boolean checkFechaFabricacion = false;
        while (!checkFechaFabricacion) {
            System.out.println("=================================");
            System.out.print("Fecha de fabricacion (AAAA-MM-DD): ");
            System.out.println("\n=================================");
            System.out.println("\nEscriba EXIT o exit para cancelar el registro");
            try {
                fechaFabricacion = CheckDate.check(scanner.nextLine());
                if (fechaFabricacion.equalsIgnoreCase("exit")) {
                    System.out.println("Registro cancelado");
                    return;
                } else {
                    checkFechaFabricacion = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    
        // Registro del estado
        int estado_id = 0;
        boolean checkEstado = false;
        List<Integer> listCodesStatus = this.verEstadoInfoAccion.executeView(infoStatus);
        while (!checkEstado) {
            System.out.println("==================");
            System.out.print("Estado del avion: ");
            System.out.println("\n==================");
            System.out.println("\n(Presione -1 para cancelar el registro)");            
            try {
                estado_id = CheckInt.check(scanner.nextLine());
                if (estado_id == -1) {
                    System.out.println("Registro cancelado");
                    return;
                } else {
                    checkEstado = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    
        // Registro del modelo
        int modelo_id = 0;
        boolean checkModelo = false;
        List<Integer> listCodesModels = this.verModeloInfoAccion.executeView(infoModels);
        while (!checkModelo) {
            System.out.println("==================");
            System.out.print("Modelo del avion: ");
            System.out.println("\n==================");
            System.out.println("Escriba -1 para cancelar el registro");
            try {
                modelo_id = CheckInt.check(scanner.nextLine());
                if (modelo_id == -1) {
                    System.out.println("Registro cancelado");
                    return;
                } else {
                    checkModelo = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    
        if (checkModelo && checkEstado) {
            Avion newAvion = new Avion(placa, capacidad, fechaFabricacion, modelo_id, estado_id);
            int insertedRows = this.recordAvionAccion.excuteRecord(newAvion);
    
            if (insertedRows > 0) {
                System.out.println("Avión registrado exitosamente!");
            } else {
                System.out.println("Error al registrar el avión.");
            }
        }
    }
}    