import java.util.Scanner;

public class ConversorMonedaApp {
    private static String monedaBase;
    private static String monedaDestino;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción de conversión:");
            System.out.println("1. Peso Argentino a Dólar");
            System.out.println("2. Dólar a Peso Argentino");
            System.out.println("3. Real a Dólar");
            System.out.println("4. Dólar a Real");
            // Añadir más opciones...
            System.out.println("0. Salir");
            opcion = scanner.nextInt();

            if (opcion != 0) {
                System.out.print("Ingrese la cantidad a convertir: ");
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
                    // Agregar más casos para otras conversiones...
                    default:
                        System.out.println("Opción no válida.");
                        continue;
                }

                // Obtener tasa de cambio de la API
                double tasaCambio = obtenerTasaCambio(monedaBase, monedaDestino);

                // Realizar la conversión
                double resultado = convertir(cantidad, tasaCambio);
                System.out.printf("El resultado de la conversión es: %.2f %s%n", resultado, monedaDestino);
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static double obtenerTasaCambio(String monedaBase, String monedaDestino) {
        // Aquí llamas a tu clase TasaCambioAPI y obtienes la tasa
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