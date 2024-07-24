package com.acme.viajesacme.avion.application.verifiers;

public class CheckString {

    public static String check(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo no puede estar vacío. Ingrese nuevamente:");
        }
        return input.trim();
    }
}
