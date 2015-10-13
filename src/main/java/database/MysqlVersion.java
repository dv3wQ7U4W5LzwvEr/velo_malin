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
	
	
    public static void main(String[] args) throws Exception {      
    	
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
            rs = st.executeQuery("SELECT * FROM Client");

          //On récupère les MetaData
          // ResultSetMetaData resultMeta = result.getMetaData();
         
         //On affiche le nom des colonnes
         //   for(int i = 1; i <= resultMeta.getColumnCount(); i++){
         //    System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");}
            
         /*   
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
        */
            
            
            while(rs.next()){         
                for(int i = 1; i < 2; i++){
                  System.out.print("\t" + rs.getObject(i).toString() + "\t");
                  System.out.println("\n---------------------------------");
                }

                        
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