package database;

import model.Client;
import model.Jours;
import model.Station;
import model.StationDisponibilites;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by laurel on 03/11/2015.
 */
public class MysqlRequester {

    /**
     * Methode pour executer les requetes qui NE modifient PAS la base de donnees (select, etc)
     *
     * @param requete
     * @return
     */
    private static ResultSet executerRequete(String requete) {
        MysqlConnecter mysqlConnecter = MysqlConnecter.getInstance();
        return mysqlConnecter.executerRequeteInDatabase(requete);
    }

    /**
     * Methode pour executer les requetes qui MODIFIENT la base de donnees (select, etc)
     *
     * @param requete
     * @return
     */
    private static void executerRequeteInsertDeleteUpdate(String requete) {
        MysqlConnecter mysqlConnecter = MysqlConnecter.getInstance();
        mysqlConnecter.executerRequeteInsertDeleteUpdateInDatabase(requete);
    }

    /**
     * Insert les donnees statiques sur les stations (nom, adresse, position etc);
     *
     * @param stations
     */
    public static void insertStationDonneesStatiques(List<Station> stations) {
        Map<String, Integer> listeDesStations = getTousLesIdDesStationsParNom();
        String nom, adresse;
        for (Station s : stations) {
            nom = s.getNom().replace("'", "\\'");
            adresse = s.getAdresse().replace("'", "\\'");
            if (!nom.equals("")) {
                if (listeDesStations.get(nom) == null) {
                    String requete = "INSERT INTO VELO_MALIN.STATIONS (nom, adresse, latitude, longitude, places) " +
                            "values ( '" + nom + "', '" + adresse + "','" + s.getLatitude() + "', '" + s.getLongitude() + "', '" + s.getPlaces() + "')";
                    executerRequeteInsertDeleteUpdate(requete);
                    System.out.println("Creation de la station pour: " + nom);
                } else {
                    System.out.println("Pas de maj pour la station pour: " + nom);
                }
            }
        }
        System.out.println("Insertion des donnees statiques terminees a : " + new Date());
    }

    /**
     * Insert les donnees dynamiques sur les stations (nombre de velos utilises, date de maj etc);
     *
     * @param stations
     * @todo faire la gestion des jours, jours fÃ©ries et vacance
     */
    public static void insertStationDonneesDynamiques(List<StationDisponibilites> stations) {
        Map<String, Integer> listeDesStations = getTousLesIdDesStationsParNom();
        Map<Integer, Timestamp> listeDerniereDateModifieeParStation = getToutesLesDatesDernieresModificationsParId();
        int idStation;
        Calendar dateMAJ = Calendar.getInstance();
        Calendar dateMajJCDecaux = Calendar.getInstance();
        Timestamp dateMajJCDecauxSql, dateMajSql;
        String nom, adresse;


        for (StationDisponibilites s : stations) {
            nom = s.getNom().replace("'", "\\'");
            if (!nom.equals("")) {
                idStation = listeDesStations.get(nom);
                dateMAJ.setTime(s.getDate_MAJ());
                dateMAJ.set(Calendar.MILLISECOND, 0);
                dateMajJCDecaux.setTime(s.getDateMajJCdecaux());
                dateMajJCDecaux.set(Calendar.MILLISECOND, 0);
                dateMajJCDecauxSql = new Timestamp(dateMajJCDecaux.getTimeInMillis());
                dateMajSql = new java.sql.Timestamp(dateMAJ.getTimeInMillis());

                if (!listeDerniereDateModifieeParStation.get(idStation).equals(dateMajJCDecauxSql)) {
                    String requete = "INSERT INTO VELO_MALIN.STATIONSDISPONIBILITES (id_station, date_MAJ," +
                            " places_occupees, places_disponibles, date_MAJ_JCDecaux, jour_special, vacances_scolaires, jour)" +
                            "values (' " + idStation + "','" + dateMajSql + "','" + s.getPlacesOccupees() + "','" + s.getPlacesDisponibles() + "','" + dateMajJCDecauxSql
                            + "','" + 0 + "','" + 0 + "','" + Jours.LUNDI + "')";
                    executerRequeteInsertDeleteUpdate(requete);
                    System.out.println("Insertion ok pour: " + nom + " a : " + new Date());
                } else {
                    System.out.println("Non Insertion pour: " + nom + " ; date de derniere maj a : " + dateMajJCDecauxSql);
                }
            }
        }
        System.out.println("Insertion des donnees dynamique terminees a : " + new Date());
    }

    private static Map<String, Integer> getTousLesIdDesStationsParNom() {
        String requete = "SELECT * FROM VELO_MALIN.STATIONS";
        ResultSet resultat = executerRequete(requete);
        Map<String, Integer> listeDesStations = new HashMap<String, Integer>();
        Station s;
        String nom;
        try {
            while (resultat.next()) {
                s = new Station();
                int idStation = resultat.getInt("id_station");
                s.setId_station(idStation);
                nom = resultat.getString("nom").replace("'", "\\'");
                s.setNom(nom);
                listeDesStations.put(nom, idStation);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MysqlConnecter.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Erreur: " + ex);
        }
        return listeDesStations;
    }

    private static Map<Integer, Timestamp> getToutesLesDatesDernieresModificationsParId() {
        String requete = "SELECT id_station, max(date_MAJ_JCDecaux) date_MAJ_JCDecaux FROM velo_malin.stationsdisponibilites group by id_station;";
        ResultSet resultat = executerRequete(requete);
        Map<Integer, Timestamp> listeDesStations = new HashMap<Integer, Timestamp>();
        try {
            int idStation;
            Timestamp date;
            while (resultat.next()) {
                idStation = resultat.getInt("id_station");
                date = Timestamp.valueOf(resultat.getString("date_MAJ_JCDecaux"));
                listeDesStations.put(idStation, date);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MysqlConnecter.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Erreur: " + ex);
        }
        return listeDesStations;
    }

    public static List<Integer> getNombreDeVelosSurStation(int id_station, Date dateX, Date dateY) {

        SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String sqlQuery = "SELECT places_occupees FROM velo_malin.stationsdisponibilites WHERE id_station='" + id_station +
                "' AND date_MAJ_JCDecaux BETWEEN '" + datetime.format(dateX) + "' AND '" + datetime.format(dateY) + "'";

        ResultSet rs = executerRequete(sqlQuery);
        List<Integer> nbVeloList = new ArrayList<Integer>();
        try {
            while (rs.next()) {
                nbVeloList.add(rs.getInt("places_occupees"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nbVeloList;
    }

    public static List<Integer> getNombreDePlacesSurStation(int id_station, Date dateX, Date dateY) {

        SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String sqlQuery = "SELECT places_disponibles FROM velo_malin.stationsdisponibilites WHERE id_station='" + id_station + "' AND date_MAJ_JCDecaux BETWEEN '" +
                datetime.format(dateX) + "' AND '" + datetime.format(dateY) + "'";

        ResultSet rs = executerRequete(sqlQuery);
        List<Integer> nbPlaceList = new ArrayList<Integer>();
        try {
            while (rs.next()) {
            	nbPlaceList.add(rs.getInt("places_disponibles"));
            }
        } catch (SQLException e) {
            // TODO Bloc catch généré automatiquement
            e.printStackTrace();
        }

        return nbPlaceList;
    }

    public static Station getStation(int id_station) {

        Station station = new Station();

        String sqlQuery = "SELECT * FROM velo_malin.stations WHERE id_station='" + id_station + "';";

        ResultSet rs = executerRequete(sqlQuery);

        try {
            if (rs.next()) {
                station.setId_station(rs.getInt("id_station"));
                station.setNom(rs.getString("nom"));
                station.setAdresse(rs.getString("adresse"));
                station.setLatitude(rs.getString("latitude"));
                station.setLongitude(rs.getString("longitude"));
                station.setPlaces(rs.getInt("places"));
            }
        } catch (NumberFormatException e) {
            // TODO Bloc catch généré automatiquement
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Bloc catch généré automatiquement
            e.printStackTrace();
        }

        return station;
    }

    public static Map<Station, Double> getStationsProximitees(double latitude, double longitude, int nb_stations, double distance) {

        Map<Station, Double> mapStations = new HashMap<Station, Double>();
        
        // Merci à Oleksiy Kovyrin
        String sqlQuery = "SELECT *,3956 * 2 * ASIN(SQRT( POWER(SIN(('"+ latitude +"' - abs(latitude)) * pi()/180 / 2),2) + COS('"+ latitude +"' * pi()/180 ) * COS( abs(latitude) *  pi()/180) * POWER(SIN(('"+ longitude +"' - longitude) *  pi()/180 / 2), 2) )) as distance FROM velo_malin.stations having distance < '"+ distance +"' ORDER BY distance limit "+ nb_stations +";";
        
        ResultSet rs = executerRequete(sqlQuery);
        Station station;
        
        try {
            while (rs.next()) {
            	station = new Station();
            	station.setId_station(rs.getInt("id_station"));
                station.setNom(rs.getString("nom"));
                station.setAdresse(rs.getString("adresse"));
                station.setLatitude(rs.getString("latitude"));
                station.setLongitude(rs.getString("longitude"));
                station.setPlaces(rs.getInt("places"));
                mapStations.put(station, rs.getDouble("distance"));
            }
        } catch (SQLException e) {
            // TODO Bloc catch généré automatiquement
            e.printStackTrace();
        }

        return mapStations;
    }


    public static boolean insertStationFavorite(Client client, int Id_station) {

        boolean result_insertion = false;

        String sqlQuery = " INSERT INTO VELO_MALIN.STATIONSFAVORITES (id_client, id_station) VALUES ( " + client.getId_client() + "," + Id_station +
                ")";
        //si pb : mettre simple quote pour valeur variable

        executerRequeteInsertDeleteUpdate(sqlQuery);


        try {
            //traitement java pur

            //result_insertion = true;
        } catch (NumberFormatException e) {
            // TODO Bloc catch généré automatiquement
            e.printStackTrace();
        } /*catch (SQLException e) {
            // TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}*/

        return result_insertion;
    }

    public static boolean insertItineraireFavorit(Client client, int station_depart, int station_arrivee) {

        boolean result_insertion = false;

        String sqlQuery = "INSERT INTO VELO_MALIN.ITINERAIRESFAVORIS (id_client, id_station_depart, id_station_arrivee) VALUES ( " + client.getId_client() + ","
                + station_depart + "," + station_arrivee + ")";

        executerRequeteInsertDeleteUpdate(sqlQuery);


        try {
            //traitement java pur

            //result_insertion = true;
        } catch (NumberFormatException e) {
            // TODO Bloc catch généré automatiquement
            e.printStackTrace();
        } /*catch (SQLException e) {
      // TODO Bloc catch généré automatiquement
			e.printStackTrace();
		} */

        return result_insertion;
    }
    
    public static Map<Integer,Integer> getListeItinerairesFavoris() {

        String sqlQuery = "SELECT id_station_depart,id_station_arrivee FROM itinerairesfavoris";

        ResultSet rs = executerRequete(sqlQuery);
        Map<Integer,Integer> liste_itineraires_favoris = new HashMap<Integer,Integer>();

        try {
            while (rs.next()) {
            	liste_itineraires_favoris.put(rs.getInt("id_station_depart"), rs.getInt("id_station_arrivee"));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MysqlConnecter.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Erreur: " + ex);
        }
      return liste_itineraires_favoris;
 
    }
}
