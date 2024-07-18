package com.acme.viajesacme.vuelo.infrastructure.in;

import com.acme.viajesacme.vuelo.application.CreateVueloUseCase;
import com.acme.viajesacme.vuelo.domain.entity.Vuelo;

import java.util.Scanner;

public class VueloController {

    private CreateVueloUseCase createVueloUseCase;

    public VueloController(CreateVueloUseCase createVueloUseCase) {
        this.createVueloUseCase = createVueloUseCase;
    }

    public void registrarVuelo() {
        Scanner scanner = new Scanner(System.in);

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
    }
}

