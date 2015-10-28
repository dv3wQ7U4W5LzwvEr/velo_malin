import model.Client;
import model.Station;
import database.MysqlConnecter;
//import IHM.Fenetre;

/**
 * Created by florian on 2015-09-29.
 */
public class VeloMalinTest {

	public static void main(String[] arg)
	{
	  
		boolean resultat_test;
		
		Client test_client;
		test_client = new Client();
		Station test_station;
		test_station = new Station();
		
		test_station.setId_station(2);
		test_client.setId_client(5);
		
		MysqlConnecter mysql;
		mysql = new MysqlConnecter();
	
		resultat_test = mysql.insertStationFavorite(test_client,test_station);
		
		//resultat_test = insertItineraireFavorit(client,station_depart,station_arrivee);
	}

}


