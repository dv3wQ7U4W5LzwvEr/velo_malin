package model;

public class Station {
	
	String nom,
		adresse,
		latitude,
		longitude;
	int id_station,
		places,
		places_occupees,
		places_disponibles;
	
	String sqlQuery= "SELECT nom, adresse, latitude, longitude, places, places_occupees, places_disponibles FROM Stations INNER JOIN StationsDisponibilites ON Stations.id_station = StationDisponibilites.id_station WHERE id_station="+ id_station;
	
	public Station(){};
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getId_station() {
		return id_station;
	}

	public void setId_station(int id_station) {
		this.id_station = id_station;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	public int getPlaces_occupees() {
		return places_occupees;
	}

	public void setPlaces_occupees(int places_occupees) {
		this.places_occupees = places_occupees;
	}

	public int getPlaces_disponibles() {
		return places_disponibles;
	}

	public void setPlaces_disponibles(int places_disponibles) {
		this.places_disponibles = places_disponibles;
	}
}