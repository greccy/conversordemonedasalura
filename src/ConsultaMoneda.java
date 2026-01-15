import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    private final Gson gson = new Gson();
    public Moneda conversionMoneda(String baseCode, String targetCode , double amountConversion,HttpClient client){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/731e3363a576125e05b90c77/pair/" + baseCode + "/" + targetCode + "/" + amountConversion);


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
