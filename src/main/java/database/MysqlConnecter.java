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

    public void majStation(Station station) {
        try {
            st = con.createStatement();
            Random rand = new Random();
            int max = 99999;
            int min = 1;
            int nombreAleatoire = rand.nextInt(max - min + 1) + min;
            String request = "INSERT INTO STATIONS (id_station, nom, adresse, latitude, longitude, places) " +
                     "values ( " + nombreAleatoire + "," + station.getNom() + "," + station.getAdresse() + "," + station.getLatitude() + "," + station.getLongitude() + "," + station.getPlaces() + ")";
            rs = st.executeQuery(request);
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
}
