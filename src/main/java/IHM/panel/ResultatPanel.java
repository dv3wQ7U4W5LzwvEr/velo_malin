package IHM.panel;

import IHM.listeners.EcouteurItineraireFavori;
import IHM.listeners.EcouteurStationFavorite;
import database.MysqlRequester;
import model.*;
import database.MysqlConnecter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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

        setBackground(Color.white);
        setBorder(BorderFactory.createTitledBorder("R�sultats de recherche"));
        
        /*
        JLabel lab_station_nom = new JLabel("NOM");
        JLabel lab_station_adr = new JLabel("ADRESSE");
        JLabel lab_station_nbplace = new JLabel("NOMBRE PLACES VIDES DISPONIBLES");
        JLabel lab_station_nbvelovs = new JLabel("NOMBRE VELOVS DISPONIBLE");
        */

        MysqlConnecter mysql;
        mysql = new MysqlConnecter();

        Station station_test, station_test_2;
        station_test = new Station();
        station_test_2 = new Station();

        station_test.setId_station(2469);
        station_test_2.setId_station(2470);

        //StationDisponibilites station_test_calcul;
        //station_test_calcul = new StationDisponibilites();

        List<Station> donnees_statiques_stations = new ArrayList<Station>();
        donnees_statiques_stations.add(station_test);
        donnees_statiques_stations.add(station_test_2);


        List<StationDisponibilites> donnees_dynamiques_stations = new ArrayList<StationDisponibilites>();
        //donn�es_dynamiques_stations.add(station_test);
        //donn�es_dynamiques_stations.add(station_test_2);


        //test pour r�sultat de recherche : stations � proximit�s
        List<Integer> liste_stations_proximites = new ArrayList<Integer>();
        Station station_recherchee = MysqlRequester.getStation(station_test.getId_station());
        liste_stations_proximites = MysqlRequester.getStationsProximite(Double.parseDouble(station_recherchee.getLatitude()), Double.parseDouble(station_recherchee.getLongitude()), 10, 100);

		Calendar cal = Calendar.getInstance();
		cal.set(2015, 10-1, 28, 13, 00, 00);
		Date dateX = cal.getTime();
		cal.set(2015, 10-1, 28, 13, 00, 30);
		Date dateY = cal.getTime();


        for (int i = 0; i < liste_stations_proximites.size(); i++) {
            //List<Integer> nb_place;
            //nb_place = MysqlConnecter.getPlaceSurStation(liste_stations_proximites.get(i),dateX,dateY);

        }


        //mettre liste de stations r�cup�r�es getId dans liste Station

        Iterator<Station> it = donnees_statiques_stations.iterator();

        while (it.hasNext()) {
            Station s = it.next();
            Station station_actuelle = MysqlRequester.getStation(s.getId_station());

            JLabel lab_res_id = new JLabel(String.valueOf(station_actuelle.getId_station()) + " ");
            JLabel lab_res_nom = new JLabel(station_actuelle.getNom() + " ");
            JLabel lab_res_adresse = new JLabel(station_actuelle.getAdresse() + " ");
            JLabel lab_res_nbplace = new JLabel(dateX + " " + dateY);
            //JLabel lab_res_nbvelovs = new JLabel( + " ");

            JButton but_station_favorite = new JButton("Enregister la station dans vos favoris");

            add(lab_res_id);
            add(lab_res_nom);
            add(lab_res_adresse);
            add(lab_res_nbplace);
            //add(lab_res_nbvelovs);

            but_station_favorite.addActionListener(new EcouteurStationFavorite(station_actuelle.getId_station()));
            add(but_station_favorite);
        }

        //preparation bouton pour enregistrement itineraire favori
        JButton but_itineraire_favori = new JButton("Enregister l' itineraire dans vos favoris");
        but_itineraire_favori.addActionListener(new EcouteurItineraireFavori(station_test.getId_station(), station_test_2.getId_station()));
        add(but_itineraire_favori);
    }
}
