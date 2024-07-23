package com.acme.viajesacme.avion.application.verifiers;

public class CheckInt {

    public static int check(String input) {
        try {
            int number = Integer.parseInt(input.trim());
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Debe ingresar un número entero válido. Intente de nuevo:");
        }
    }
}
