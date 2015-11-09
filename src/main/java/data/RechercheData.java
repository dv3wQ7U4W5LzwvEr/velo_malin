package data;

import java.util.Calendar;

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


	private Calendar dateHeureDepart = Calendar.getInstance();
    private Calendar dateHeureArrive = Calendar.getInstance();

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


	public Calendar getDateHeureArrive() {
        return dateHeureArrive;
    }

    public void setDateHeureArrive(Calendar dateHeureArrive) {
        this.dateHeureArrive = dateHeureArrive;
    }

	public double getTempsParcours() {
		return tempsParcours;
	}

	public void setTempsParcours(double tempsParcours) {
		this.tempsParcours = tempsParcours;
	}

	public Calendar getDateHeureDepart() {
		return dateHeureDepart;
	}

	public void setDateHeureDepart(Calendar dateHeureDepart) {
		this.dateHeureDepart = dateHeureDepart;
	}
}
