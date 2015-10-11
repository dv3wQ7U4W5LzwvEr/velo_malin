package was;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import was.model.Station;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebService {

    private String apiKey = "&apiKey=fa1d875bef00abe2c7a281f1087bcc122f62379a";

    private String requestBase = "https://api.jcdecaux.com/vls/v1/stations?contract=Lyon";


    public void run() {
        try {
            // Recuperation du flux de données depuis JcDecaux
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(buildRequest());
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            // Désérialisation des données
            String data = rd.readLine();
            Gson gson = new Gson();
            Station[] stations = gson.fromJson(data, Station[].class);

            System.out.println(data);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String buildRequest() {
        return requestBase + apiKey;
    }
}
