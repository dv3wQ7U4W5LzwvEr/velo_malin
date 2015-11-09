package data;

import model.Station;

import java.util.Calendar;

/**
 * Created by laurel on 09/11/2015.
 */
public class StatistiqueData {

    private static StatistiqueData instance = null;

    private Station station;

    private Calendar dateHeure;

    private String plageHoraire;

    protected static StatistiqueData getInstance() {
        if (instance == null) {
            instance = new StatistiqueData();
        }
        return instance;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Calendar getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Calendar dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getPlageHoraire() {
        return plageHoraire;
    }

    public void setPlageHoraire(String plageHoraire) {
        this.plageHoraire = plageHoraire;
    }
}
