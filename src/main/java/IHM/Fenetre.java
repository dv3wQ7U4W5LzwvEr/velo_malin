package IHM;

import database.MysqlConnecter;
import model.Client;
import model.Station;
import model.StationDisponibilites;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        * Itinéraire *
        \*----------*/
        FenetrePanel fenetrePanel = new FenetrePanel();
        panel1.add(fenetrePanel);



        //Test pour rï¿½cupï¿½rer valeurs Stations et Itinï¿½raires favoris (qui seront dan onglet "Rï¿½sultat de Recherches") ï¿½ insï¿½rer dans BDD






            /*----------*\
             * RÃ©sultats *
             \*----------*/
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

             but_station_favorite.addActionListener(new Ecouteur_station_favorie());

             //panResultats.add(lab_selection_station);


     		Station station_test;
     		Station station_test,station_test_2;
    		station_test = new Station();
    		//préparation pour enregistrement station dans favoris
            //int Id_station =  station_test.getId_station();
            //but_station_favorite.addActionListener(new Ecouteur_station_favorie(Id_station));  
    		
    		//StationDisponibilites station_test_calcul;
    		//station_test_calcul = new StationDisponibilites();			
    		//int moy = StatisquesStation.getMoyVeloStation(2863, dateXY.get(0), dateXY.get(1));

    		station_test.setId_station(2469);
    			Station s = it.next();   			

    		JLabel lab_res_id = new JLabel(String.valueOf(station_test.getId_station()));
 		    JLabel lab_res_nom = new JLabel(station_test.getNom());
 		    JLabel lab_res_adresse = new JLabel(station_test.getAdresse());
                JButton but_station_favorite = new JButton("Enregister la station dans vos favoris");
 		    /*JLabel lab_res_velovsdispos = new JLabel(String.valueOf(station_test.getPlaces()) );*/
                
 		   panResultats.add(lab_res_id);
 		    panResultats.add(lab_res_nom);
    			panResultats.add(lab_res_adresse);
    			but_station_favorite.addActionListener(new Ecouteur_station_favorie(station_actuelle.getId_station()));  
 		    //panResultats.add(lab_res_velovsdispos);
    			
    		}
    		               
             panel2.add(panResultats);





            //Résultat
            //Stat
            //Alerte

            fenetre.add(onglets);
            fenetre.setVisible(true);

    }

}

class Ecouteur_station_favorie implements ActionListener {
	private int id_station;
	
	public Ecouteur_station_favorie(int id_station) {
		// TODO Auto-generated constructor stub
    	this.id_station = id_station;
    public void actionPerformed(ActionEvent e){

	}

	public void actionPerformed(ActionEvent e){ 	
    	
		MysqlConnecter mysql;
		mysql = new MysqlConnecter();

		Client client_actuel;
		client_actuel = new Client();

		Station station_1;
		station_1 = new Station();

		//mysql.insertStationFavorite(client_actuel,station_1);
		
	    JOptionPane confirm;      
	    confirm = new JOptionPane();
	    ImageIcon img = new ImageIcon("images/cloud_alert.png");
	    confirm.showMessageDialog(null, "Station bien enregistrée dans vos favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);  
		
    	
    }
}



