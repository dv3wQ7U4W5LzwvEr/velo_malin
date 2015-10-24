package was;

import com.google.gson.Gson;
import database.MysqlConnecter;
import model.Station;
import model.StationDisponibilites;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import was.model.StationWas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

public class ServiceWeb extends TimerTask {

    private String apiKey = "&apiKey=fa1d875bef00abe2c7a281f1087bcc122f62379a";

    private String requestBase = "https://api.jcdecaux.com/vls/v1/stations?contract=Lyon";

    public void run() {
        try {
            majDesStationsDisponibilites();
            System.out.println("  -----  ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void creationDesInformationsSurLesStations() {
        try {
            StationWas[] stationsFromJson = getStationsInformationsFromJson();

            List<Station> stations = new ArrayList<Station>();
            Station s;
            for (int i = 0; i < stationsFromJson.length; i++) {

                s = new Station();
                s.setNom(stationsFromJson[i].getName());
                s.setAdresse(stationsFromJson[i].getAddress());
                s.setLatitude(stationsFromJson[i].getPosition().getLat());
                s.setLongitude(stationsFromJson[i].getPosition().getLng());
                s.setPlaces(stationsFromJson[i].getBike_stands());
                stations.add(s);
            }

            MysqlConnecter mysqlConnecter = MysqlConnecter.getInstance();
            mysqlConnecter.insertStationDonneesStatiques(stations);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void majDesStationsDisponibilites() {
        try {
            StationWas[] stationsFromJson = getStationsInformationsFromJson();

            List<StationDisponibilites> stations = new ArrayList<StationDisponibilites>();
            StationDisponibilites s;
            for (int i = 0; i < stationsFromJson.length; i++) {

                s = new StationDisponibilites();
                s.setNom(stationsFromJson[i].getName());
                s.setDate_MAJ(new Date());
                s.setPlacesOccupees(stationsFromJson[i].getAvailable_bikes());
                s.setPlacesDisponibles(stationsFromJson[i].getAvailable_bike_stands());
                s.setDateMajJCdecaux(new Date((long) stationsFromJson[i].getLast_update()));
                stations.add(s);
            }

            MysqlConnecter mysqlConnecter = MysqlConnecter.getInstance();
            mysqlConnecter.insertStationDonneesDynamiques(stations);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private StationWas[] getStationsInformationsFromJson() throws URISyntaxException, HttpException, IOException {
        // Recuperation du flux de donnees depuis JcDecaux
        BufferedReader rd = getBufferedReader();

        // Deserialisation des donnees
        String data = rd.readLine();
        Gson gson = new Gson();
        return gson.fromJson(data, StationWas[].class);
    }

    /**
     * Recuperation des donnees depuis le service web
     *
     * @return
     * @throws URISyntaxException
     * @throws HttpException
     * @throws IOException
     */
    private BufferedReader getBufferedReader() throws URISyntaxException, HttpException, IOException {
        // Recuperation du flux de donnees depuis JcDecaux
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(buildRequest());
        HttpResponse response = client.execute(request);
        return new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
    }


    private String buildRequest() {
        return requestBase + apiKey;
    }
}
