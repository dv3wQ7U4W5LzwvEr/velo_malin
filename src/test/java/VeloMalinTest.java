import model.Client;
import model.Station;
import database.MysqlConnecter;

import java.util.Date;
import java.util.List;

import IHM.Fenetre;

/**
 * Created by florian on 2015-09-29.
 */
public class VeloMalinTest {

	public static void main(String[] arg)
	{
	  
//		boolean resultat_test;
//		
//		Client test_client;
//		test_client = new Client();
//		//Client test_client_actuel;	
//		Station test_station;
//		test_station = new Station();
//		Station station_depart = new Station();
//		Station station_arrivee = new Station();
//		
//		
//		test_station.setId_station(2);
//		test_client.setId_client(5);
//		station_depart.setId_station(10);
//		station_arrivee.setId_station(20);
//		
//		//test_client_actuel.getId_client();
		
		MysqlConnecter mysql;
		mysql = new MysqlConnecter();
	
//		//test de base g�n�ral
//		resultat_test = mysql.insertStationFavorite(test_client,test_station);
//		resultat_test = mysql.insertItineraireFavorit(test_client,station_depart,station_arrivee);
//		
//		//test plus r�aliste : avec id r�cup�r� du client actuel
//		//resultat_test = mysql.insertStationFavorite(test_client_actuel,test_station);
		
//		Obtenir un intervalle depuis une date.	
		Date jour = new Date(2015, 10, 28, 13, 00);
		long offSet = 60000*5;	//5 minites in millisecs
		long longJour = jour.getTime();
		
		Date jourX = new Date(longJour + (10 * offSet));
		Date jourY = new Date(longJour + (10 * offSet));
		
		List<Integer> nbVelo = mysql.getVeloSurStation(2863, jourX, jourY);
		
		System.out.println(nbVelo.size());
		
		
	}

}


