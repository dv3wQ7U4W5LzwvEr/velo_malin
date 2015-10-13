package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by florian on 2015-10-10.
 */

public class MysqlVersion {
	
	 public static Connection getConnection() throws Exception {
		    // load the Oracle JDBC Driver
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    // define database connection parameters
		    return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:database", "userName",
		        "password");
		 }
	
    public static void main(String[] args) throws SQLException {      
    	
    	Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/velo_malin";
        String user = "root";
        String password = "";
        
        Class.forName(driver);

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MysqlVersion.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

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
                Logger lgr = Logger.getLogger(MysqlVersion.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

}
