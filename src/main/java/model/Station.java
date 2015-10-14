package model;

public class Station {

    private int id_station;

    private String nom;

    private String adresse;

    private double latitude;

    private double longitude;

    private int places;

    public int getId_station() {
        return id_station;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getPlaces() {
        return places;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}
