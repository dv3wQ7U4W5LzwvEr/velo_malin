package model;

/**
 * Created by charlie on 13/11/2015.
 */
public class ItineraireFavori {

    private String idItineraireFavori;
    private String lat_stationDepart;
    private String long_stationDepart;
    private String lat_stationArrivee;
    private String long_stationArrivee;

    public String getIdItineraireFavori() {
        return idItineraireFavori;
    }

    public void setIdItineraireFavori(String idItineraireFavori) {
        this.idItineraireFavori = idItineraireFavori;
    }

    public String getLat_stationDepart() {
        return lat_stationDepart;
    }

    public void setLat_stationDepart(String lat_stationDepart) {
        this.lat_stationDepart = lat_stationDepart;
    }

    public String getLong_stationDepart() {
        return long_stationDepart;
    }

    public void setLong_stationDepart(String long_stationDepart) {
        this.long_stationDepart = long_stationDepart;
    }

    public String getLat_stationArrivee() {
        return lat_stationArrivee;
    }

    public void setLat_stationArrivee(String lat_stationArrivee) {
        this.lat_stationArrivee = lat_stationArrivee;
    }

    public String getLong_stationArrivee() {
        return long_stationArrivee;
    }

    public void setLong_stationArrivee(String long_stationArrivee) {
        this.long_stationArrivee = long_stationArrivee;
    }
}
