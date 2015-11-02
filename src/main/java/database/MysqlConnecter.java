package database;


import model.Client;
import model.Jours;
import model.Station;
import model.StationDisponibilites;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by flauve on 2015-10-14.
 */
public class MysqlConnecter {

    private static MysqlConnecter instance = null;

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String password = "root";

    public MysqlConnecter() {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MysqlConnecter.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Erreur");
        }
    }

    public static MysqlConnecter getInstance() {
        if (instance == null) {
            instance = new MysqlConnecter();
        }
        return instance;
    }

    /**
     * Insert les donnees statiques sur les stations (nom, adresse, position etc);
     *
     * @param stations
     */
    public void insertStationDonneesStatiques(List<Station> stations) {
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
                }
            }
        }
        System.out.println("Insertion des donnees statiques terminees a : " + new Date());
    }

    /**
     * Insert les donnees dynamiques sur les stations (nombre de velos utilises, date de maj etc);
     *
     * @param stations
     * @todo faire la gestion des jours, jours féries et vacance
     * @todo tester la non insertion des dispos si pas de modifications pour eviter de surcharger la base inutilement
     */
    public void insertStationDonneesDynamiques(List<StationDisponibilites> stations) {
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

    private Map<String, Integer> getTousLesIdDesStationsParNom() {
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

    private Map<Integer, Timestamp> getToutesLesDatesDernieresModificationsParId() {
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


    /**
     * Methode pour executer les requetes qui NE modifient PAS la base de donnees (select, etc)
     *
     * @param requete
     * @return
     */
    private ResultSet executerRequete(String requete) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(requete);

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MysqlConnecter.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Erreur: " + ex);
        }
        return rs;
    }

    /**
     * Methode pour executer les requetes qui MODIFIENT la base de donnees (select, etc)
     *
     * @param requete
     * @return
     */
    private void executerRequeteInsertDeleteUpdate(String requete) {
        try {
            st = con.createStatement();
            st.executeUpdate(requete);

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MysqlConnecter.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Erreur: " + ex);
        }
    }


    public List<Integer> getVeloSurStation(int id_station, Date dateX, Date dateY) {

//		Obtenir un intervalle depuis une date.	
//		long offSet = 60000*5;	//5 minites in millisecs
//		long longJour = jour.getTime();
//		
//		Date jourX = new Date(longJour + (10 * offSet));
//		Date jourY = new Date(longJour + (10 * offSet));

        SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String sqlQuery = "SELECT places_occupees FROM velo_malin.stationsdisponibilites WHERE id_station='" + id_station + "' AND date_MAJ_JCDecaux BETWEEN '" +
                datetime.format(dateX) + "' AND '" + datetime.format(dateY) + "'";

        ResultSet rs = executerRequete(sqlQuery);
        int numberOfColumns;
        ArrayList<Integer> nbVeloList = new ArrayList<Integer>(); 
		try {
			numberOfColumns = rs.getMetaData().getColumnCount();
	        while (rs.next()) {              
	                int i = 1;
	                while(i <= numberOfColumns) {
	                    nbVeloList.add(Integer.parseInt(rs.getString(i++)));
	                }
	        }
		} catch (SQLException e) {
			// TODO Bloc catch g�n�r� automatiquement
			e.printStackTrace();
		}
        
//        double moyenne = -1;
//        try {
//            moyenne = Double.parseDouble(rs.getString("places_occupees"));
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return nbVeloList;

    }

    // String sqlQuery= "SELECT nom, adresse, latitude, longitude, places, places_occupees, places_disponibles FROM Stations INNER JOIN StationsDisponibilites
    // ON Stations.id_station = StationDisponibilites.id_station WHERE id_station="+ id_station;

    public int getIdUneStation(String nom_station) {

        int id_station = 0;
        String sqlQuery = "SELECT id_station FROM VELO_MALIN.STATIONS WHERE nom = '" + nom_station + "' ";


        try {
            ResultSet rs = executerRequete(sqlQuery);

        } catch (NumberFormatException e) {
            // TODO Bloc catch g�n�r� automatiquement
            e.printStackTrace();
        } /*catch (SQLException e) {
            // TODO Bloc catch g�n�r� automatiquement
            e.printStackTrace();
        }*/
        return id_station;
    }


    public boolean insertStationFavorite(Client client, Station station) {

        boolean result_insertion = false;

        String sqlQuery = " INSERT INTO VELO_MALIN.STATIONSFAVORITES (id_client, id_station) VALUES ( " + client.getId_client() + "," + station.getId_station() +
                ")";
        //si pb : mettre simple quote pour valeur variable

        executerRequeteInsertDeleteUpdate(sqlQuery);


        try {
            //traitement java pur

            //result_insertion = true;
        } catch (NumberFormatException e) {
            // TODO Bloc catch g�n�r� automatiquement
            e.printStackTrace();
        } /*catch (SQLException e) {
            // TODO Bloc catch g�n�r� automatiquement
			e.printStackTrace();
		}*/

        return result_insertion;
    }

    public boolean insertItineraireFavorit(Client client, Station station_depart, Station station_arrivee) {

        boolean result_insertion = false;

        String sqlQuery = "INSERT INTO VELO_MALIN.ITINERAIRESFAVORIS (id_client, id_station_depart, id_station_arrivee) VALUES ( " + client.getId_client() + ","
                + station_depart.getId_station() + "," + station_arrivee.getId_station() + ")";
        //si pb : mettre simple quote pour valeur variable

        executerRequeteInsertDeleteUpdate(sqlQuery);


        try {
            //traitement java pur

            //result_insertion = true;
        } catch (NumberFormatException e) {
            // TODO Bloc catch g�n�r� automatiquement
            e.printStackTrace();
        } /*catch (SQLException e) {
      // TODO Bloc catch g�n�r� automatiquement
			e.printStackTrace();
		} */

        return result_insertion;
    }
}
