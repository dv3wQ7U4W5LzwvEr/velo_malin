package IHM.panel;

import database.MysqlRequester;
import was.google_map_api.GoogleMapApi;

import javax.swing.*;

import IHM.IHMApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        labelDepart = new javax.swing.JLabel();
        labelVelo = new javax.swing.JLabel();
        labelArrivee = new javax.swing.JLabel();
        labelDateTrajet = new javax.swing.JLabel();
        boutonSupprimer = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelFavoris.setBackground(new java.awt.Color(255, 255, 255));
        panelFavoris.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "FAVORIS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N


        /*Faire un for*/       
        Map<Double,List<Double>> liste_itinerairesfavoris = new HashMap<Double, List<Double>>();;
        liste_itinerairesfavoris = MysqlRequester.getListeItinerairesFavoris();
        
        Iterator<Double> it = liste_itinerairesfavoris.keySet().iterator();
        int cpt = 0;
    	
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
        	
        	cpt++;
        	
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
                		//MysqlRequester.getSupprimerItinerairesFavoris(String.valueOf(4.7845067),String.valueOf(45.7971556),String.valueOf(45.780722),String.valueOf(4.8047449));
						MysqlRequester.getSupprimerItinerairesFavoris(lat_depart,long_depart,lat_arrivee,long_arrivee);
						
				    	ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
					    JOptionPane.showMessageDialog(null, "Itin�raire bien supprim� des favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img); 
					    
					    //IHMApplication.reloadFavoriPanel();
                }
            });
            
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
