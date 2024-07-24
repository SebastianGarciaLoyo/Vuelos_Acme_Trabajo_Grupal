package com.acme.viajesacme;

import com.acme.viajesacme.aeropuerto.application.CreateAeropuertoUseCase;
import com.acme.viajesacme.aeropuerto.domain.service.AeropuertoService;
import com.acme.viajesacme.aeropuerto.infrastructure.in.AeropuertoController;
import com.acme.viajesacme.aeropuerto.infrastructure.out.AeropuertoRepository;
import com.acme.viajesacme.avion.application.ExistePlacasExtraccion;
import com.acme.viajesacme.avion.application.ExtraerRegistroAccion;
import com.acme.viajesacme.avion.application.RecordAvionAccion;
import com.acme.viajesacme.avion.application.VerEstadoInfoAccion;
import com.acme.viajesacme.avion.application.VerModeloInfoAccion;
import com.acme.viajesacme.avion.domain.service.AvionRecordService;
import com.acme.viajesacme.avion.domain.service.ExtraerRegistroService;
import com.acme.viajesacme.avion.domain.service.PlacasExtraccionService;
import com.acme.viajesacme.avion.domain.service.VerInfoService;
import com.acme.viajesacme.avion.infrastructure.in.AvionController;
import com.acme.viajesacme.avion.infrastructure.in.ExtraerEstadoAvionRepository;
import com.acme.viajesacme.avion.infrastructure.in.ExtraerModelosAvionRepository;
import com.acme.viajesacme.avion.infrastructure.in.ExtraerPlacasRepository;
import com.acme.viajesacme.avion.infrastructure.in.VerInfoEstadoRepository;
import com.acme.viajesacme.avion.infrastructure.in.VerInfoModeloRepository;
import com.acme.viajesacme.avion.infrastructure.out.AvionRepository;
import com.acme.viajesacme.revision.application.CreateRevisionUseCase;
import com.acme.viajesacme.revision.domain.service.RevisionService;
import com.acme.viajesacme.revision.infrastructure.in.RevisionController;
import com.acme.viajesacme.revision.infrastructure.out.RevisionRepository;
import com.acme.viajesacme.vuelo.application.CreateVueloUseCase;
import com.acme.viajesacme.vuelo.domain.service.VueloService;
import com.acme.viajesacme.vuelo.infrastructure.in.VueloController;
import com.acme.viajesacme.vuelo.infrastructure.out.VueloRepository;
import java.util.Scanner;

public class ViajesAcme {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
            System.out.println("1. Menu Avion");
            System.out.println("2. Menu Vuelo");
            System.out.println("3. Menu Revision");
            System.out.println("4. Menu Aeropuerto");
            System.out.println("5. Salir");
            System.out.println("===================================");
            System.out.print("Opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    PlacasExtraccionService placasExtraccionService = new ExtraerPlacasRepository();
                    ExistePlacasExtraccion existePlacasExtraccion = new ExistePlacasExtraccion(placasExtraccionService);
                    VerInfoService extractInfoModelService = new VerInfoModeloRepository();
                    VerModeloInfoAccion verModeloInfoAccion = new VerModeloInfoAccion(extractInfoModelService);
                    ExtraerRegistroService extractInfoModel = new ExtraerModelosAvionRepository();
                    ExtraerRegistroAccion extractInfoModelAction = new ExtraerRegistroAccion(extractInfoModel);
                    VerInfoService extractInfoStatusService = new VerInfoEstadoRepository();
                    VerEstadoInfoAccion verEstadoInfoAccion = new VerEstadoInfoAccion(extractInfoStatusService);
                    ExtraerRegistroService extractInfoStatus = new ExtraerEstadoAvionRepository();
                    ExtraerRegistroAccion extractInfoStatusAction = new ExtraerRegistroAccion(extractInfoStatus);
                    AvionRecordService avionRecordService = new AvionRepository();
                    RecordAvionAccion recordAvionAccion = new RecordAvionAccion(avionRecordService);
                    AvionController avionController = new AvionController(existePlacasExtraccion, verModeloInfoAccion, extractInfoModelAction, verEstadoInfoAccion, extractInfoStatusAction, recordAvionAccion);
                    avionController.menuAvion();
                    break;

                case 2:
                    VueloService vueloService = new VueloRepository();
                    CreateVueloUseCase createVueloUseCase = new CreateVueloUseCase(vueloService);
                    VueloController vueloController = new VueloController(createVueloUseCase);
                    vueloController.menuVuelo();
                    break;

                case 3:
                    RevisionService revisionService = new RevisionRepository();
                    CreateRevisionUseCase createRevisionUseCase = new CreateRevisionUseCase(revisionService);
                    RevisionController revisionController = new RevisionController(createRevisionUseCase);
                    revisionController.menuRevision();
                    break;

                case 4:
                    AeropuertoService aeropuertoService = new AeropuertoRepository();
                    CreateAeropuertoUseCase createAeropuertoUseCase = new CreateAeropuertoUseCase(aeropuertoService);
                    AeropuertoController aeropuertoController = new AeropuertoController(createAeropuertoUseCase);
                    aeropuertoController.menuAeropuerto();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }
        }
    }
}

 
 

