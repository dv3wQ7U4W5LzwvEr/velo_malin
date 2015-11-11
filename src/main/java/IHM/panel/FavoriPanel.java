package IHM.panel;

import IHM.IHMApplication;
import data.RechercheData;
import database.MysqlRequester;
import recherche.StatistiquesStation;
import was.google_map_api.GoogleMapApi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by QKFD7244 on 02/11/2015.
 */
public class FavoriPanel extends JPanel {
    /*Constructeur*/
    public FavoriPanel() {
        initFavori();
    }

    /*Variables*/
    private int temps_avant_alerte = 2;//setter et getter disponibles...


    /*Méthode*/
    private void initFavori() {
        // panel pour alertes

        /*
        panelAlerte = new javax.swing.JPanel();
        panelAlerte.setBackground(new java.awt.Color(255, 255, 255));
        panelAlerte.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "ALERTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N
        */

        // panel pour favoris

        JPanel panelFavoris = new JPanel();
        panelFavoris.setBackground(new java.awt.Color(255, 255, 255));
        panelFavoris.setLayout(new BorderLayout());
        JButton boutonSupprimer = new JButton();

        Map<Double, List<Double>> listFavoris = MysqlRequester.getListeItinerairesFavoris();
        if (listFavoris != null) {
            int nombreDeFavoris = listFavoris.size();
            if (nombreDeFavoris != 0) {
                JPanel f;
                JLabel labelDepart = new JLabel();
                JLabel labelArrivee = new JLabel();
                JLabel labelDateTrajet = new JLabel();
                for (Double cle : listFavoris.keySet()) {
                    // recuperation latitude longitude
                    String long_depart = String.valueOf(listFavoris.get(cle).get(0));
                    String lat_depart = String.valueOf(listFavoris.get(cle).get(1));
                    String long_arrivee = String.valueOf(listFavoris.get(cle).get(2));
                    String lat_arrivee = String.valueOf(listFavoris.get(cle).get(3));

                    String adresse_depart = GoogleMapApi.rechercherAdresseParLatLong(Double.parseDouble(long_depart), Double.parseDouble(lat_depart));
                    String adresse_arrivee = GoogleMapApi.rechercherAdresseParLatLong(Double.parseDouble(long_arrivee), Double.parseDouble(lat_arrivee));

                    // création des labels
                    f = new JPanel();

                    labelDepart = new JLabel();
                    labelDepart.setFont(new Font("Tahoma", 1, 14));
                    labelDepart.setText(adresse_depart);
                    labelDepart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    f.add(labelDepart);

                    labelArrivee = new JLabel();
                    labelArrivee.setFont(new Font("Tahoma", 1, 14));
                    labelArrivee.setText(adresse_arrivee);
                    labelArrivee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    f.add(labelArrivee);

                    labelDateTrajet = new JLabel();
                    labelDateTrajet.setFont(new Font("Tahoma", 1, 14));
                    labelDateTrajet.setText("cccccccccccccccc");
                    labelDateTrajet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    f.add(labelDateTrajet);

                    boutonSupprimer.setBackground(new Color(255, 0, 0));
                    boutonSupprimer.setFont(new Font("Tahoma", 0, 14)); // NOI18N
                    boutonSupprimer.setIcon(new ImageIcon("src/main/resources/img/cross_small.png")); // NOI18N
                    boutonSupprimer.setText("Supprimer");
                    boutonSupprimer.setContentAreaFilled(false);
                    boutonSupprimer.setOpaque(true);
                    boutonSupprimer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            MysqlRequester.getSupprimerItinerairesFavoris(lat_depart, long_depart, lat_arrivee, long_arrivee);
                            IHMApplication.reloadFavoriPanel();
                        }
                    });
                    f.add(boutonSupprimer);
                    panelFavoris.add(f);
                }
            }
        }


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(IHMApplication.panel4);
        IHMApplication.panel4.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelFavoris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelFavoris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(265, Short.MAX_VALUE))
        );


        /*
        /* Récupération liste des Alertes dans la table Alertes
        Map<Integer, Date> liste_alertes = new LinkedHashMap<>();
	    if(liste_alertes != null){
	    	Iterator<Integer> itr = liste_alertes.keySet().iterator();

	    	while (itr.hasNext()) {
	        	Object cle  = itr.next();
	        	Object valeur = liste_alertes.get(cle);

	        	Date date_alerte = (Date) valeur;
	        	int id_itineraire_favori = (int) cle;
	    	}
	    }


	    //Test pour date
    	Calendar cal_dep = Calendar.getInstance();
    	Calendar cal_test = Calendar.getInstance();
    	Date date_actuelle = cal_dep.getTime();
    	cal_test.set(2015, 10-1, 28, 14, 00, 00);
    	Date date_test =  cal_test.getTime();
    	//soustraction des 2 dates
    	//int tempsRestant = date_actuelle-date_test;

        /*Timer d'Alerte
        List<Integer> infoAllNext =  MysqlRequester.getTimeNextAlert(); //on recup une liste triée
        if(infoAllNext == null){
            //on ne fait rien s'il n'y a pas d'alerte prévue
        }else{
            int id_favori_next_alerte = infoAllNext.get(0);
            int tempsRestant = (infoAllNext.get(1)-(temps_avant_alerte*60000));//difference de temps en mili
            ActionListener actionListener = actionEvent-> actionAlerte(id_favori_next_alerte);
            //test:JOptionPane.showMessageDialog(null,"alerte dans :"+tempsRestant+" ms, id:"+infoAllNext.get(0));
        while(iter.hasNext()){
    	        Object cle  = iter.next();
    	      	Object valeur = infoAllNext.get(cle);
    	   
    	        temps_mili = (int) valeur;
    	        id_itineraire_favori = (int) cle;  	    	
    	 } 

        //int cle  = iter.next();
      	//int valeur = infoAllNext.get(cle);
      	
        //int tempsRestant = iter.next();
        //int id_itineraire_favori = infoAllNext.get(tempsRestant);
            javax.swing.Timer timer = new javax.swing.Timer(tempsRestant, actionListener);
            timer.start();
            timer.setRepeats(false);
        }

        /**/

        //Suppression Alerte pass�e dans BDD
        //_deleteAlerte(Heure,id_itineraire_favori);
         


        /*
        javax.swing.GroupLayout panelFavorisLayout = new javax.swing.GroupLayout(panelFavoris);
        panelFavoris.setLayout(panelFavorisLayout);
        panelFavorisLayout.setHorizontalGroup(
                panelFavorisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFavorisLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelDepart, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelVelo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelArrivee, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(labelDateTrajet, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boutonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        panelFavorisLayout.setVerticalGroup(
                panelFavorisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFavorisLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelFavorisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelDepart)
                                        .addComponent(labelArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelVelo)
                                        .addComponent(labelDateTrajet, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(boutonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        /*
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(IHMApplication.panel4);
        IHMApplication.panel4.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelFavoris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelFavoris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(265, Short.MAX_VALUE))
        );
            */
    }


    /*Listeneur*/
    private void boutonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void actionAlerte(int id_itinerairefavori) {

        JOptionPane.showMessageDialog(null, "C'est bientôt l'heure de votre trajet\nVous allez être redirigé vers les résultats correspondants.");
        //recup les coord
        List<Double> coord_next_trajet = MysqlRequester.getCoordDunItineraireFavori(id_itinerairefavori);//recup des infos du trajet
        double long_dep = coord_next_trajet.get(0);
        double lat_dep = coord_next_trajet.get(1);
        double long_arr = coord_next_trajet.get(2);
        double lat_arr = coord_next_trajet.get(3);
        //Heure de départ (heure actuelle)
        Calendar dateHeureDep = Calendar.getInstance();
        dateHeureDep.setTime(new Date());
        dateHeureDep.add(Calendar.MINUTE, temps_avant_alerte);//correspond au temps d'anticipation de l'alerte
        //Calcul heure d'arrivée
        Calendar dateHeureArr = dateHeureDep;
        dateHeureArr.add(Calendar.MINUTE, (int) StatistiquesStation.getTempsDeTrajet(lat_dep, long_dep, lat_arr, long_arr));
        RechercheData rechercheDonnees = RechercheData.getInstance();
        //Transmission adresse (lat/long)
        rechercheDonnees.setDepartLat(lat_dep);
        rechercheDonnees.setDepartLong(long_dep);
        rechercheDonnees.setArriveLat(lat_arr);
        rechercheDonnees.setArriveLong(long_arr);
        //Transmission Date (Heure_minute/jour)
        rechercheDonnees.setDateHeureDepart(dateHeureDep);
        rechercheDonnees.setDateHeureArrive(dateHeureArr);
        //Transmission distance de parcours
        double distancekm = StatistiquesStation.getKmFromLatLong(lat_dep, long_dep, long_arr, lat_arr);
        rechercheDonnees.setDistanceKm(distancekm);
        //maj du resultat panel
        IHMApplication.reloadResultatPanel();
        //redir
        IHMApplication.changerOngletResultat();
    }

    /*à rajouter en fonction du nombre...
    private void boutonSupprimer1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }*/

    public int getTemps_avant_alerte() {
        return temps_avant_alerte;
    }

    public void setTemps_avant_alerte(int temps_avant_alerte) {
        this.temps_avant_alerte = temps_avant_alerte;
    }

}
