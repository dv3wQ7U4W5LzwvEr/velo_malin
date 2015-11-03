package recherche;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.MysqlConnecter;
import database.MysqlRequester;

public class StatisquesStation {
	
	public static List<Date> calculInterval(Date date, int intervalMinutes){	
		long offSet = 6000*intervalMinutes;	//5 minites in millisecs
		long longDate = date.getTime();
		
		Date dateX = new Date(longDate - (10 * offSet));
		Date dateY = new Date(longDate + (10 * offSet));
		
		List<Date> dateXY = new ArrayList<Date>();
		dateXY.add(dateX);
		dateXY.add(dateY);
		
		return dateXY;		
	}

	public static int getMoyVeloStation(int id_station, Date dateX, Date dateY){
		List<Integer> nbVelo = MysqlRequester.getNombreDeVelosSurStation(id_station, dateX, dateY);
		
		Integer sum = 0;
		int moyenne = 0;
		if(!nbVelo.isEmpty()) {
			for (Integer velo : nbVelo) {
				sum += velo;
			}
			moyenne = (int) (sum.doubleValue() / nbVelo.size());
		}
		
		return moyenne;
	}
	
	public static int getMoyPlaceStation(int id_station, Date dateX, Date dateY){
		List<Integer> nbPlace = MysqlRequester.getPlaceSurStation(id_station, dateX, dateY);
		
		Integer sum = 0;
		int moyenne = 0;
		if(!nbPlace.isEmpty()) {
			for (Integer velo : nbPlace) {
				sum += velo;
			}
			moyenne = (int) (sum.doubleValue() / nbPlace.size());
		}
		
		return moyenne;
	}
	
}
