/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.revision.infrastructure.in;


import java.util.Scanner;
import com.acme.viajesacme.revision.application.CreateRevisionUseCase;
import com.acme.viajesacme.revision.domain.entity.Revision;


/**
 *
 * @author camper
 */
public class RevisionController {
    private CreateRevisionUseCase createRevisionUseCase;

    public RevisionController(CreateRevisionUseCase createRevisionUseCase) {
        this.createRevisionUseCase = createRevisionUseCase;
    }

    public void menuRevision() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + //
                                "___  ___                  ______           _     _             \n" + //
                                "|  \\/  |                  | ___ \\         (_)   (_)            \n" + //
                                "| .  . | ___ _ __  _   _  | |_/ /_____   ___ ___ _  ___  _ __  \n" + //
                                "| |\\/| |/ _ \\ '_ \\| | | | |    // _ \\ \\ / / / __| |/ _ \\| '_ \\ \n" + //
                                "| |  | |  __/ | | | |_| | | |\\ \\  __/\\ V /| \\__ \\ | (_) | | | |\n" + //
                                "\\_|  |_/\\___|_| |_|\\__,_| \\_| \\_\\___| \\_/ |_|___/_|\\___/|_| |_|\n" + //
                                "                                                               \n" + //
                                "                                                               \n" + //
                                "");
            System.out.println("===============================");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registro Revision");
            System.out.println("2. Actualizar Revision (MANTENIMIENTO)");
            System.out.println("3. Eliminar Revision (MANTENIMIENTO)");
            System.out.println("4. Consultar Revision (MANTENIMIENTO)");
            System.out.println("5. Listar Revisiones (MANTENIMIENTO)");
            System.out.println("6. Volver al menu principal");
            System.out.println("===============================");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    
                    System.out.println("Placa del Avion: ");
                    int avion = Integer.parseInt(scanner.nextLine());

                    System.out.println("Año de la revision: ");
                    int ano_revision = Integer.parseInt(scanner.nextLine());

                    System.out.println("Mes de la revision: ");
                    int mes_revision = Integer.parseInt(scanner.nextLine());

                    System.out.println("Dia de la revision: ");
                    int dia_revision = Integer.parseInt(scanner.nextLine());

                    System.out.println("Descripcion de la revision: ");
                    String descripcion = scanner.nextLine();

                    System.out.println("Nombre del empleado que se encargo de la revision: ");
                    String empleado = scanner.nextLine();

                    Revision revision = new Revision();
                    revision.setAvion(avion);
                    revision.setAno_revision(ano_revision);
                    revision.setMes_revision(mes_revision);
                    revision.setDia_revision(dia_revision);
                    revision.setDescripcion(descripcion);
                    revision.setEmpleado(empleado);

                    createRevisionUseCase.execute(revision);

                    System.out.println("Revision registrada exitosamente!");

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
