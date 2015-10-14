package IHM;

import java.awt.*;
import javax.swing.*;

import was.WebService;
import was.model.StationWas;



public class Fenetre {
	public static void main(String[] args) { 
		
		   JFrame fenetre = new JFrame();
		   JPanel pan = new JPanel();
		   JTabbedPane onglets = new JTabbedPane();
		   String stations;
		   
		   JMenuBar menuBar = new JMenuBar();                
           JMenu menu1 = new JMenu("Programmer son itinéraire");
           JMenu menu2 = new JMenu("Voir les résultats");
           JMenu menu3 = new JMenu("Recherche de station");
           JMenu menu4 = new JMenu("Alertes");           
           
		    menuBar.add(menu1);
		    menuBar.add(menu2);
		    menuBar.add(menu3);
		    menuBar.add(menu4);
		    
		    JLabel label0 = new JLabel("Cliquer sur les boutons",JLabel.CENTER);
		    
		    
		    //titre liste station
		    //JLabel label1 = new JLabel("Toutes les stations",JLabel.CENTER);
		    
		    //JLabel liste_station = new JLabel();
		    //liste_station.setText(String Stations);
 
		    WebService webService = new WebService();
		    StationWas[] stat = webService.demo();
		    JPanel PanStation = new JPanel();
		    JLabel nom = new JLabel("Nom : " + stat[0].getName());
		    JLabel adresse = new JLabel("adresse : " + stat[0].getAddress());
		    JLabel dispo = new JLabel(String.valueOf(stat[0].getBike_stands()) + " vélos disponible");
		    PanStation.add(nom);
		    PanStation.add(adresse);
		    PanStation.add(dispo);
		 
		    
           onglets.setMinimumSize(new Dimension(200,100));
           onglets.setBackground(Color.gray);
		   
           
           JPanel panel0 = new JPanel();
           JPanel panel1 = new JPanel();
           JPanel panel2 = new JPanel();
           JPanel panel3 = new JPanel();
           JPanel panel4 = new JPanel();
           panel0.add(PanStation);
           // panel0.add(label0);
           
           onglets.addTab("Accueil", panel0);
           onglets.addTab("Programmer son itinéraire", panel1);
           onglets.addTab("Lancer une recherche", panel2);
           onglets.addTab("Recherche de station", panel3);
           onglets.addTab("Alertes", panel4);
           
           //onglets.setMnemonicAt(0, KeyEvent.VK_1);

		    fenetre.setTitle("Velo Malin");
		    fenetre.setSize(800, 400);
		    fenetre.setLocationRelativeTo(null);
		    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    	    
		    
		    
		    //pan.add(menuBar, BorderLayout.NORTH);
		    pan.setBackground(Color.RED);	    

		    fenetre.add(pan); 
		    fenetre.add(onglets);
		    fenetre.setVisible(true);
		    
		    
	 }

}