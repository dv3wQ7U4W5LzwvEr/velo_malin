package model;

import java.util.Date;

/**
 * Created by MePec on 14/10/2015.
 */
public class StationDisponibilites {

    private int id_stationDisponible;
    private int id_station;
    private String nom;
    private Date date_MAJ;
    private int placesOccupees;
    private int placesDisponibles;
    private Date dateMajJCdecaux;
    private boolean jourSpecial;
    private boolean vacancesScolaires;
    private Jours jour;

    public int getId_stationDisponible() {
        return id_stationDisponible;
    }

    public void setId_stationDisponible(int id_stationDisponible) {
        this.id_stationDisponible = id_stationDisponible;
    }

    public int getId_station() {
        return id_station;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }

    public Date getDate_MAJ() {
        return date_MAJ;
    }

    public void setDate_MAJ(Date date_MAJ) {
        this.date_MAJ = date_MAJ;
    }

    public int getPlacesOccupees() {
        return placesOccupees;
    }

    public void setPlacesOccupees(int placesOccupees) {
        this.placesOccupees = placesOccupees;
    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    public void setPlacesDisponibles(int placesDisponibles) {
        this.placesDisponibles = placesDisponibles;
    }

    public Date getDateMajJCdecaux() {
        return dateMajJCdecaux;
    }

    public void setDateMajJCdecaux(Date dateMajJCdecaux) {
        this.dateMajJCdecaux = dateMajJCdecaux;
    }

    public boolean isJourSpecial() {
        return jourSpecial;
    }

    public void setJourSpecial(boolean jourSpecial) {
        this.jourSpecial = jourSpecial;
    }

    public boolean isVacancesScolaires() {
        return vacancesScolaires;
    }

    public void setVacancesScolaires(boolean vacancesScolaires) {
        this.vacancesScolaires = vacancesScolaires;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Jours getJour() {
        return jour;
    }

    public void setJour(Jours jour) {
        this.jour = jour;
    }

}
