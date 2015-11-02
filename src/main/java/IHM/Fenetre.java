package IHM;

import database.MysqlConnecter;
import model.Client;
import model.Station;
import model.StationDisponibilites;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


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
		    JLabel dispo = new JLabel(String.valueOf(stat[0].getBike_stands()) + " vÃ©los disponible");
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
            onglets.addTab("Programmer son itinÃ©raire", icon1, panel1);
            onglets.addTab("RÃ©sultats de recherche", icon2, panel2);
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
        * Itinï¿½raire *
        \*----------*/
            JPanel panDepart = new JPanel();

            panDepart.setBackground(Color.white);
            //panDepart.setPreferredSize(new Dimension(500, 130));
            panDepart.setBorder(BorderFactory.createTitledBorder("Adresse de dÃ©part"));

            JLabel lab_rue = new JLabel("NÂ° et rue:");
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
        //RÃ©sultat de recherches
        //Test pour rï¿½cupï¿½rer valeurs Stations et Itinï¿½raires favoris (qui seront dan onglet "Rï¿½sultat de Recherches") ï¿½ insï¿½rer dans BDD  
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
             * RÃ©sultats *
             \*----------*/
             JPanel panResultats = new JPanel();
             
             GridLayout gl = new GridLayout(1,5); //3 : nombre de ligne / 5 : nombre de colonnes
             panResultats.setLayout(gl);
             
             
             panResultats.setBackground(Color.white);
             //panResultats.setPreferredSize(new Dimension(1000, 250));
             panResultats.setBorder(BorderFactory.createTitledBorder("RÃ©sultats de recherche"));

             JLabel lab_selection_station = new JLabel("Stations conseillÃ©es :");
             
             JLabel lab_station_nom = new JLabel("NOM");
             JLabel lab_station_adr = new JLabel("ADRESSE");
             JLabel lab_station_nbplace = new JLabel("NOMBRE PLACES VIDES DISPONIBLES");
             JLabel lab_station_nbvelovs = new JLabel("NOMBRE VELOVS DISPONIBLE");
             JButton but_station_favorite = new JButton("Enregister la station dans vos favoris");
             
             //panResultats.add(lab_selection_station);    
             /*
             panResultats.add(lab_station_nom);
             panResultats.add(lab_station_adr);
             panResultats.add(lab_station_nbplace);
             panResultats.add(lab_station_nbvelovs);
             panResultats.add(but_station_favorite);
             */
             panResultats.add(but_station_favorite);
             
             //panResultats.add(lab_selection_station);
                         
     		Station station_test,station_test_2;
    		station_test = new Station();
    		station_test_2 = new Station();

    		station_test.setId_station(2469);
    		station_test_2.setId_station(2500);
    		
            int Id_station =  station_test.getId_station();
            but_station_favorite.addActionListener(new Ecouteur_station_favorie(Id_station));
       
    		
    		StationDisponibilites station_test_calcul;
    		station_test_calcul = new StationDisponibilites();
    			
    		  		
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
    			JLabel lab_res_id = new JLabel(String.valueOf(s.getId_station()) + " "); 
    			panResultats.add(lab_res_id);    			
    			//s.getAdresse();
    		}
    		       
    		
    		
    		
             
    		//JLabel lab_res_id = new JLabel(String.valueOf(station_test.getId_station()));
 		    JLabel lab_res_nom = new JLabel(station_test.getNom());
 		    JLabel lab_res_adresse = new JLabel(station_test.getAdresse());
 		    //JLabel lab_res_placesdispos = new JLabel(String.valueOf(station_test_calcul.getPlaces()));
 		    /*JLabel lab_res_velovsdispos = new JLabel(String.valueOf(station_test.getPlaces()) );*/
 		   
 		    //panResultats.add(lab_res_id);
 		    panResultats.add(lab_res_nom);
 		    panResultats.add(lab_res_adresse);
 		    //panResultats.add(lab_res_placesdispos);
 		    //panResultats.add(lab_res_velovsdispos);
             
             
             

             
             panel2.add(panResultats);
        
         
        
        
        
            //RÃ©sultat
            //Stat
            //Alerte

            fenetre.add(onglets);
            fenetre.setVisible(true);

    }

}

class Ecouteur_station_favorie implements ActionListener {
    public Ecouteur_station_favorie(int id_station) {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e){ 	
    	
		MysqlConnecter mysql;
		mysql = new MysqlConnecter();
		
		Client client_actuel;
		client_actuel = new Client();
		int id;
		
		
		//mysql.insertStationFavorite(client_actuel,id_station);
		

		
    	
    }
}



