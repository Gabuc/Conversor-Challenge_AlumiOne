// CurrencyAPI.java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrencyAPI {
    private static final Logger logger = Logger.getLogger(CurrencyAPI.class.getName());
    private final String apiKey;

    public CurrencyAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getExchangeRate(String fromCurrency, String toCurrency) {
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + fromCurrency;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                logger.log(Level.WARNING, "Erro da API: Código de resposta HTTP " + responseCode);
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            String jsonResponse = response.toString();
            return extractRate(jsonResponse, toCurrency);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao obter taxa de câmbio: ", e);
            return null;
        }
    }

    private String extractRate(String jsonResponse, String toCurrency) {
        try {
            int startIndex = jsonResponse.indexOf("\"" + toCurrency + "\":");
            if (startIndex == -1) {
                return null;
            }

            int valueStart = jsonResponse.indexOf(":", startIndex) + 1;
            int valueEnd = jsonResponse.indexOf(",", valueStart);
            if (valueEnd == -1) {
                valueEnd = jsonResponse.indexOf("}", valueStart);
            }

            return jsonResponse.substring(valueStart, valueEnd);
        } catch (Exception e) {
            return null;
        }
    }
}
