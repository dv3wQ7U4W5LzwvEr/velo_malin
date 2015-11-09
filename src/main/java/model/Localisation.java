package model;

/**
 * Created by laurel on 04/11/2015.
 */
public class Localisation {

    private String adresse;
    private double latitude;
    private double longitude;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isInitialise()
    {
        return latitude != 0.0 && longitude != 0.0;
    }
}
