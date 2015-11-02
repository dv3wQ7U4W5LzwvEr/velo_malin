package IHM;

import model.Station;

import javax.swing.*;
import java.awt.*;

/**
 * Created by QKFD7244 on 02/11/2015.
 */
public class ResultatPanel extends javax.swing.JPanel{

    /*Constructeur*/
    public ResultatPanel() {
        initResultat();
    }

    private void initResultat(){
        JPanel panResultats = new JPanel();

        GridLayout gl = new GridLayout(3,4);
        panResultats.setLayout(gl);


        panResultats.setBackground(Color.white);
        panResultats.setBorder(BorderFactory.createTitledBorder("Résultats de recherche"));

        JLabel lab_selection_station = new JLabel("Stations conseillées :");

        JLabel lab_station_nom = new JLabel("NOM");
        JLabel lab_station_adr = new JLabel("ADRESSE");
        JLabel lab_station_nbplace = new JLabel("NOMBRE PLACES VIDES DISPONIBLES");
        JLabel lab_station_nbvelovs = new JLabel("NOMBRE VELOVS DISPONIBLE");

        //but_station_favorite.addActionListener(new Ecouteur_station_favorie());

        //panResultats.add(lab_selection_station);


        Station station_test;
        //Station station_test,station_test_2;
        station_test = new Station();
        //préparation pour enregistrement station dans favoris
        //int Id_station =  station_test.getId_station();
        //but_station_favorite.addActionListener(new Ecouteur_station_favorie(Id_station));

        //StationDisponibilites station_test_calcul;
        //station_test_calcul = new StationDisponibilites();
        //int moy = StatisquesStation.getMoyVeloStation(2863, dateXY.get(0), dateXY.get(1));

        station_test.setId_station(2469);
        //Station s = it.next();

        JLabel lab_res_id = new JLabel(String.valueOf(station_test.getId_station()));
        JLabel lab_res_nom = new JLabel(station_test.getNom());
        JLabel lab_res_adresse = new JLabel(station_test.getAdresse());
        JButton but_station_favorite = new JButton("Enregister la station dans vos favoris");
 		    /*JLabel lab_res_velovsdispos = new JLabel(String.valueOf(station_test.getPlaces()) );*/

        panResultats.add(lab_res_id);
        panResultats.add(lab_res_nom);
        panResultats.add(lab_res_adresse);
        //but_station_favorite.addActionListener(new Ecouteur_station_favorie(station_actuelle.getId_station()));
        //panResultats.add(lab_res_velovsdispos);
    }
}
