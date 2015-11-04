package was.google_map_api;

import com.google.gson.Gson;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import was.google_map_api.model.GeometryWas;
import was.google_map_api.model.GoogleResponseWas;
import was.google_map_api.model.LocalisationWas;
import was.google_map_api.model.ResultWas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.text.Normalizer;
import java.util.TimerTask;

/**
 * Created by laurel on 04/11/2015.
 */
public class GoogleMap extends TimerTask {


    private String apiKey = "&apiKey=AIzaSyC0Cwp8aZmmJx7DZXKVsOFxeDmJjzxfSyM";

    private String requestBase = "http://maps.googleapis.com/maps/api/geocode/json?address=";

    public void rechercherLatLong(String adresse)
    {
        try
        {
            adresse =  Normalizer.normalize(adresse, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replace(" ", "+").toLowerCase();
            GoogleResponseWas googleResponse = getLatLngInformationsFromJson(adresse);
            ResultWas result = googleResponse.getResult();
            GeometryWas geometryWas = result.getGeometry();
            LocalisationWas localisationWas = geometryWas.getLocation();
            Double latitude = localisationWas.getLat();
            Double longitude = localisationWas.getLng();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private BufferedReader getInformationLatLongDeGoogle(String adresse) throws URISyntaxException, HttpException, IOException {
        HttpClient client = new DefaultHttpClient();
        String url = requestBase + adresse + apiKey;
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        return new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
    }

    public void run() {
        try {
            rechercherLatLong("36 rue des antonins Résidence les tamaris villeurbanne");

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private GoogleResponseWas getLatLngInformationsFromJson(String adresse) throws URISyntaxException, HttpException, IOException {
        // Recuperation du flux de donnees depuis JcDecaux
        BufferedReader rd = getBufferedReader(adresse);

        // Deserialisation des donnees
        String data = rd.readLine();
        Gson gson = new Gson();
        return gson.fromJson(data, GoogleResponseWas.class);
    }

    /**
     * Recuperation des donnees depuis le service web
     *
     * @return
     * @throws URISyntaxException
     * @throws HttpException
     * @throws IOException
     */
    private BufferedReader getBufferedReader(String adresse ) throws URISyntaxException, HttpException, IOException {
        // Recuperation du flux de donnees depuis JcDecaux
        HttpClient client = new DefaultHttpClient();
        String url = requestBase + adresse + apiKey;
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        return new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
    }
}
