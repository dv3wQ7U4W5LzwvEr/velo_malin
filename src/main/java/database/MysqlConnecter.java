package database;

import was.model.Station;

import java.sql.*;
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

    private void MysqlConnecter() {
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

    public void connect() {
        MysqlConnecter();
    }

    public void insertStationStatistique(Station station) {

    }
}
