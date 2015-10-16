package recherche;

import java.util.Date;

public class StatisquesStation {

	public int getMoyPlaceAllTimeOnStation(int id_station){
		
		String sqlQuery = "SELECT SUM(places_disponibles) FROM stationsdisponibilites WHERE id_station="+ id_station;

//		int moyenne = resultat requete;
	
		return moyenne;
		
	}
	
	public int getMoyVeloAllTimeOnStation(int id_station){
			
			String sqlQuery = "SELECT SUM(places_occupees) FROM stationsdisponibilites WHERE id_station="+ id_station;
			
//			int moyenne = resultat requete;
			
			return moyenne;
			
	}
	
	public int getMoyVeloOnTimeOnStation(int id_station, Date jour){
	    
		long offSet = 60000*5;	//5 minites in millisecs
		long longJour = jour.getTime();
		
		Date jourX = new Date(longJour + (10 * offSet));
		Date jourY = new Date(longJour + (10 * offSet));
		
		String sqlQuery = "SELECT SUM(places_occupees) FROM stationsdisponibilites WHERE id_station="+ id_station +" AND jour BETWEEN "+ jourX +" AND "+ jourY;
		
//		int moyenne = resultat requete;
		
		return moyenne;
		
}
	
}
