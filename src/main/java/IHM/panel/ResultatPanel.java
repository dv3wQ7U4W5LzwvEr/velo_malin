package IHM.panel;

import IHM.listeners.EcouteurItineraireFavori;
import IHM.listeners.EcouteurStationFavorite;
import database.MysqlRequester;
import model.*;
import database.MysqlConnecter;
import recherche.StatistiquesStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.*;


/**
 * Created by QKFD7244 on 02/11/2015.
 */
public class ResultatPanel extends javax.swing.JPanel {

    /*Constructeur*/
    public ResultatPanel() {
        initResultat();
    }

    private void initResultat() {

    	
        GridLayout gl = new GridLayout(3, 5);
        setLayout(gl);
        

    	/*
        setBackground(Color.white);
        setBorder(BorderFactory.createTitledBorder("R�sultats de recherche"));
		*/
        
        
        
    	
    	
    	//A garder : Tof!----------------------------
        MysqlConnecter mysql;
        mysql = new MysqlConnecter();
        
        //pour test (en attente lien avec IHM)
        Station station_test = new Station();
        station_test.setId_station(2473);
        
        /*
        Station station_liste = new Station();
        Station station_liste2 = new Station();
        Station station_liste3 = new Station();
        
        station_liste.setId_station(2469);
        station_liste2.setId_station(2474);
        station_liste3.setId_station(2470);    
        */
        Station station_recherchee = MysqlRequester.getStation(station_test.getId_station());
        
        List<Station> liste_stations_proximites = new ArrayList<Station>();      
        liste_stations_proximites = MysqlRequester.getStationsProximitees(Double.parseDouble(station_recherchee.getLatitude()), Double.parseDouble(station_recherchee.getLongitude()), 20, 500);
        /*
        liste_stations_proximites.add(station_liste);
        liste_stations_proximites.add(station_liste2);
        liste_stations_proximites.add(station_liste3);
        */
        
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 10-1, 28, 13, 00, 00);
		Date dateX = cal.getTime();
		cal.set(2015, 10-1, 28, 13, 05, 00);
		Date dateY = cal.getTime();

        Iterator<Station> it = liste_stations_proximites.iterator();

        while (it.hasNext()) {
            Station s = it.next();
            Station station_actuelle = MysqlRequester.getStation(s.getId_station());
            
            int nbvelos = StatistiquesStation.getMoyVeloStation(station_actuelle.getId_station(), dateX, dateY);
            int nbplaces = StatistiquesStation.getMoyPlaceStation(station_actuelle.getId_station(), dateX, dateY);

            JLabel lab_res_id = new JLabel(String.valueOf(station_actuelle.getId_station()) + " ");
            JLabel lab_res_nom = new JLabel(station_actuelle.getNom() + " ");
            JLabel lab_res_adresse = new JLabel(station_actuelle.getAdresse() + " ");
            JLabel lab_res_nbplace = new JLabel(nbplaces + " ");
            JLabel lab_res_nbvelovs = new JLabel(nbvelos + " ");

            //JButton but_station_favorite = new JButton("Enregister la station dans vos favoris");

            add(lab_res_id);
            add(lab_res_nom);
            add(lab_res_adresse);
            add(lab_res_nbplace);
            add(lab_res_nbvelovs);

            //but_station_favorite.addActionListener(new EcouteurStationFavorite(station_actuelle.getId_station()));
            //add(but_station_favorite);
        }

        //preparation bouton pour enregistrement itineraire favori
        //JButton but_itineraire_favori = new JButton("Enregister l' itineraire dans vos favoris");
        //but_itineraire_favori.addActionListener(new EcouteurItineraireFavori(station_test.getId_station(), station_test_2.getId_station()));
        //add(but_itineraire_favori);
        
        
        
    }
}
