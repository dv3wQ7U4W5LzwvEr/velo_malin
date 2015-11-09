package data;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by laurel on 09/11/2015.
 */
public class RechercheData {

    private static RechercheData instance = null;

    private double departLat;
    private double departLong;
    private double arriveLat;
    private double arriveLong;
	private double distanceKm;
	private double tempsParcours;

    private Calendar dateHeure = Calendar.getInstance();

    public static RechercheData getInstance() {
        if (instance == null) {
            instance = new RechercheData();
        }
        return instance;
    }

	public static void setInstance(RechercheData instance) {
		RechercheData.instance = instance;
	}

	public double getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(double distanceKm) {
		this.distanceKm = distanceKm;
	}

	public double getDepartLat() {
		return departLat;
	}


	public void setDepartLat(double departLat) {
		this.departLat = departLat;
	}


	public double getDepartLong() {
		return departLong;
	}


	public void setDepartLong(double departLong) {
		this.departLong = departLong;
	}


	public double getArriveLat() {
		return arriveLat;
	}


	public void setArriveLat(double arriveLat) {
		this.arriveLat = arriveLat;
	}


	public double getArriveLong() {
		return arriveLong;
	}


	public void setArriveLong(double arriveLong) {
		this.arriveLong = arriveLong;
	}


	public Calendar getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Calendar dateHeure) {
        this.dateHeure = dateHeure;
    }

	public double getTempsParcours() {
		return tempsParcours;
	}

	public void setTempsParcours(double tempsParcours) {
		this.tempsParcours = tempsParcours;
	}
}
