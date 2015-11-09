package recherche;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.MysqlRequester;
import model.Jours;
import model.Station;

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
	
	public static Map<Integer, Integer> getNombreDePlacesSurStationAuMomentAveIDV(int id_station, LocalTime heure, Jours jour, String jour_special, long intervalMinutes){
		
		LocalTime heureAvant = heure.minusMinutes(intervalMinutes);
		LocalTime heureApres = heure.plusMinutes(intervalMinutes);
		
		Station station = MysqlRequester.getStation(id_station);
		int placesMax = station.getPlaces();
		
		int placesAvant = getMoyenneNbPlacesSurStationAuMoment(id_station, heureAvant, jour, jour_special);
		int nbPlaces = getMoyenneNbPlacesSurStationAuMoment(id_station, heure, jour, jour_special);
		int placesApres = getMoyenneNbPlacesSurStationAuMoment(id_station, heureApres, jour, jour_special);
		
		int tendance = placesApres - placesAvant;
		
		Map<Integer, Integer> resultat = new HashMap<>();
		
		if( nbPlaces == 0 ){
			resultat.put(nbPlaces, 1);
			return resultat;			
		} else if( nbPlaces == 1 || nbPlaces == 2 ){
			if( tendance > 0 ){
				resultat.put(nbPlaces, 2);
				return resultat;
			} else if( tendance == 0 ){
				resultat.put(nbPlaces, 2);
				return resultat;
			} else if( tendance < 0 ){
				resultat.put(nbPlaces, 1);
				return resultat;
			} else {
				return null;
			}
		} else if( nbPlaces > placesMax/2 ){
			if( tendance > 0 ){
				resultat.put(nbPlaces, 4);
				return resultat;
			} else if( tendance == 0 ){
				resultat.put(nbPlaces, 4);
				return resultat;
			} else if( tendance < 0 ){
				resultat.put(nbPlaces, 3);
				return resultat;
			} else {
				return null;
			}
		} else if( nbPlaces < placesMax/2 ){
			if( tendance > 0 ){
				resultat.put(nbPlaces, 4);
				return resultat;
			} else if( tendance == 0 ){
				resultat.put(nbPlaces, 3);
				return resultat;
			} else if( tendance < 0 ){
				resultat.put(nbPlaces, 2);
				return resultat;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
		
	public static Map<Integer, Integer> getNombreDeVelosSurStationAuMomentAveIDV(int id_station, LocalTime heure, Jours jour, String jour_special, long intervalMinutes){
		
		LocalTime heureAvant = heure.minusMinutes(intervalMinutes);
		LocalTime heureApres = heure.plusMinutes(intervalMinutes);
		
		Station station = MysqlRequester.getStation(id_station);
		int velosMax = station.getPlaces();
		
		int velosAvant = getMoyenneNbVelosSurStationAuMoment(id_station, heureAvant, jour, jour_special);
		int nbVelos = getMoyenneNbVelosSurStationAuMoment(id_station, heure, jour, jour_special);
		int velosApres = getMoyenneNbVelosSurStationAuMoment(id_station, heureApres, jour, jour_special);
		
		int tendance = velosApres - velosAvant;
		
		Map<Integer, Integer> resultat = new HashMap<>();
		
		if( nbVelos == 0 ){
			resultat.put(nbVelos, 1);
			return resultat;			
		} else if( nbVelos == 1 || nbVelos == 2 ){
			if( tendance > 0 ){
				resultat.put(nbVelos, 2);
				return resultat;
			} else if( tendance == 0 ){
				resultat.put(nbVelos, 2);
				return resultat;
			} else if( tendance < 0 ){
				resultat.put(nbVelos, 1);
				return resultat;
			} else {
				return null;
			}
		} else if( nbVelos > velosMax/2 ){
			if( tendance > 0 ){
				resultat.put(nbVelos, 4);
				return resultat;
			} else if( tendance == 0 ){
				resultat.put(nbVelos, 4);
				return resultat;
			} else if( tendance < 0 ){
				resultat.put(nbVelos, 3);
				return resultat;
			} else {
				return null;
			}
		} else if( nbVelos < velosMax/2 ){
			if( tendance > 0 ){
				resultat.put(nbVelos, 4);
				return resultat;
			} else if( tendance == 0 ){
				resultat.put(nbVelos, 3);
				return resultat;
			} else if( tendance < 0 ){
				resultat.put(nbVelos, 2);
				return resultat;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	private static double getKmFromLatLong(double departLatitude, double departLongitude, double arriveLongitude, double arriveLatitude)
	{
		double lng1 = departLongitude;
		double lng2 = arriveLongitude;
		double lat1 = departLatitude;
		double lat2 = arriveLatitude;

		double earthRadius = 6371000; //meters
		double dLat = Math.toRadians(lat2-lat1);
		double dLng = Math.toRadians(lng2-lng1);
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
				Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
						Math.sin(dLng/2) * Math.sin(dLng/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double dist =  (earthRadius * c);

		dist = dist / 1000 * 1.5; // 1.5 = coeff bat + circulation
		System.out.print(dist);
		return dist;
	}

	public static double getTempsDeTrajet(double departLatitude, double departLongitude, double arriveLatitude, double arriveLongitude)
	{
		double distanceKm = getKmFromLatLong(departLatitude, departLongitude, arriveLongitude, arriveLatitude);
		return distanceKm / 16 * 60; // 16 km heures
	}

}
