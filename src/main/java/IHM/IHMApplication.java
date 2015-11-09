package IHM;

import IHM.panel.*;

import javax.swing.*;
import java.awt.*;


public class IHMApplication extends JFrame {

     private static final long serialVersionUID = 1L;

     private static JPanel panel0 = new JPanel();
     private static JPanel panel1 = new JPanel();
     private static JPanel panel2 = new JPanel();
     private static JPanel panel3 = new JPanel();
     private static JPanel panel4 = new JPanel();


    public static void main(String[] args) {

            JFrame fenetre = new IHMApplication();

            fenetre.setTitle("Velo Malin");
            fenetre.setSize(850, 850);
            fenetre.setLocationRelativeTo(null);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane onglets =  new JTabbedPane();

            onglets.getAccessibleContext();
            onglets.setMinimumSize(new Dimension(300, 150));
            onglets.setBackground(Color.lightGray);

            panel0 = new JPanel();
            panel1 = new JPanel();
            panel2 = new JPanel();
            panel3 = new JPanel();
            panel4 = new JPanel();

            ImageIcon icon0 = new ImageIcon("src/main/resources/img/home.png");
            ImageIcon icon1 = new ImageIcon("src/main/resources/img/velo.png");
            ImageIcon icon2 = new ImageIcon("src/main/resources/img/map.png");
            ImageIcon icon3 = new ImageIcon("src/main/resources/img/station.png");
            ImageIcon icon4 = new ImageIcon("src/main/resources/img/cloud.png");

            onglets.addTab("Accueil", icon0, panel0);
            onglets.addTab("Programmer son itin�aire", icon1, panel1);
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
    
    public static void reloadResultatPanel(){
    	ResultatPanel resultatPanel = new ResultatPanel();
    	panel2.removeAll();
    	panel2.add(resultatPanel);
    	panel2.revalidate();
    	panel2.repaint();
    }
    
    public static void reloadFavoriPanel(){
    	FavoriPanel favoriPanel = new FavoriPanel();
    	panel4.removeAll();
    	panel4.add(favoriPanel);
    	panel4.revalidate();
    	panel4.repaint();
    }
}



