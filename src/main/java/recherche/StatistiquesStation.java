package recherche;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.MysqlRequester;
import model.Jours;

public class StatistiquesStation {
	
	public static List<Date> calculIntervalTemps(Date date, int intervalMinutes){	
		long offSet = 6000*intervalMinutes;	//5 minites in millisecs
		long longDate = date.getTime();
		
		Date dateX = new Date(longDate - (10 * offSet));
		Date dateY = new Date(longDate + (10 * offSet));
		
		List<Date> dateXY = new ArrayList<Date>();
		dateXY.add(dateX);
		dateXY.add(dateY);
		
		return dateXY;		
	}

	public static int getMoyenneNbVelosSurStation(int id_station, Date dateX, Date dateY, List<Jours> jours, String jour_special){
		List<Integer> nbVelo = MysqlRequester.getNombreDeVelosSurStation(id_station, dateX, dateY, jours, jour_special);
		
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
	
	public static int getMoyenneNbPlacesSurStation(int id_station, Date dateX, Date dateY, List<Jours> jours, String jour_special){
		List<Integer> nbPlace = MysqlRequester.getNombreDePlacesSurStation(id_station, dateX, dateY, jours, jour_special);
		
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
