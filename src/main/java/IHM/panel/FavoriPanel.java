package IHM.panel;

import IHM.IHMApplication;
import database.MysqlRequester;
import was.google_map_api.GoogleMapApi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by QKFD7244 on 02/11/2015.
 */
public class FavoriPanel extends javax.swing.JPanel{
    /*Constructeur*/
    public FavoriPanel() {
        initFavori();
    }

    /*Variables*/
    private javax.swing.JButton boutonSupprimer;
    private javax.swing.JLabel labelArrivee;
    private javax.swing.JLabel labelDateTrajet;
    private javax.swing.JLabel labelDepart;
    private javax.swing.JLabel labelVelo;
    private javax.swing.JPanel panelFavoris;
    private javax.swing.JPanel panelAlerte;
    /* à rajouter en fonction
    private javax.swing.JLabel labelArrivee;
    private javax.swing.JLabel labelDateTrajet;
    private javax.swing.JLabel labelDepart;
    private javax.swing.JLabel labelVelo;
    private javax.swing.JPanel panelFavoris;
    */
    //"src/main/resources/img/cross_small.png"
    //"src/main/resources/img/velo.png"

    /*Méthode*/
    private void initFavori() {
        panelFavoris = new javax.swing.JPanel();
        panelAlerte = new javax.swing.JPanel();
        labelDepart = new javax.swing.JLabel();
        labelVelo = new javax.swing.JLabel();
        labelArrivee = new javax.swing.JLabel();
        labelDateTrajet = new javax.swing.JLabel();
        boutonSupprimer = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelFavoris.setBackground(new java.awt.Color(255, 255, 255));
        panelFavoris.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "FAVORIS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        panelAlerte.setBackground(new java.awt.Color(255, 255, 255));
        panelAlerte.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "ALERTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

              
        /* Récupération liste des Alertes dans la table Alertes */
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
    	
        /*Timer d'Alerte*/
            Map<Integer, Date> prochaineAlerte = MysqlRequester.getListeAlerte();
            ActionListener actionListener = actionEvent->JOptionPane.showMessageDialog(null, "Vous avez une alerte!");
            int tempsRestant = 9000;//difference de temps
            javax.swing.Timer timer = new javax.swing.Timer(9000, actionListener);
            timer.start();
            timer.setRepeats(false);
        
        
        //Suppression Alerte pass�e dans BDD
        //_deleteAlerte(Heure,id_itineraire_favori);
         
	    
        /*Faire un for*/       
        Map<Double,List<Double>> liste_itinerairesfavoris = new HashMap<Double, List<Double>>();;
        liste_itinerairesfavoris = MysqlRequester.getListeItinerairesFavoris();
        
	    if(liste_itinerairesfavoris != null){    	
	    	Iterator<Double> it = liste_itinerairesfavoris.keySet().iterator();
        
	        while (it.hasNext()) {
	        	Object cle  = it.next();
	        	Object valeurs = liste_itinerairesfavoris.get(cle);
	        	  
	        	String long_depart = String.valueOf(cle);
	        	List<Double> liste = new ArrayList<Double>();
	        	liste = (List<Double>) valeurs;
	        	
	        	String lat_depart = String.valueOf(liste.get(0));
	        	String long_arrivee = String.valueOf(liste.get(1));
	        	String lat_arrivee = String.valueOf(liste.get(2));
	        	
	//        	String adr_dep[] = null;
	//        	String adr_arr[] = null;
	//        	adr_dep[cpt] = GoogleMapApi.rechercherAdresseParLatLong(Double.parseDouble(long_depart), Double.parseDouble(lat_depart));
	//        	adr_arr[cpt] = GoogleMapApi.rechercherAdresseParLatLong(Double.parseDouble(long_arrivee), Double.parseDouble(lat_arrivee));
	        	
	        	String adresse_depart = GoogleMapApi.rechercherAdresseParLatLong(Double.parseDouble(long_depart), Double.parseDouble(lat_depart));
	        	String adresse_arrivee = GoogleMapApi.rechercherAdresseParLatLong(Double.parseDouble(long_arrivee), Double.parseDouble(lat_arrivee));
	        	
	        	//cpt++;
	        	
	        	labelDepart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	            labelDepart.setText(adresse_depart);
	        	
	            labelVelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	            labelVelo.setIcon(new javax.swing.ImageIcon("src/main/resources/img/velo.png")); // NOI18N
	            labelVelo.setText(">");
	            
	            labelArrivee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	            labelArrivee.setText(String.valueOf(adresse_arrivee));
	            
	            boutonSupprimer.setBackground(new java.awt.Color(255, 0, 0));
	            boutonSupprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
	            boutonSupprimer.setIcon(new javax.swing.ImageIcon("src/main/resources/img/cross_small.png")); // NOI18N
	            boutonSupprimer.setText("Supprimer");
	            boutonSupprimer.setContentAreaFilled(false);
	            boutonSupprimer.setOpaque(true);         
	            boutonSupprimer.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent evt) {
							MysqlRequester.getSupprimerItinerairesFavoris(lat_depart,long_depart,lat_arrivee,long_arrivee);
							
							IHMApplication.reloadFavoriPanel();
	                }
	            });}
	        	}
	            else {
		        	labelDepart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		            labelDepart.setText("Pas d'itinéraires favoris enregistrés");
	    	    }
        

        //labelDepart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        //labelDepart.setText("Adresse de départ");
        

//        labelVelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        labelVelo.setIcon(new javax.swing.ImageIcon("src/main/resources/img/velo.png")); // NOI18N
//        labelVelo.setText(">");
//
//        labelArrivee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        labelArrivee.setText("Adresse d'arrivée");
//		
//        labelDateTrajet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        labelDateTrajet.setText("jours selected et heure");
//
//        boutonSupprimer.setBackground(new java.awt.Color(255, 0, 0));
//        boutonSupprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        boutonSupprimer.setIcon(new javax.swing.ImageIcon("src/main/resources/img/cross_small.png")); // NOI18N
//        boutonSupprimer.setText("Supprimer");
//        boutonSupprimer.setContentAreaFilled(false);
//        boutonSupprimer.setOpaque(true);
//        boutonSupprimer.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                boutonSupprimerActionPerformed(evt);
//            }
//        });
		 
        
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
                        /*à rajouter en fonction
                        .addGroup(panelFavorisLayout.createSequentialGroup()
                        .addComponent(labelDepart1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelVelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelArrivee1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(labelDateTrajet1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonSupprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        */
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
                                /* à ajouter en fonction...
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelFavorisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelDepart1)
                                        .addComponent(labelArrivee1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelVelo1)
                                        .addComponent(labelDateTrajet1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(boutonSupprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                */
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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
        
    }

    
    /*Listeneur*/
    private void boutonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {   	
    	
    }

    /*à rajouter en fonction du nombre...
    private void boutonSupprimer1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }*/
}
