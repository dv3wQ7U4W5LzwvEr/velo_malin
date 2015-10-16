package database;


import model.Station;

import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by flauve on 2015-10-14.
 */
public class MysqlConnecter {

    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

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

    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MysqlConnecter.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }
    }

    // @todo ajouter le system de recupération d une station à partir de l adresse
    public void majInformationsStation(Station station){
        if (! station.getNom().equals(""))
        {
            String request = "INSERT INTO VELO_MALIN.STATIONS (nom, adresse, latitude, longitude, places) " +
                    "values ( '" + station.getNom() + "', '" + station.getAdresse() + "','" + station.getLatitude() + "', '" + station.getLongitude() + "', '" + station.getPlaces() + "')";
            try {
                PreparedStatement pstmt = con.prepareStatement(request);
                pstmt.execute();
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(MysqlConnecter.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
                System.out.println("Erreur lors l execution de la requete sur la station :");
                System.out.println(request);
            }
        }
    }

    // todo identifier station et maj de de la table avec cette valeur
    public void majUtilisationsStations(Station station) {
        try {
            st = con.createStatement();
            String request = "INSERT INTO VELO_MALIN.STATIONSDISPONIBILITE (id_stationdisponibilite, id_station, date_maj_attente," +
                    " place_occuppees, places_disponibles, date_maj_jcdecaux, jour_special, vacances_scolaires)" +
                    "values ( " +
                    "" + station.getNom() + "," + station.getAdresse() + "," + station.getLatitude() + ","
                    + station.getLongitude() + "," + station.getPlaces() + ")";
            st.executeUpdate(request);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MysqlConnecter.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(MysqlConnecter.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

    // String sqlQuery= "SELECT nom, adresse, latitude, longitude, places, places_occupees, places_disponibles FROM Stations INNER JOIN StationsDisponibilites ON Stations.id_station = StationDisponibilites.id_station WHERE id_station="+ id_station;
}
