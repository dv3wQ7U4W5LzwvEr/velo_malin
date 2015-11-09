package data;

import java.util.Calendar;

/**
 * Created by laurel on 09/11/2015.
 */
public class RechercheData {

    private static RechercheData instance = null;

    private String departLat;
    private String departLong;
    private String arriveLat;
    private String arriveLong;

    private Calendar dateHeure;

    protected static RechercheData getInstance() {
        if (instance == null) {
            instance = new RechercheData();
        }
        return instance;
    }

    public String getDepartLat() {
        return departLat;
    }

    public void setDepartLat(String departLat) {
        this.departLat = departLat;
    }

    public String getDepartLong() {
        return departLong;
    }

    public void setDepartLong(String departLong) {
        this.departLong = departLong;
    }

    public String getArriveLat() {
        return arriveLat;
    }

    public void setArriveLat(String arriveLat) {
        this.arriveLat = arriveLat;
    }

    public String getArriveLong() {
        return arriveLong;
    }

    public void setArriveLong(String arriveLong) {
        this.arriveLong = arriveLong;
    }

    public Calendar getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Calendar dateHeure) {
        this.dateHeure = dateHeure;
    }
}
