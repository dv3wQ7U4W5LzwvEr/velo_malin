package model;

/**
 * Created by MePec on 14/10/2015.
 */
public class StationDisponibilites{
    
    int id_stationdisponible;
    int id_station = 0;
    int date_MAJ = '0';
    int places_occupees;
    int places_disponibles;
    int date_MAJ_JCDecaux;
    boolean jour_special;
    boolean vacances_scolaires;
    private enum jour {Lundi,Mardi,Mercredi,Jeudi,Vendredi,Samedi,Dimanche};
}
