package com.aluracurso.registro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroOperaciones {
    private static final String NOMBRE_ARCHIVO = "registro_conversiones.txt";

    public static void agregarOperacion(String operacion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            writer.write(operacion);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

