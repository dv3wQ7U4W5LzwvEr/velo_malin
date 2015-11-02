package IHM;

import model.Station;
import database.MysqlConnecter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by QKFD7244 on 02/11/2015.
 */
public class ResultatPanel extends javax.swing.JPanel{

    /*Constructeur*/
    public ResultatPanel() {
        initResultat();
    }

    private void initResultat(){
         
        GridLayout gl = new GridLayout(3,4); 
        setLayout(gl);
               
        setBackground(Color.white);
        setBorder(BorderFactory.createTitledBorder("Résultats de recherche"));

        JLabel lab_selection_station = new JLabel("Stations conseillées :");
        
        JLabel lab_station_nom = new JLabel("NOM");
        JLabel lab_station_adr = new JLabel("ADRESSE");
        JLabel lab_station_nbplace = new JLabel("NOMBRE PLACES VIDES DISPONIBLES");
        JLabel lab_station_nbvelovs = new JLabel("NOMBRE VELOVS DISPONIBLE");
                    
		MysqlConnecter mysql;
		mysql = new MysqlConnecter(); 
        
		Station station_test,station_test_2;
		station_test = new Station();
		station_test_2 = new Station();

		station_test.setId_station(2469);
		station_test_2.setId_station(2470);
		
		//préparation pour enregistrement station dans favoris
       //int Id_station =  station_test.getId_station();
       //but_station_favorite.addActionListener(new Ecouteur_station_favorie(Id_station));  
		
		//StationDisponibilites station_test_calcul;
		//station_test_calcul = new StationDisponibilites();			
		  		
		List<Station> données_statiques_stations = new ArrayList<Station>();
		données_statiques_stations.add(station_test);
		données_statiques_stations.add(station_test_2);
		
		/*
		List<Station> données_dynamiques_stations = new ArrayList<Station>();
		données_dynamiques_stations.add(station_test);
		données_dynamiques_stations.add(station_test_2);
		*/

				
		Iterator<Station> it = données_statiques_stations.iterator();

		while (it.hasNext()) { 			
			Station s = it.next();   			
			Station station_actuelle = mysql.getStation(s.getId_station());
			
			JLabel lab_res_id = new JLabel(String.valueOf(station_actuelle.getId_station()) + " "); 
			JLabel lab_res_nom = new JLabel(station_actuelle.getNom() + " "); 
			JLabel lab_res_adresse = new JLabel(station_actuelle.getAdresse() + " "); 
           JButton but_station_favorite = new JButton("Enregister la station dans vos favoris");
           
			add(lab_res_id);    		
			add(lab_res_nom);    	
			add(lab_res_adresse);
			but_station_favorite.addActionListener(new Ecouteur_station_favorie(station_actuelle.getId_station()));  
			add(but_station_favorite);
			
		}
    }
}
