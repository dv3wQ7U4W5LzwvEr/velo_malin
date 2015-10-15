package IHM;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.imageio.ImageIO;
import javax.swing.*;

import was.WebService;
import was.model.StationWas;



public class Fenetre {
	public static void main(String[] args) {
		JFrame fenetre = new JFrame();

		fenetre.setTitle("Velo Malin");
		fenetre.setSize(800, 400);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane onglets = new JTabbedPane();

		//code test pour la demo
	/*	    WebService webService = new WebService();
		    StationWas[] stat = webService.demo();
		    JPanel PanStation = new JPanel();
		    JLabel nom = new JLabel("Nom : " + stat[0].getName());
		    JLabel adresse = new JLabel("adresse : " + stat[0].getAddress());
		    JLabel dispo = new JLabel(String.valueOf(stat[0].getBike_stands()) + " v�los disponible");
		    PanStation.add(nom);
		    PanStation.add(adresse);
		    PanStation.add(dispo);*/


		onglets.setMinimumSize(new Dimension(300,150));
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

		onglets.addTab("Accueil",icon0,panAccueil);
		onglets.addTab("Programmer son itin�raire",icon1, panel1);
		onglets.addTab("R�sultats de recherche",icon2, panel2);
		onglets.addTab("Statistiques de station",icon3, panel3);
		onglets.addTab("Alertes",icon4, panel4);

        //Accueil
        panAccueil.setBackground(Color.red);

        //Itin�raire
        JPanel panDepart = new JPanel();

        panDepart.setBackground(Color.white);
        //panDepart.setPreferredSize(new Dimension(500, 130));
        panDepart.setBorder(BorderFactory.createTitledBorder("Adresse de d�part"));

        JLabel lab_rue = new JLabel("N� et rue:");
        JTextField adresse = new JTextField();
        adresse.setPreferredSize(new Dimension(120, 25));

        JLabel lab_cp = new JLabel("Code Postal:");
        JTextField cp = new JTextField();
        cp.setPreferredSize(new Dimension(60, 25));

        JLabel lab_ville = new JLabel("Ville: ");
        JTextField ville = new JTextField();
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


        //R�sultat
        //Stat
        //Alerte

		fenetre.add(onglets);
		fenetre.setVisible(true);


	}

}