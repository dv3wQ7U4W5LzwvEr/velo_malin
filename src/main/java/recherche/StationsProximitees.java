package recherche;

import java.util.ArrayList;
import java.util.List;

public class StationsProximitees {
	
	public List getStationsProximite(int longitude, int latitude, int nb_stations){

		List listStations = new ArrayList();
		
		double distance = 0.0045,
			latitudeMin= latitude-distance,
			latitudeMax= latitude+distance,
			longitudeMin= longitude-distance,
			longitudeMax= longitude+distance;
		
		String sqlQuery = "SELECT nom, adresse, latitude, longitude, places, places_occupees, places_disponibles FROM Stations INNER JOIN StationsDisponibilites ON Stations.id_station = StationDisponibilites.id_station WHERE latitude > "+ latitudeMin +" AND latitude < "+ latitudeMax +" AND longitude > "+ longitudeMin +" AND longitude < "+ longitudeMax;
		
//		ou
//		String sqlQuery = "SELECT id_station FROM Stations WHERE latitude BETWEEN "+ latitudeMin +" AND "+ latitudeMax +" AND longitude BETWEEN "+ longitudeMin +" AND "+ longitudeMax;
		
//		listStations = retour Sql query;
		
		return listStations;
	}
	
}
