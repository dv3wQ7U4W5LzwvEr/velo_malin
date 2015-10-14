package was;

import com.google.gson.Gson;
import database.MysqlConnecter;
import model.Station;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import was.model.StationWas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimerTask;

public class WebService extends TimerTask{

    private String apiKey = "&apiKey=fa1d875bef00abe2c7a281f1087bcc122f62379a";

    private String requestBase = "https://api.jcdecaux.com/vls/v1/stations?contract=Lyon";


    public void run() {
        try {
            // Recuperation du flux de donn�es depuis JcDecaux
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(buildRequest());
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            // D�s�rialisation des don  n�es
            String data = rd.readLine();
            Gson gson = new Gson();
            StationWas[] stations = gson.fromJson(data, StationWas[].class);

            MysqlConnecter mysqlConnecter = new MysqlConnecter();

            for (int i = 0 ; i < stations.length ; i++)
            {

                Station station = new Station();
                station.setNom(stations[i].getName());
                station.setAdresse(stations[i].getAddress());
                station.setLatitude(stations[i].getPosition().getLatitude());
                station.setLongitude(stations[i].getPosition().getLongitude());
                station.setPlaces(stations[i].getBike_stands());

                
                /*
                mysqlConnecter.majStation(station);*/
            }

            // sauvegarde dans un fichier
            DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            String date = shortDateFormat.format(new Date());
            System.out.println("Date : " + new Date());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public StationWas[] demo()
    {
        try {
            // Recuperation du flux de donn�es depuis JcDecaux
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(buildRequest());
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            // D�s�rialisation des don  n�es
            String data = rd.readLine();
            Gson gson = new Gson();
            StationWas[] stations = gson.fromJson(data, StationWas[].class);

            MysqlConnecter mysqlConnecter = new MysqlConnecter();
            
  /*          for (int i = 0 ; i < stations.length ; i++)
            {

                Station station = new Station();
                station.setNom(stations[i].getName());
                station.setAdresse(stations[i].getAddress());
                station.setLatitude(stations[i].getPosition().getLatitude());
                station.setLongitude(stations[i].getPosition().getLongitude());
                station.setPlaces(stations[i].getBike_stands());
                	
                
                /*
                mysqlConnecter.majStation(station);
            }*/

            // sauvegarde dans un fichier
            DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            String date = shortDateFormat.format(new Date());
            System.out.println("Date : " + new Date()); return stations;
        } catch (Exception e) {
            System.out.println(e);
        }
		return null;    	
    }

    private String buildRequest() {
        return requestBase + apiKey;
    }
}
