import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    private static final String API_KEY = System.getenv("EXCHANGE_API_KEY");
    private final Gson gson = new Gson();

    public Moneda conversionMoneda(String baseCode, String targetCode , double amountConversion,HttpClient client){
        if (API_KEY == null || API_KEY.isBlank()) {
            throw new RuntimeException("API Key no configurada. Define la variable de entorno EXCHANGE_API_KEY");
        }

        URI direccion = URI.create(
                "https://v6.exchangerate-api.com/v6/" + API_KEY +
                        "/pair/" + baseCode + "/" + targetCode + "/" + amountConversion
        );

        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("La API respondió con error HTTP: " + response.statusCode());
            }

            Moneda moneda = gson.fromJson(response.body(), Moneda.class);
            if (moneda == null) {
                throw new RuntimeException("No se pudo interpretar la respuesta de la API.");
            }
            return moneda;

        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e ) {
            System.out.println(e.getMessage());
            throw new RuntimeException("No se pudo realizar la conversión");
        }
    }
}
