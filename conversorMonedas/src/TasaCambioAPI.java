import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TasaCambioAPI {
    private static final String API_KEY = "f8ce9b0c631b3633472846cd"; // Reemplaza con tu clave de API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double obtenerTasaCambio(String monedaBase, String monedaDestino) throws Exception {
        String urlString = BASE_URL + monedaBase; // Por ejemplo: "USD" para Dólar
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Error: " + conn.getResponseCode());
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return parseTasaCambio(response.toString(), monedaDestino);
    }

    private static double parseTasaCambio(String jsonResponse, String monedaDestino) {
        // Usaremos una simple búsqueda de cadena para extraer la tasa de cambio
        String key = "\"" + monedaDestino + "\":";
        int index = jsonResponse.indexOf(key);

        if (index == -1) {
            throw new RuntimeException("Moneda no encontrada en la respuesta.");
        }

        int start = index + key.length();
        int end = jsonResponse.indexOf(",", start);
        String tasaString = jsonResponse.substring(start, end).trim();

        return Double.parseDouble(tasaString);
    }
}
