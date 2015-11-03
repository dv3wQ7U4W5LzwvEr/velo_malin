import recherche.StatisquesStation;
import database.MysqlConnecter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
//		
		MysqlConnecter mysql = new MysqlConnecter();
	
//		//test de base g�n�ral
//		resultat_test = mysql.insertStationFavorite(test_client,test_station);
//		resultat_test = mysql.insertItineraireFavorit(test_client,station_depart,station_arrivee);
//		
//		//test plus r�aliste : avec id r�cup�r� du client actuel
//		//resultat_test = mysql.insertStationFavorite(test_client_actuel,test_station);
	
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 10-1, 28, 13, 00, 00);
		Date date = cal.getTime();		

		List<Date> dateXY = StatisquesStation.calculInterval(date, 5);
		int moyVelo = StatisquesStation.getMoyVeloStation(2470, dateXY.get(0), dateXY.get(1));
		System.out.println(moyVelo +" velos le "+ date);
		
		int moyPlace = StatisquesStation.getMoyPlaceStation(2470, dateXY.get(0), dateXY.get(1));
		System.out.println(moyPlace +" place vers "+ date);
		
		System.out.println(MysqlConnecter.getStation(2470));
		
		System.out.println(MysqlConnecter.getStationsProximite(45.783791, 4.868972, 0, 0.25));
		
	}

}


