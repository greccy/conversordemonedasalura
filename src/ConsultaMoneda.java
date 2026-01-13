import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda conversionMoneda(String baseCode, String targetCode , double amountConversion){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/731e3363a576125e05b90c77/pair/" + baseCode + "/" + targetCode + "/" + amountConversion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e ) {
            System.out.println(e.getMessage());
            throw new RuntimeException("No encontre esa moneda para conversión");
        }
    }
}
