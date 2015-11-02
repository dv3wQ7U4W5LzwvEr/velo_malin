package IHM;

import database.MysqlConnecter;
import model.Client;
import model.Station;

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

            onglets.setMinimumSize(new Dimension(300, 150));
            onglets.setBackground(Color.lightGray);

            JPanel panel0 = new JPanel();
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JPanel panel4 = new JPanel();

            ImageIcon icon0 = new ImageIcon("src/main/resources/img/home.png");
            ImageIcon icon1 = new ImageIcon("src/main/resources/img/velo.png");
            ImageIcon icon2 = new ImageIcon("src/main/resources/img/map.png");
            ImageIcon icon3 = new ImageIcon("src/main/resources/img/station.png");
            ImageIcon icon4 = new ImageIcon("src/main/resources/img/cloud.png");

            onglets.addTab("Accueil", icon0, panel0);
            onglets.addTab("Programmer son itinéraire", icon1, panel1);
            onglets.addTab("Résultats de recherche", icon2, panel2);
            onglets.addTab("Statistiques de station", icon3, panel3);
            onglets.addTab("Alertes", icon4, panel4);

        /*----------*\
        * Accueil    *
        \*----------*/
        AccueilPanel accueilPanel = new AccueilPanel();
        panel0.add(accueilPanel);

        /*----------*\
        * Itinéraire *
        \*----------*/
        ItinerairePanel itinerairePanel = new ItinerairePanel();
        panel1.add(itinerairePanel);

        /*----------*\
        * Résultats *
        \*----------*/
        ResultatPanel resultatPanel = new ResultatPanel();
        panel2.add(resultatPanel);

        /*----------*\
        * Station    *
        \*----------*/
        StationPanel stationPanel = new StationPanel();
        panel3.add(stationPanel);

        /*----------*\
        * Favori     *
        \*----------*/
        FavoriPanel favoriPanel = new FavoriPanel();
        panel4.add(favoriPanel);


        /*----------*\
        * Génération*
        \*----------*/
            fenetre.add(onglets);
            fenetre.setVisible(true);
    }
}

class Ecouteur_station_favorie implements ActionListener {
	private int id_station;
	
	public Ecouteur_station_favorie(int id_station) {
		// TODO Auto-generated constructor stub
    	this.id_station = id_station;
	}

	public void actionPerformed(ActionEvent e){ 	
    	
		
		MysqlConnecter mysql;
		mysql = new MysqlConnecter();

		Client client_actuel;
		client_actuel = new Client();

		mysql.insertStationFavorite(client_actuel,id_station);
		
	    JOptionPane confirm;      
	    confirm = new JOptionPane();
	    ImageIcon img = new ImageIcon("images/cloud_alert.png");
	    confirm.showMessageDialog(null, "Station bien enregistrée dans vos favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);  
		
	    //onglets.setSelectedIndex( int i); //pour basculer d'un onglet à un autre
    }
}


class Ecouteur_itineraire_favori implements ActionListener {
	private int id_station_arrivee;
	private int id_station_depart;
	
	public Ecouteur_itineraire_favori(int id_station_depart,int id_station_arrivee) {
		// TODO Auto-generated constructor stub
    	this.id_station_depart = id_station_depart;
    	this.id_station_arrivee = id_station_arrivee;
	}

	public void actionPerformed(ActionEvent e){ 	
    	
		MysqlConnecter mysql;
		mysql = new MysqlConnecter();
		
		Client client_actuel;
		client_actuel = new Client();		
		
		mysql.insertItineraireFavorit(client_actuel,id_station_depart,id_station_arrivee);
		
	    JOptionPane confirm;      
	    confirm = new JOptionPane();
	    ImageIcon img = new ImageIcon("images/cloud_alert.png");
	    confirm.showMessageDialog(null, "Itinéraire bien enregistré dans vos favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);  
		
    	
    }
}

