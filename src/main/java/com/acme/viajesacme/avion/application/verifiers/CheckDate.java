package com.acme.viajesacme.avion.application.verifiers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CheckDate {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String check(String input) {
        try {
            LocalDate.parse(input.trim(), DATE_FORMAT);
            return input.trim();
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Debe ingresar una fecha válida en el formato AAAA-MM-DD. Intente de nuevo:");
        }
    }
}
