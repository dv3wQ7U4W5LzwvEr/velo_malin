package traitement_recherche_itineraires;

import java.sql.*;
//import java.time.*;

public class Proba_dispo_velov {

	String jour_actuel;
	int id_station;
	Date date;
	//donn�es pour tous les jours similaires pour une station pass� en param�tre
	String query_dispovelov = "SELECT places_occupees,places_disponibles FROM Stationsdisponibilites WHERE id_station ="+ id_station +"AND WHERE jour ="+ jour_actuel;
	
	
	
	
}
