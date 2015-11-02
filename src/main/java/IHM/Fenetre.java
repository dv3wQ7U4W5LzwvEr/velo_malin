package IHM;

import javax.swing.*;

import database.MysqlConnecter;
import model.*;
import recherche.StatisquesStation;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.awt.event.*;


public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

            JFrame fenetre = new Fenetre();


            fenetre.setTitle("Velo Malin");
            fenetre.setSize(800, 800);
            fenetre.setLocationRelativeTo(null);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTabbedPane onglets = new JTabbedPane();

            //code test pour la demo
	/*	    WebService webService = new WebService();
		    StationWas[] stat = webService.demo();
		    JPanel PanStation = new JPanel();
		    JLabel nom = new JLabel("Nom : " + stat[0].getName());
		    JLabel adresse = new JLabel("adresse : " + stat[0].getAddress());
		    JLabel dispo = new JLabel(String.valueOf(stat[0].getBike_stands()) + " vélos disponible");
		    PanStation.add(nom);
		    PanStation.add(adresse);
		    PanStation.add(dispo);*/


            onglets.setMinimumSize(new Dimension(300, 150));
            onglets.setBackground(Color.lightGray);


            JPanel panAccueil = new JPanel();
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JPanel panel4 = new JPanel();

            ImageIcon icon0 = new ImageIcon("src/main/resources/img/home.png");
            ImageIcon icon1 = new ImageIcon("src/main/resources/img/velo.png");
            ImageIcon icon2 = new ImageIcon("src/main/resources/img/map.png");
            ImageIcon icon3 = new ImageIcon("src/main/resources/img/station.png");
            ImageIcon icon4 = new ImageIcon("src/main/resources/img/cloud.png");

            onglets.addTab("Accueil", icon0, panAccueil);
            onglets.addTab("Programmer son itinéraire", icon1, panel1);
            onglets.addTab("Résultats de recherche", icon2, panel2);
            onglets.addTab("Statistiques de station", icon3, panel3);
            onglets.addTab("Alertes", icon4, panel4);

        /*---------*\
        *  Accueil  * src/main/resources/img/image_velovs.jpg
        \*---------*/
            panAccueil.setBackground(Color.red);
            panAccueil.setLayout(new GridLayout(3, 1));

            //mise en forme

            JLabel nom = new JLabel("      Velo Malin");
            nom.setFont(new Font("Arial", Font.PLAIN, 50));
            nom.setForeground(Color.white);
            nom.setSize(500, 300);
            nom.setHorizontalTextPosition(JLabel.CENTER);
            nom.setVerticalTextPosition(JLabel.TOP);

            panAccueil.add(nom);

            ImageIcon icon5 = new ImageIcon("src/main/resources/img/image_velovs.jpg");
            JLabel label_image = new JLabel(icon5);
            label_image.setSize(200, 200);
            label_image.setVerticalTextPosition(JLabel.CENTER);
            label_image.setHorizontalTextPosition(JLabel.CENTER);

            panAccueil.add(label_image);

        /*----------*\
        * Itin�raire *
        \*----------*/
            JPanel panDepart = new JPanel();

            panDepart.setBackground(Color.white);
            //panDepart.setPreferredSize(new Dimension(500, 130));
            panDepart.setBorder(BorderFactory.createTitledBorder("Adresse de départ"));

            JLabel lab_rue = new JLabel("N° et rue:");
            JTextField adresse = new JTextField();
            adresse.setPreferredSize(new Dimension(120, 25));

            JLabel lab_cp = new JLabel("Code Postal:");
            JTextField cp = new JTextField();
            cp.setPreferredSize(new Dimension(60, 25));

            JLabel lab_ville = new JLabel("Ville: ");
            JTextField ville = new JTextField();
            ville.setText("");
            ville.setPreferredSize(new Dimension(120, 25));

            JComboBox comb_heure = new JComboBox();
            comb_heure.addItem("0");
            comb_heure.addItem("1");
            comb_heure.addItem("2");
            comb_heure.addItem("3");
            comb_heure.addItem("4");
            comb_heure.addItem("5");
            comb_heure.addItem("6");
            comb_heure.addItem("7");
            comb_heure.addItem("8");
            comb_heure.addItem("9");
            comb_heure.addItem("10");
            comb_heure.addItem("11");
            comb_heure.addItem("12");
            comb_heure.addItem("13");
            comb_heure.addItem("14");
            comb_heure.addItem("15");
            comb_heure.addItem("16");
            comb_heure.addItem("17");
            comb_heure.addItem("18");
            comb_heure.addItem("19");
            comb_heure.addItem("20");
            comb_heure.addItem("21");
            comb_heure.addItem("22");
            comb_heure.addItem("23");
            JLabel lab_heure = new JLabel("h");
            JComboBox comb_min = new JComboBox();
            comb_min.addItem("00");
            comb_min.addItem("15");
            comb_min.addItem("30");
            comb_min.addItem("45");
            JLabel lab_min = new JLabel("min");

            JCheckBox comb_jour = new JCheckBox();


            panDepart.add(lab_rue);
            panDepart.add(adresse);
            panDepart.add(lab_cp);
            panDepart.add(cp);
            panDepart.add(lab_ville);
            panDepart.add(ville);
            panDepart.add(comb_heure);
            panDepart.add(lab_heure);
            panDepart.add(comb_min);
            panDepart.add(lab_min);

            panel1.add(panDepart);


        //Ajout Tof pour test en lien avec requetes SQL
        //Résultat de recherches
        //Test pour r�cup�rer valeurs Stations et Itin�raires favoris (qui seront dan onglet "R�sultat de Recherches") � ins�rer dans BDD  
        /*
         * 
        JPanel panResultats = new JPanel();

        panResultats.setBackground(Color.white);

        
        int id_station;
        Station station_init = new Station();
        station_init.getId_station();
        
        String nom_station;
        nom_station = station_init.getNom();
        
        JLabel lab_station_favorite = new JLabel(nom_station);
        
        panResultats.add(lab_station_favorite);

        
        panel2.add(panResultats);
        
        */

            /*----------*\
             * Résultats *
             \*----------*/
             JPanel panResultats = new JPanel();
             
             GridLayout gl = new GridLayout(1,5); //3 : nombre de ligne / 5 : nombre de colonnes
             panResultats.setLayout(gl);
             
             
             panResultats.setBackground(Color.white);
             //panResultats.setPreferredSize(new Dimension(1000, 250));
             panResultats.setBorder(BorderFactory.createTitledBorder("Résultats de recherche"));

             JLabel lab_selection_station = new JLabel("Stations conseillées :");
             
             JLabel lab_station_nom = new JLabel("NOM");
             JLabel lab_station_adr = new JLabel("ADRESSE");
             JLabel lab_station_nbplace = new JLabel("NOMBRE PLACES VIDES DISPONIBLES");
             JLabel lab_station_nbvelovs = new JLabel("NOMBRE VELOVS DISPONIBLE");
             JButton but_station_favorite = new JButton("Enregister la station dans vos favoris");
             
             but_station_favorite.addActionListener(new Ecouteur_station_favorie());
             
             //panResultats.add(lab_selection_station);    
             /*
             panResultats.add(lab_station_nom);
             panResultats.add(lab_station_adr);
             panResultats.add(lab_station_nbplace);
             panResultats.add(lab_station_nbvelovs);
             panResultats.add(but_station_favorite);
             */
             
             //panResultats.add(lab_selection_station);
                         
     		Station station_test;
    		station_test = new Station();
    		
    		StationDisponibilites station_test_calcul;
    		station_test_calcul = new StationDisponibilites();
    		  		
    		//List<Integer> getVeloSurStation(int id_station, Date dateX, Date dateY);
    		//List<Date> dateXY = StatisquesStation.calculInterval(date, 5);
    		//int moy = StatisquesStation.getMoyVeloStation(2863, dateXY.get(0), dateXY.get(1));
    		
    		station_test.setId_station(2469);
             
    		JLabel lab_res_id = new JLabel(String.valueOf(station_test.getId_station()));
 		    JLabel lab_res_nom = new JLabel(station_test.getNom());
 		    JLabel lab_res_adresse = new JLabel(station_test.getAdresse());
 		    //JLabel lab_res_placesdispos = new JLabel(String.valueOf(station_test_calcul.getPlaces()));
 		    /*JLabel lab_res_velovsdispos = new JLabel(String.valueOf(station_test.getPlaces()) );*/
 		   
 		   panResultats.add(lab_res_id);
 		    panResultats.add(lab_res_nom);
 		    panResultats.add(lab_res_adresse);
 		    //panResultats.add(lab_res_placesdispos);
 		    //panResultats.add(lab_res_velovsdispos);
             
             
             

             
             panel2.add(panResultats);
        
         
        
        
        
            //Résultat
            //Stat
            //Alerte

            fenetre.add(onglets);
            fenetre.setVisible(true);

    }

}

class Ecouteur_station_favorie implements ActionListener {
    public void actionPerformed(ActionEvent e){ 	
    	
		MysqlConnecter mysql;
		mysql = new MysqlConnecter();
		
		Client client_actuel;
		client_actuel = new Client();
		
		Station station_1;
		station_1 = new Station();
		
		mysql.insertStationFavorite(client_actuel,station_1);
		

		
    	
    }
}



