package IHM.panel;

import IHM.IHMApplication;
import IHM.listeners.EcouteurItineraireFavori;
import data.RechercheData;
import database.MysqlRequester;
import model.Station;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by QKFD7244 on 02/11/2015.
 */
public class ResultatPanel extends javax.swing.JPanel {

    /*Constructeur*/
    public ResultatPanel() {
        initResultat();
    }

    /*
    Attributs de classe
     */
    private javax.swing.JButton boutonAjouterFavori;
    private javax.swing.JRadioButton boutonArrivee4;
    private javax.swing.JRadioButton boutonArrivee5;
    private javax.swing.JRadioButton boutonArrivee6;
    private javax.swing.JRadioButton boutonArrivee7;
    private javax.swing.JButton boutonCreerAlerte;
    private javax.swing.ButtonGroup groupeArrivee;
    private javax.swing.ButtonGroup groupeDepart;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelAdresseArrivee1;
    private javax.swing.JLabel labelAdresseArrivee2;
    private javax.swing.JLabel labelAdresseArrivee3;
    private javax.swing.JLabel labelAdresseDepart1;
    private javax.swing.JLabel labelAdresseDepart2;
    private javax.swing.JLabel labelAdresseDepart3;
    private javax.swing.JLabel labelDateArrivee;
    private javax.swing.JLabel labelDateDepart;
    private javax.swing.JLabel labelDispoDepart1;
    private javax.swing.JLabel labelDispoDepart2;
    private javax.swing.JLabel labelDispoDepart3;
    private javax.swing.JLabel labelHeureArrivee1;
    private javax.swing.JLabel labelHeureArrivee2;
    private javax.swing.JLabel labelHeureArrivee3;
    private javax.swing.JLabel labelHeureDepart1;
    private javax.swing.JLabel labelHeureDepart2;
    private javax.swing.JLabel labelHeureDepart3;
    private javax.swing.JLabel labelNomArrivee1;
    private javax.swing.JLabel labelNomArrivee2;
    private javax.swing.JLabel labelNomArrivee3;
    private javax.swing.JLabel labelNomDepart1;
    private javax.swing.JLabel labelNomDepart2;
    private javax.swing.JLabel labelNomDepart3;
    private javax.swing.JLabel labelPlaceArrivee1;
    private javax.swing.JLabel labelPlaceArrivee2;
    private javax.swing.JLabel labelPlaceArrivee3;
    private javax.swing.JLabel labelTotalStatio5;
    private javax.swing.JLabel labelTotalStation1;
    private javax.swing.JLabel labelTotalStation2;
    private javax.swing.JLabel labelTotalStation3;
    private javax.swing.JLabel labelTotalStation4;
    private javax.swing.JLabel labelTotalStation6;
    private javax.swing.JPanel panelCarteResultats;
    private javax.swing.JRadioButton selctA1;
    private javax.swing.JRadioButton selctA2;
    //ajout manuel
    private JLabel labelDistance;
    
    private static String PASINFORMATIONS = "Pas d'informations";

    /*
    Methodes
     */
	private void initResultat() {

    	
        //Traitement listener et récup données ----------------------------			    
        RechercheData rechercheDonnees = RechercheData.getInstance();
        double lat_dep = rechercheDonnees.getDepartLat();
        double long_dep = rechercheDonnees.getDepartLong();
        double lat_arrivee = rechercheDonnees.getArriveLat();
        double long_arrivee = rechercheDonnees.getArriveLong();

        
		Map<Station, Double> liste_stations_proximites_depart = MysqlRequester.getStationsProximitees(lat_dep,long_dep, 3, 500);
		
		//Calendar cal_dep = rechercheDonnees.getDateHeureArrive();
    	//Date date_depart = cal_dep.getTime();
    	Calendar cal_dep = Calendar.getInstance();
    	cal_dep.set(2015, 10-1, 28, 14, 00, 00);
    	Date date_depart = cal_dep.getTime();
    	
    	List<String> tab_nom_stations = new ArrayList<String>();
    	List<String> tab_adresse_stations = new ArrayList<String>();
    	List<String> tab_id_stations = new ArrayList<String>();
    	List<String> tab_nbplaces_stations = new ArrayList<String>();
    	List<String> tab_nbvelos_stations = new ArrayList<String>();
    	List<String> tab_nbplacestotale_stations_depart = new ArrayList<String>();
    	
	    if(liste_stations_proximites_depart != null){    	
	    	Iterator<Station> it = liste_stations_proximites_depart.keySet().iterator();
	    	
	    	while (it.hasNext()){
	    		Station s = it.next();
		
	            int nbvelos = MysqlRequester.getNombreDeVelosSurStation(s.getId_station(), date_depart);
	            int nbplaces = MysqlRequester.getNombreDePlacesSurStation(s.getId_station(), date_depart);
	    		
	    		tab_id_stations.add(String.valueOf(s.getId_station()));
	    		tab_nom_stations.add(s.getNom());
		   		tab_adresse_stations.add(s.getAdresse());
		   		tab_nbplaces_stations.add(String.valueOf(nbplaces));
		   		tab_nbvelos_stations.add(String.valueOf(nbvelos));
		   		tab_nbplacestotale_stations_depart.add(String.valueOf(s.getPlaces()));
	    	}
	    } else {
	    	int i=0;
    		while(i < 3){
		    	tab_id_stations.add(PASINFORMATIONS);
	    		tab_nom_stations.add(null);
		   		tab_adresse_stations.add(null);
		   		tab_nbplaces_stations.add(PASINFORMATIONS);
		   		tab_nbvelos_stations.add(PASINFORMATIONS);
		   		tab_nbplacestotale_stations_depart.add(PASINFORMATIONS);
		   		i++;
    		}
	    }
    	
        Map<Station, Double> liste_stations_proximites_arrivee = MysqlRequester.getStationsProximitees(lat_arrivee,long_arrivee, 3, 1000);
                
    	Calendar cal_arr = Calendar.getInstance();
    	cal_arr.set(2015, 10-1, 28, 14, 00, 00);
    	Date date_arrivee = cal_arr.getTime();


    	//Stations résultats d arrivee
    	List<String> tab_nom_stations_arrivee = new ArrayList<String>();
    	List<String> tab_adresse_stations_arrivee = new ArrayList<String>();
    	List<String> tab_id_stations_arrivee = new ArrayList<String>();
    	List<String> tab_nbplaces_stations_arrivee = new ArrayList<String>();
    	List<String> tab_nbvelos_stations_arrivee = new ArrayList<String>();
    	List<String> tab_nbplacestotale_stations_arrivee = new ArrayList<String>();

    	if( liste_stations_proximites_arrivee != null){
	    	Iterator<Station> it2 = liste_stations_proximites_arrivee.keySet().iterator();
	    	
	    	while (it2.hasNext()){
	    		Station s = it2.next();
		
	            int nbvelos = MysqlRequester.getNombreDeVelosSurStation(s.getId_station(), date_arrivee);
	            int nbplaces = MysqlRequester.getNombreDePlacesSurStation(s.getId_station(), date_arrivee);
	    		
	    		tab_id_stations_arrivee.add(String.valueOf(s.getId_station()));
	    		tab_nom_stations_arrivee.add(s.getNom());
	    		tab_adresse_stations_arrivee.add(s.getAdresse());
	    		tab_nbplaces_stations_arrivee.add(String.valueOf(nbplaces));
	    		tab_nbvelos_stations_arrivee.add(String.valueOf(nbvelos));
	    		tab_nbplacestotale_stations_arrivee.add(String.valueOf(s.getPlaces()));
	    	}
    	} else {
    		int i=0;
    		while(i < 3){
    			tab_id_stations_arrivee.add(PASINFORMATIONS);
	    		tab_nom_stations_arrivee.add(PASINFORMATIONS);
	    		tab_adresse_stations_arrivee.add(PASINFORMATIONS);
	    		tab_nbplaces_stations_arrivee.add(PASINFORMATIONS);
	    		tab_nbvelos_stations_arrivee.add(PASINFORMATIONS);
	    		tab_nbplacestotale_stations_arrivee.add(PASINFORMATIONS);
		   		i++;
    		}
	    }
    	
        /*----Code généré*/
        groupeArrivee = new javax.swing.ButtonGroup();
        groupeDepart = new javax.swing.ButtonGroup();
        panelCarteResultats = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelDateDepart = new javax.swing.JLabel();
        labelNomDepart1 = new javax.swing.JLabel();
        labelAdresseDepart1 = new javax.swing.JLabel();
        labelTotalStation1 = new javax.swing.JLabel();
        labelDispoDepart1 = new javax.swing.JLabel();
        labelHeureDepart1 = new javax.swing.JLabel();
        selctA2 = new javax.swing.JRadioButton();
        boutonArrivee6 = new javax.swing.JRadioButton();
        boutonArrivee7 = new javax.swing.JRadioButton();
        labelHeureDepart3 = new javax.swing.JLabel();
        labelHeureDepart2 = new javax.swing.JLabel();
        labelNomDepart2 = new javax.swing.JLabel();
        labelNomDepart3 = new javax.swing.JLabel();
        labelDispoDepart2 = new javax.swing.JLabel();
        labelTotalStation2 = new javax.swing.JLabel();
        labelAdresseDepart2 = new javax.swing.JLabel();
        labelAdresseDepart3 = new javax.swing.JLabel();
        labelTotalStation3 = new javax.swing.JLabel();
        labelDispoDepart3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        selctA1 = new javax.swing.JRadioButton();
        labelNomArrivee1 = new javax.swing.JLabel();
        labelAdresseArrivee1 = new javax.swing.JLabel();
        labelHeureArrivee1 = new javax.swing.JLabel();
        labelPlaceArrivee1 = new javax.swing.JLabel();
        labelTotalStation4 = new javax.swing.JLabel();
        labelDateArrivee = new javax.swing.JLabel();
        boutonArrivee4 = new javax.swing.JRadioButton();
        labelNomArrivee2 = new javax.swing.JLabel();
        labelAdresseArrivee2 = new javax.swing.JLabel();
        labelTotalStatio5 = new javax.swing.JLabel();
        labelPlaceArrivee2 = new javax.swing.JLabel();
        labelHeureArrivee2 = new javax.swing.JLabel();
        labelTotalStation6 = new javax.swing.JLabel();
        labelNomArrivee3 = new javax.swing.JLabel();
        boutonArrivee5 = new javax.swing.JRadioButton();
        labelHeureArrivee3 = new javax.swing.JLabel();
        labelPlaceArrivee3 = new javax.swing.JLabel();
        labelAdresseArrivee3 = new javax.swing.JLabel();
        boutonCreerAlerte = new javax.swing.JButton();
        boutonAjouterFavori = new javax.swing.JButton();
        //ajout manuel
        labelDistance = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        /*
            panelCarteResultats.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            javax.swing.GroupLayout panelCarteResultatsLayout = new javax.swing.GroupLayout(panelCarteResultats);
            panelCarteResultats.setLayout(panelCarteResultatsLayout);
            panelCarteResultatsLayout.setHorizontalGroup(
                    panelCarteResultatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 389, Short.MAX_VALUE)
            );
            panelCarteResultatsLayout.setVerticalGroup(
                    panelCarteResultatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 514, Short.MAX_VALUE)
            );
        */

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "POUR LE DEPART", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        SimpleDateFormat date_format_dep = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        labelDateDepart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDateDepart.setText("Le " + date_format_dep.format(rechercheDonnees.getDateHeureDepart().getTime()));
        // marche pas donc on cache :)
        labelDateDepart.setVisible(false);

        labelNomDepart1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNomDepart1.setText(tab_nom_stations.get(0));

        labelAdresseDepart1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAdresseDepart1.setText(tab_adresse_stations.get(0));

        labelTotalStation1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTotalStation1.setIcon(new javax.swing.ImageIcon("src/main/resources/img/station.png")); // NOI18N
        labelTotalStation1.setText(String.valueOf(tab_nbplacestotale_stations_depart.get(0)));

        labelDispoDepart1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDispoDepart1.setIcon(new javax.swing.ImageIcon("src/main/resources/img/velo.png")); // NOI18N
        labelDispoDepart1.setText(String.valueOf(tab_nbvelos_stations.get(0)));

        groupeDepart.add(selctA2);
        selctA2.setEnabled(false);
        selctA2.setOpaque(false);
        selctA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selctA2ActionPerformed(evt);
            }
        });

        groupeDepart.add(boutonArrivee6);
        boutonArrivee6.setEnabled(false);
        boutonArrivee6.setOpaque(false);
        boutonArrivee6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonArrivee6ActionPerformed(evt);
            }
        });

        groupeDepart.add(boutonArrivee7);
        boutonArrivee7.setEnabled(false);
        boutonArrivee7.setOpaque(false);
        boutonArrivee7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonArrivee7ActionPerformed(evt);
            }
        });

        labelNomDepart2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNomDepart2.setText(tab_nom_stations.get(1));

        labelNomDepart3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNomDepart3.setText(tab_nom_stations.get(2));

        labelTotalStation2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTotalStation2.setIcon(new javax.swing.ImageIcon("src/main/resources/img/station.png")); // NOI18N
        labelTotalStation2.setText(String.valueOf(tab_nbplacestotale_stations_depart.get(1)));

        labelDispoDepart2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDispoDepart2.setIcon(new javax.swing.ImageIcon("src/main/resources/img/velo.png")); // NOI18N
        labelDispoDepart2.setText(String.valueOf(tab_nbvelos_stations.get(1)));
        
        labelAdresseDepart2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAdresseDepart2.setText(tab_adresse_stations.get(1));

        labelAdresseDepart3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAdresseDepart3.setText(tab_adresse_stations.get(2));

        labelTotalStation3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTotalStation3.setIcon(new javax.swing.ImageIcon("src/main/resources/img/station.png")); // NOI18N
        labelTotalStation3.setText(String.valueOf(tab_nbplacestotale_stations_depart.get(2)));

        labelDispoDepart3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDispoDepart3.setIcon(new javax.swing.ImageIcon("src/main/resources/img/velo.png")); // NOI18N
        labelDispoDepart3.setText(String.valueOf(tab_nbvelos_stations.get(2)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(selctA2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(labelHeureDepart1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelDispoDepart1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelTotalStation1)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(labelNomDepart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(labelAdresseDepart1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(labelDateDepart)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(boutonArrivee6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(labelHeureDepart2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelDispoDepart2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelTotalStation2)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(labelNomDepart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(labelAdresseDepart2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(boutonArrivee7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(labelHeureDepart3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelDispoDepart3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelTotalStation3)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(labelNomDepart3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelAdresseDepart3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(8, 8, 8))))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(labelDateDepart)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelNomDepart1)
                                                        .addComponent(labelAdresseDepart1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelHeureDepart1)
                                                        .addComponent(labelDispoDepart1)
                                                        .addComponent(labelTotalStation1)))
                                        .addComponent(selctA2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelNomDepart2)
                                                        .addComponent(labelAdresseDepart2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelHeureDepart2)
                                                        .addComponent(labelDispoDepart2)
                                                        .addComponent(labelTotalStation2)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(boutonArrivee6, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                                .addGap(1, 1, 1)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelNomDepart3)
                                                        .addComponent(labelAdresseDepart3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelHeureDepart3)
                                                        .addComponent(labelDispoDepart3)
                                                        .addComponent(labelTotalStation3)))
                                        .addComponent(boutonArrivee7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "POUR L'ARRIVEE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        groupeArrivee.add(selctA1);
        selctA1.setEnabled(false);
        selctA1.setOpaque(false);
        selctA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selctA1ActionPerformed(evt);
            }
        });
        
        //Champs arrivée
        labelNomArrivee1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNomArrivee1.setText(tab_nom_stations_arrivee.get(0));

        labelAdresseArrivee1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAdresseArrivee1.setText(tab_adresse_stations_arrivee.get(0));

        labelPlaceArrivee1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPlaceArrivee1.setIcon(new javax.swing.ImageIcon("src/main/resources/img/mark.png")); // NOI18N
        labelPlaceArrivee1.setText(String.valueOf(tab_nbplaces_stations_arrivee.get(0)));

        labelTotalStation4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTotalStation4.setIcon(new javax.swing.ImageIcon("src/main/resources/img/station.png")); // NOI18N
        labelTotalStation4.setText(String.valueOf(tab_nbplacestotale_stations_arrivee.get(0)));

        SimpleDateFormat date_format_arr = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        labelDateArrivee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDateArrivee.setText("Le " + date_format_arr.format(rechercheDonnees.getDateHeureArrive().getTime()));
        // marche pas donc on cache :)
        labelDateArrivee.setVisible(false);

        groupeArrivee.add(boutonArrivee4);
        boutonArrivee4.setEnabled(false);
        boutonArrivee4.setOpaque(false);
        boutonArrivee4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonArrivee4ActionPerformed(evt);
            }
        });

        labelNomArrivee2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNomArrivee2.setText(tab_nom_stations_arrivee.get(1));

        labelAdresseArrivee2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAdresseArrivee2.setText(tab_adresse_stations_arrivee.get(1));

        labelTotalStatio5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTotalStatio5.setIcon(new javax.swing.ImageIcon("src/main/resources/img/station.png")); // NOI18N
        labelTotalStatio5.setText(String.valueOf(tab_nbplacestotale_stations_arrivee.get(1)));

        labelPlaceArrivee2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPlaceArrivee2.setIcon(new javax.swing.ImageIcon("src/main/resources/img/mark.png")); // NOI18N
        labelPlaceArrivee2.setText(String.valueOf(tab_nbplaces_stations_arrivee.get(1)));

        labelTotalStation6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTotalStation6.setIcon(new javax.swing.ImageIcon("src/main/resources/img/station.png")); // NOI18N
        labelTotalStation6.setText(String.valueOf(tab_nbplacestotale_stations_arrivee.get(2)));

        labelNomArrivee3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNomArrivee3.setText(tab_nom_stations_arrivee.get(2));

        groupeArrivee.add(boutonArrivee5);
        boutonArrivee5.setEnabled(false);
        boutonArrivee5.setOpaque(false);
        boutonArrivee5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonArrivee5ActionPerformed(evt);
            }
        });

        labelPlaceArrivee3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPlaceArrivee3.setIcon(new javax.swing.ImageIcon("src/main/resources/img/mark.png")); // NOI18N
        labelPlaceArrivee3.setText(String.valueOf(tab_nbplaces_stations_arrivee.get(2)));

        labelAdresseArrivee3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAdresseArrivee3.setText(tab_adresse_stations_arrivee.get(2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(selctA1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(labelHeureArrivee1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelPlaceArrivee1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelTotalStation4)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(labelNomArrivee1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(labelAdresseArrivee1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12))))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(labelDateArrivee)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(boutonArrivee4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(labelHeureArrivee2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelPlaceArrivee2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelTotalStatio5)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(labelNomArrivee2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(labelAdresseArrivee2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(boutonArrivee5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(labelHeureArrivee3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelPlaceArrivee3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelTotalStation6)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(labelNomArrivee3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(labelAdresseArrivee3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12))))))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(labelDateArrivee)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelNomArrivee1)
                                                        .addComponent(labelAdresseArrivee1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelHeureArrivee1)
                                                        .addComponent(labelPlaceArrivee1)
                                                        .addComponent(labelTotalStation4)))
                                        .addComponent(selctA1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelNomArrivee2)
                                                        .addComponent(labelAdresseArrivee2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelHeureArrivee2)
                                                        .addComponent(labelPlaceArrivee2)
                                                        .addComponent(labelTotalStatio5)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(boutonArrivee4, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                                .addGap(1, 1, 1)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelNomArrivee3)
                                                        .addComponent(labelAdresseArrivee3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelHeureArrivee3)
                                                        .addComponent(labelPlaceArrivee3)
                                                        .addComponent(labelTotalStation6)))
                                        .addComponent(boutonArrivee5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        boutonCreerAlerte.setBackground(new java.awt.Color(204, 0, 0));
        boutonCreerAlerte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutonCreerAlerte.setForeground(new java.awt.Color(255, 255, 255));
        boutonCreerAlerte.setText("CREER UNE ALERTE DE CE TRAJET");
        boutonCreerAlerte.setActionCommand("setItineraire");
        boutonCreerAlerte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(253, 234, 234), new java.awt.Color(255, 153, 153), null));
        boutonCreerAlerte.setContentAreaFilled(false);
        boutonCreerAlerte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boutonCreerAlerte.setOpaque(true);
        boutonCreerAlerte.setVisible(true);         

        boutonCreerAlerte.addActionListener(new ActionListener() {
            int id_itinerairefavoris;
            boolean creation_alerte;

            public void actionPerformed(ActionEvent evt) {
                Map<Double, List<Double>> liste_itinerairefavoris = new HashMap<Double, List<Double>>();
                liste_itinerairefavoris = MysqlRequester.getListeItinerairesFavoris();

                if (liste_itinerairefavoris != null) {
                    creation_alerte = false;
                    for (Map.Entry<Double, List<Double>> currentEntry : liste_itinerairefavoris.entrySet()) {
                        double long_station_depart = currentEntry.getKey();
                        double lat_station_depart = currentEntry.getValue().get(0);
                        double long_station_arrivee = currentEntry.getValue().get(1);
                        double lat_station_arrivee = currentEntry.getValue().get(2);

                        //if((long_station_depart == 45.7971556) && (lat_station_depart == 4.7845067) && (lat_station_arrivee == 4.8047449) && (long_station_arrivee == 45.780722)){
                        if ((long_station_depart == long_dep) && (lat_station_depart == lat_dep) && (long_station_arrivee == long_arrivee) && (lat_station_arrivee == lat_arrivee)) {
                            id_itinerairefavoris = MysqlRequester.getListeIdItineraireFavori(lat_station_depart, long_station_depart, lat_station_arrivee, long_station_arrivee);
                            Date dateAlerte = rechercheDonnees.getDateHeureDepart().getTime();

                            MysqlRequester.setAlerte(dateAlerte, id_itinerairefavoris);
                            creation_alerte = true;
                        }
                    }
                    if (creation_alerte == true) {
                        ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
                        JOptionPane.showMessageDialog(null, "Alerte bien configuré", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);
                    } else
                        JOptionPane.showMessageDialog(null, "L'itinéraire doit être enregistré dans les favoris avant!", "Erreur", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Aucun itineraire favori enregistré", "Erreur", JOptionPane.WARNING_MESSAGE);
                }
                IHMApplication.reloadFavoriPanel2();
            }
        });   
        //boutonCreerAlerte.addActionListener(new EcouteurAlerte(dateAlerte,id_itinerairefavoris)); 
        

        boutonAjouterFavori.setBackground(new java.awt.Color(204, 0, 0));
        boutonAjouterFavori.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutonAjouterFavori.setForeground(new java.awt.Color(255, 255, 255));
        boutonAjouterFavori.setText("ENREGISTRER EN FAVORI");
        boutonAjouterFavori.setActionCommand("setItineraire");
        boutonAjouterFavori.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(253, 234, 234), new java.awt.Color(255, 153, 153), null));
        boutonAjouterFavori.setContentAreaFilled(false);
        boutonAjouterFavori.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boutonAjouterFavori.setOpaque(true);       
        boutonAjouterFavori.addActionListener(new EcouteurItineraireFavori(lat_dep, long_dep, lat_arrivee, long_arrivee));
        
        NumberFormat formatter = new DecimalFormat("#0.00");     
        double distance = rechercheDonnees.getArriveLong();
        String d = formatter.format(distance);
        labelDistance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDistance.setText("Distance de parcours : " + d + " kilomètres");   
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(IHMApplication.panel2);
        IHMApplication.panel2.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        		.addComponent(labelDistance, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                                .addComponent(boutonCreerAlerte, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                                .addComponent(boutonAjouterFavori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCarteResultats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelCarteResultats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(boutonCreerAlerte, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(boutonAjouterFavori, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        /*------Fin de code généré*/      
        
    }

    /**/
    private void selctA1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void boutonArrivee4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void boutonArrivee5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void selctA2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void boutonArrivee6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void boutonArrivee7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void boutonCreerAlerteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void boutonAjouterFavoriActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
