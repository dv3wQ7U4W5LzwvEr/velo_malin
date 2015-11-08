package IHM.panel;

import IHM.google_map.GoogleMapIHM;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * @author QKFD724
 */
public class ItinerairePanel extends javax.swing.JPanel {

	public static double lat_test_dep;
	public static double long_test_dep;
	public static double lat_test_arr;
	public static double long_test_arr;
	
    /**
     * Creates new form NewJPanel
     * Constructeur
     */
    public ItinerairePanel() {
        initItineraire();
        
        
    }

    /*Variables*/
    public javax.swing.JTextField adresseDepart;
    public javax.swing.JTextField adresseArrivee;
    private javax.swing.JButton boutonArrivee;
    private javax.swing.JButton boutonDepart;
    private javax.swing.JButton boutonLancer;
    private javax.swing.JTextField datePicker2;
    private javax.swing.JPanel depart;
    private javax.swing.JPanel depart1;
    private javax.swing.JPanel depart2;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JSpinner heureD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSpinner minuteD;
    private javax.swing.JPanel panItineraire;
    private javax.swing.JPanel panelCarte;
    String adresse_arrivee;
    String adresse_depart;

    /*Méthode*/
    private void initItineraire() {
        panItineraire = new javax.swing.JPanel();
        panelCarte = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        boutonLancer = new javax.swing.JButton();
        depart1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        datePicker2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        heureD = new javax.swing.JSpinner();
        minuteD = new javax.swing.JSpinner();
        depart2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        adresseDepart = new javax.swing.JTextField();
        boutonDepart = new javax.swing.JButton();
        depart = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        adresseArrivee = new javax.swing.JTextField();
        boutonArrivee = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));

        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(800, 633));

        panItineraire.setBackground(new java.awt.Color(255, 255, 255));
        panItineraire.setAutoscrolls(true);

        panelCarte.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelCarte.setPreferredSize(new java.awt.Dimension(522, 584));



        /*Code pour la carte*/
        final JFXPanel panelCarte = new JFXPanel();

        panelCarte.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelCarte.setPreferredSize(new java.awt.Dimension(522, 584));

        javax.swing.GroupLayout panelCarteLayout = new javax.swing.GroupLayout(panelCarte);
        panelCarte.setLayout(panelCarteLayout);
        panelCarteLayout.setHorizontalGroup(
                panelCarteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCarteLayout.setVerticalGroup(
                panelCarteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                GoogleMapIHM googleMap = GoogleMapIHM.getInstance();
                Scene scene = googleMap.getScene();
                panelCarte.setScene(scene);
                panelCarte.setSize(new java.awt.Dimension(522, 584));
            }

        });

        boutonLancer.setBackground(new java.awt.Color(0, 255, 0));
        boutonLancer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutonLancer.setText("Lancer la recherche");
        boutonLancer.setActionCommand("setItineraire");
        boutonLancer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(253, 234, 234), new java.awt.Color(255, 153, 153), null));
        boutonLancer.setContentAreaFilled(false);
        boutonLancer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boutonLancer.setOpaque(true);

        depart1.setBackground(new java.awt.Color(255, 255, 0));
        depart1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "HORAIRES\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Jour de départ");

        datePicker2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        datePicker2.setText("datePicker");
        datePicker2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePicker2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Heure prévue");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("h");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("min");

        heureD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        heureD.setRequestFocusEnabled(false); 
        
        
        minuteD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout depart1Layout = new javax.swing.GroupLayout(depart1);
        depart1.setLayout(depart1Layout);
        depart1Layout.setHorizontalGroup(
                depart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(depart1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(depart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16))
                                .addGap(26, 26, 26)
                                .addGroup(depart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(depart1Layout.createSequentialGroup()
                                                .addComponent(heureD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(minuteD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel18))
                                        .addComponent(datePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        depart1Layout.setVerticalGroup(
                depart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(depart1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(depart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(datePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(depart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addGroup(depart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(heureD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel17)
                                                .addComponent(minuteD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel18)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        depart2.setBackground(new java.awt.Color(51, 51, 255));
        depart2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "DEPART", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Adresse, lieu, ... ");

        adresseDepart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adresseDepart.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        
        /*
        adresseDepart.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
                JTextField textField = (JTextField) e.getSource();
                adresse_depart = textField.getText();
            }
 
            public void keyTyped(KeyEvent e) {
                // TODO: Do something for the keyTyped event
            }
 
            public void keyPressed(KeyEvent e) {
                // TODO: Do something for the keyPressed event
            }
        });
		*/
        
        boutonDepart.setBackground(new java.awt.Color(255, 255, 255));
        boutonDepart.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutonDepart.setForeground(new java.awt.Color(255, 255, 255));
        boutonDepart.setIcon(new javax.swing.ImageIcon("src/main/resources/img/search.png")); // NOI18N
        boutonDepart.setActionCommand("setItineraire");
        boutonDepart.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        boutonDepart.setContentAreaFilled(false);
        boutonDepart.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boutonDepart.setOpaque(true);
        boutonDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonDepartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout depart2Layout = new javax.swing.GroupLayout(depart2);
        depart2.setLayout(depart2Layout);
        depart2Layout.setHorizontalGroup(
                depart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(depart2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(depart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addGroup(depart2Layout.createSequentialGroup()
                                                .addComponent(adresseDepart, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(boutonDepart)))
                                .addContainerGap())
        );
        depart2Layout.setVerticalGroup(
                depart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(depart2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(depart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(depart2Layout.createSequentialGroup()
                                                .addComponent(boutonDepart)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(adresseDepart))
                                .addContainerGap())
        );

        depart.setBackground(new java.awt.Color(255, 0, 0));
        depart.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "ARRIVEE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Adresse, lieu, ... ");

        adresseArrivee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adresseArrivee.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        //test
    	Calendar cal = Calendar.getInstance();   	
    	cal.set(2015, 10-1, 28, 13, 00, 00);
    	Date date_recherche = cal.getTime();
        
        boutonLancer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                adresse_depart = adresseDepart.getText();
                adresse_arrivee = adresseArrivee.getText();
                Date date_depart = date_recherche;
                
                //Localisation localisation_adresse_depart = new Localisation();
                //Localisation localisation_adresse_arrivee = new Localisation();
                //localisation_adresse_depart = GoogleMapApi.rechercherLatLong(adresse_depart);
                //localisation_adresse_arrivee = GoogleMapApi.rechercherLatLong(adresse_arrivee);
                
                //double lat_dep = localisation_adresse_depart.getLatitude();
                //double long_dep = localisation_adresse_depart.getLongitude();
                //double lat_arr = localisation_adresse_arrivee.getLatitude();
                //double long_arr = localisation_adresse_arrivee.getLongitude();
                lat_test_dep = 45.750945;
                long_test_dep = 4.83927;
                lat_test_arr = 45.750945;
                long_test_arr = 4.83927;
                    
                
                //String latitude = String.valueOf(lat_test);
                //String longitude = String.valueOf(long_test);
                //int id_station_depart = MysqlRequester.getIdStationparCoord(latitude,longitude);
                
                ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
    	        JOptionPane.showMessageDialog(null, "test :" + adresse_arrivee + adresse_depart + date_depart, "Non sauvegardé", JOptionPane.WARNING_MESSAGE, img);
            	}
        	});
        
        /*
        adresseArrivee.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
                JTextField textField = (JTextField) e.getSource();
                adresse_arrivee = textField.getText();
            }
 
            public void keyTyped(KeyEvent e) {
                // TODO: Do something for the keyTyped event
            }
 
            public void keyPressed(KeyEvent e) {
                // TODO: Do something for the keyPressed event
            }
        });
		*/
        
        boutonArrivee.setBackground(new java.awt.Color(255, 255, 255));
        boutonArrivee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutonArrivee.setForeground(new java.awt.Color(255, 255, 255));
        boutonArrivee.setIcon(new javax.swing.ImageIcon("src/main/resources/img/search.png")); // NOI18N
        boutonArrivee.setActionCommand("setItineraire");
        boutonArrivee.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        boutonArrivee.setContentAreaFilled(false);
        boutonArrivee.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boutonArrivee.setOpaque(true);
        boutonArrivee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonArriveeActionPerformed(evt);
            }
        });


        //boutonLancer.addActionListener(new EcouteurBoutonLancerRecherche(adresse_depart, adresse_arrivee,date_recherche)); 
        
        javax.swing.GroupLayout departLayout = new javax.swing.GroupLayout(depart);
        depart.setLayout(departLayout);
        departLayout.setHorizontalGroup(
                departLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(departLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(departLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(departLayout.createSequentialGroup()
                                                .addComponent(adresseArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(boutonArrivee)))
                                .addContainerGap())
        );
        departLayout.setVerticalGroup(
                departLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(departLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(departLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(departLayout.createSequentialGroup()
                                                .addComponent(boutonArrivee)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(adresseArrivee))
                                .addContainerGap())
        );

        javax.swing.GroupLayout panItineraireLayout = new javax.swing.GroupLayout(panItineraire);
        panItineraire.setLayout(panItineraireLayout);
        panItineraireLayout.setHorizontalGroup(
                panItineraireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panItineraireLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panItineraireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panItineraireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panItineraireLayout.createSequentialGroup()
                                                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(236, 236, 236))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panItineraireLayout.createSequentialGroup()
                                                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(266, 266, 266)))
                                        .addGroup(panItineraireLayout.createSequentialGroup()
                                                .addGroup(panItineraireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(depart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(depart2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(depart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(boutonLancer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(panelCarte, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        panItineraireLayout.setVerticalGroup(
                panItineraireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panItineraireLayout.createSequentialGroup()
                                .addGroup(panItineraireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panItineraireLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(depart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(depart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(depart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(boutonLancer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panItineraireLayout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(panelCarte, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(149, 149, 149)
                                                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panItineraireLayout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(374, 374, 374)
                                .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(panItineraire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panItineraire, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
}

    /*Listeneurs*/
    private void boutonLancerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void boutonArriveeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void boutonDepartActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void datePicker2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}
