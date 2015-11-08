package recherche;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
		List<Integer> nbVelo = MysqlRequester.getNombreDeVelosSurStationDansInterval(id_station, dateX, dateY, jours, jour_special);
		
		if( nbVelo == null){
			return -1;
		} else {
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
	}
	
	public static int getMoyenneNbPlacesSurStation(int id_station, Date dateX, Date dateY, List<Jours> jours, String jour_special){
		List<Integer> nbPlace = MysqlRequester.getNombreDePlacesSurStationDansInterval(id_station, dateX, dateY, jours, jour_special);
		
		if( nbPlace == null){
			return -1;
		} else {
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
	
	public static int getMoyenneNbVelosSurStationAuMoment(int id_station, LocalTime heure, Jours jour, String jour_special){
		List<Integer> nbVelos = MysqlRequester.getNombreDePlacesSurStationAuMoment(id_station, heure, jour, jour_special);
		
		if( nbVelos == null){
			return -1;
		} else {
			Integer sum = 0;
			int moyenne = 0;
			if(!nbVelos.isEmpty()) {
				for (Integer velo : nbVelos) {
					sum += velo;
				}
				moyenne = (int) (sum.doubleValue() / nbVelos.size());
			}
			return moyenne;
		}
	}
	
	public static Map<Integer, Integer> getNombreDeVelosSurStationAuMomentAveIDC(int id_station, LocalTime heure, Jours jour, String jour_special, long intervalMinutes){
		
		LocalTime heureAvant = heure.minusMinutes(intervalMinutes);
		LocalTime heureApres = heure.plusMinutes(intervalMinutes);
		
		int velosAvant = getMoyenneNbVelosSurStationAuMoment(id_station, heureAvant, jour, jour_special);
		int nbVelos = getMoyenneNbVelosSurStationAuMoment(id_station, heure, jour, jour_special);
		int velosApres = getMoyenneNbVelosSurStationAuMoment(id_station, heureApres, jour, jour_special);
		
		return null;
	}
	
	public static int getMoyenneNbPlacesSurStationAuMoment(int id_station, LocalTime heure, Jours jour, String jour_special){
		List<Integer> nbPlaces = MysqlRequester.getNombreDeVelosSurStationAuMoment(id_station, heure, jour, jour_special);
		
		if( nbPlaces == null){
			return -1;
		} else {
			Integer sum = 0;
			int moyenne = 0;
			if(!nbPlaces.isEmpty()) {
				for (Integer velo : nbPlaces) {
					sum += velo;
				}
				moyenne = (int) (sum.doubleValue() / nbPlaces.size());
			}
			return moyenne;
		}
	}
	
	public static Map<Integer, Integer> getNombreDePlacesSurStationAuMomentAveIDC(int id_station, LocalTime heure, Jours jour, String jour_special, long intervalMinutes){
		
		LocalTime heureAvant = heure.minusMinutes(intervalMinutes);
		LocalTime heureApres = heure.plusMinutes(intervalMinutes);
		
		int placesAvant = getMoyenneNbVelosSurStationAuMoment(id_station, heureAvant, jour, jour_special);
		int nbPlaces = getMoyenneNbVelosSurStationAuMoment(id_station, heure, jour, jour_special);
		int placesApres = getMoyenneNbVelosSurStationAuMoment(id_station, heureApres, jour, jour_special);
		
		return null;
	}
}
