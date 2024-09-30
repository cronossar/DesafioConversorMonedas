import com.aluracurso.arregloAPI.TasaCambioAPI;

import java.util.Scanner;

public class ConversorMonedaApp {
    private static String monedaBase;
    private static String monedaDestino;

    public static void main(String[] args) {

        String red="\033[31m";
        String green="\033[32m";
        String yellow="\033[33m";
        String blue="\033[34m";
        String cyan="\033[36m";
        String reset="\u001B[0m";


        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(yellow + "Seleccione una opción de conversión:" + reset);
            System.out.println("1. Peso Argentino a Dólar");
            System.out.println("2. Dólar a Peso Argentino");
            System.out.println("3. Real a Dólar");
            System.out.println("4. Dólar a Real");
            System.out.println("5. Guaraníes a Dólar");
            System.out.println("6. Dólar a Guaraníes");
            // Añadir más opciones...
            System.out.println("0. Salir");
            opcion = scanner.nextInt();

            if (opcion != 0) {
                System.out.print(cyan + "Ingrese la cantidad a convertir: " + reset);
                double cantidad = scanner.nextDouble();

                switch (opcion) {
                    case 1:
                        monedaBase = "ARS"; // Peso Argentino
                        monedaDestino = "USD"; // Dólar
                        break;
                    case 2:
                        monedaBase = "USD"; // Dólar
                        monedaDestino = "ARS"; // Peso Argentino
                        break;
                    case 3:
                        monedaBase = "BRL"; // Real
                        monedaDestino = "USD"; // Dólar
                        break;
                    case 4:
                        monedaBase = "USD"; // Dólar
                        monedaDestino = "BRL"; // Real
                        break;
                    case 5:
                        monedaBase = "PYG"; // Guaranies
                        monedaDestino = "USD"; // Dólar
                        break;
                    case 6:
                        monedaBase = "USD"; // Dólar
                        monedaDestino = "PYG"; // Guaraníe
                        break;
                    // Agregar más casos para otras conversiones...
                    default:
                        System.out.println(red + "Opción no válida." + reset);
                        continue;
                }

                // Obtener tasa de cambio de la API
                double tasaCambio = obtenerTasaCambio(monedaBase, monedaDestino);

                // Realizar la conversión
                double resultado = convertir(cantidad, tasaCambio);
                System.out.printf(cyan + "El resultado de la conversión es: %.2f %s%n" + reset, resultado, monedaDestino);
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static double obtenerTasaCambio(String monedaBase, String monedaDestino) {
        // Aquí llamas a tu clase com.aluracurso.arregloAPI.TasaCambioAPI y obtienes la tasa
        try {
            return TasaCambioAPI.obtenerTasaCambio(monedaBase, monedaDestino);
        } catch (Exception e) {
            System.err.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 1; // Valor por defecto en caso de error
        }
    }

    private static double convertir(double cantidad, double tasaCambio) {
        return cantidad * tasaCambio;
    }
}