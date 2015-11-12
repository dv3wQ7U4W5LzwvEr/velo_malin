package model;

import java.util.Date;

/**
 * Created by laurel on 12/11/2015.
 */
public class Alerte {

    private int id;
    private int idItineraireFavori;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdItineraireFavori() {
        return idItineraireFavori;
    }

    public void setIdItineraireFavori(int idItineraireFavori) {
        this.idItineraireFavori = idItineraireFavori;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
