package recherche;

import java.util.ArrayList;
import java.util.List;

public class StationsProximitees {
	
	List getStationsProximité(int longitude, int latitude, int nb_stations){
		
		List listStations;
		
		String sqlQuery = "SELECT id_station FROM Stations WHERE (latitude BETWEEN "+ latitude-0,0045 +" AND " + latitude+0,0045 +") AND (longitude BETWEEN "+ longitude-0,0045 +" AND "+ longitude+0,0045;
		
		return listStations;
		
	}
	
}
