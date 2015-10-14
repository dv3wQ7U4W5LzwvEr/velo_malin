package recherche;

import java.util.ArrayList;
import java.util.List;

public class StationsProximitees {
	
	List getStationsProximité(int longitude, int latitude, int nb_stations){
		
		List listStations = new ArrayList();
		
		double distance = 0.0045,
			latitudeMin= latitude-distance,
			latitudeMax= latitude+distance,
			longitudeMin= longitude-distance,
			longitudeMax= longitude+distance;
		
		String sqlQuery = "SELECT id_station FROM Stations WHERE latitude > "+ latitudeMin +" AND latitude < "+ latitudeMax +" AND longitude > "+ longitudeMin +" AND longitude < "+ longitudeMax;
		
//		ou
//		String sqlQuery = "SELECT id_station FROM Stations WHERE latitude BETWEEN "+ latitudeMin +" AND "+ latitudeMax +" AND longitude BETWEEN "+ longitudeMin +" AND "+ longitudeMax;
		
		return listStations;
		
		
	}
	
}
