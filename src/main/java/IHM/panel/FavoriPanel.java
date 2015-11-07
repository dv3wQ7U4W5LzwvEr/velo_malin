package IHM.panel;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import database.MysqlRequester;
import model.Station;

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
    /* √† rajouter en fonction
    private javax.swing.JLabel labelArrivee;
    private javax.swing.JLabel labelDateTrajet;
    private javax.swing.JLabel labelDepart;
    private javax.swing.JLabel labelVelo;
    private javax.swing.JPanel panelFavoris;
    */
    //"src/main/resources/img/cross_small.png"
    //"src/main/resources/img/velo.png"

    /*M√©thode*/
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
        Map<Integer, Integer> liste_itinerairesfavoris = new HashMap<Integer, Integer>();;
        liste_itinerairesfavoris = MysqlRequester.getItinerairesFavoris();
        
        Iterator<Integer> it = liste_itinerairesfavoris.keySet().iterator();
    	
        //From Tof
        //faire une boucle pour rajouter chaque Label => voir avec conception PEC
        //gÈrer l'actualisation de l'affichage quand le favori est supprimÈ
        //Pb : crÈe Un seul bouton : car mÍme label!!! =>  voir PB avec PEC : gÈnÈration auto de code pas efficace dans ce cas!
        while (it.hasNext()) {
        	Object s_depart = it.next();
        	Object s_arrivee = liste_itinerairesfavoris.get(s_depart); 
        	  
        	int depart = (int) s_depart;
        	int arrivee = (int) s_arrivee;
        	
        	labelDepart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            labelDepart.setText(String.valueOf(s_depart));
        	
            labelVelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            labelVelo.setIcon(new javax.swing.ImageIcon("src/main/resources/img/velo.png")); // NOI18N
            labelVelo.setText(">");
            
            labelArrivee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            labelArrivee.setText(String.valueOf(s_arrivee));
            
            labelDateTrajet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            labelDateTrajet.setText("jours selected et heure");
            
            boutonSupprimer.setBackground(new java.awt.Color(255, 0, 0));
            boutonSupprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            boutonSupprimer.setIcon(new javax.swing.ImageIcon("src/main/resources/img/cross_small.png")); // NOI18N
            boutonSupprimer.setText("Supprimer");
            boutonSupprimer.setContentAreaFilled(false);
            boutonSupprimer.setOpaque(true);
            boutonSupprimer.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //boutonSupprimerActionPerformed(evt);
						MysqlRequester.getSupprimerItinerairesFavoris(depart,arrivee);
						
				    	ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
					    JOptionPane.showMessageDialog(null, "ItinÈraire bien supprimÈ des favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);          	
                }
            });
            
        }
        
        
        /*
        //labelDepart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        //labelDepart.setText("Adresse de d√©part");
        

        labelVelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelVelo.setIcon(new javax.swing.ImageIcon("src/main/resources/img/velo.png")); // NOI18N
        labelVelo.setText(">");

        labelArrivee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelArrivee.setText("Adresse d'arriv√©e");
		
        labelDateTrajet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDateTrajet.setText("jours selected et heure");

        boutonSupprimer.setBackground(new java.awt.Color(255, 0, 0));
        boutonSupprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boutonSupprimer.setIcon(new javax.swing.ImageIcon("src/main/resources/img/cross_small.png")); // NOI18N
        boutonSupprimer.setText("Supprimer");
        boutonSupprimer.setContentAreaFilled(false);
        boutonSupprimer.setOpaque(true);
        boutonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSupprimerActionPerformed(evt);
            }
        });
		*/

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
                        /*√† rajouter en fonction
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
                                /* √† ajouter en fonction...
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

    /*√† rajouter en fonction du nombre...
    private void boutonSupprimer1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }*/
}
