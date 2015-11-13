package IHM.panel;

import IHM.IHMApplication;
import data.RechercheData;
import database.MysqlRequester;

import model.Alerte;
import org.jdesktop.swingx.VerticalLayout;
import recherche.StatistiquesStation;
import was.google_map_api.GoogleMapApi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;

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
    @SuppressWarnings("unchecked")
	private void initFavori() {

        /*Timer d'Alerte - PEC*/
        List<Integer> infoAllNext =  MysqlRequester.getTimeNextAlert(); //on recup une liste triée

        if(infoAllNext.isEmpty()){
            //on ne fait rien s'il n'y a pas d'alerte prévue
        }else{
            final int id_favori_next_alerte = infoAllNext.get(0);
            int tempsRestant = (infoAllNext.get(1)-(temps_avant_alerte*60000));//difference de temps en mili
            ActionListener actionListener = actionEvent-> actionAlerte(id_favori_next_alerte);
            /*test:*JOptionPane.showMessageDialog(null,"alerte dans :"+tempsRestant+" ms, id:"+infoAllNext.get(0));
    	/**/

            //int cle  = iter.next();
            //int valeur = infoAllNext.get(cle);

            //int tempsRestant = iter.next();
            //int id_itineraire_favori = infoAllNext.get(tempsRestant);

            javax.swing.Timer timer = new javax.swing.Timer(tempsRestant, actionListener);
            timer.start();
            timer.setRepeats(false);
        }

        /**/

        // panel pour alertes

        /*
        panelAlerte = new javax.swing.JPanel();
        panelAlerte.setBackground(new java.awt.Color(255, 255, 255));
        panelAlerte.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "ALERTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N
        */

        // panel pour favoris
        JPanel panelFavoris = new JPanel();
        panelFavoris.setBackground(new java.awt.Color(255, 255, 255));
        panelFavoris.setLayout(new VerticalLayout());
        JButton boutonSupprimer = new JButton();

        Map<Integer, List<Double>> listFavoris = MysqlRequester.getListeItinerairesFavoris();
        if (listFavoris != null) {

            int nombreDeFavoris = listFavoris.size();
            JLabel labelPresentationFavoris = new JLabel();
            labelPresentationFavoris.setText("LISTE DES FAVORIS");
            labelPresentationFavoris.setBackground(new java.awt.Color(255, 255, 255));
            panelFavoris.add(labelPresentationFavoris);

            if (nombreDeFavoris != 0) {
                JPanel f;
                JLabel labelDepart, labelArrivee, labelDateTrajet;
                for (Integer cle : listFavoris.keySet()) {
                    // recuperation latitude longitude
                    String long_depart = String.valueOf(listFavoris.get(cle).get(0));
                    String lat_depart = String.valueOf(listFavoris.get(cle).get(1));
                    String long_arrivee = String.valueOf(listFavoris.get(cle).get(2));
                    String lat_arrivee = String.valueOf(listFavoris.get(cle).get(3));

                    String adresse_depart = GoogleMapApi.rechercherAdresseParLatLong(Double.parseDouble(lat_depart), Double.parseDouble(long_arrivee));
                    String adresse_arrivee = GoogleMapApi.rechercherAdresseParLatLong(Double.parseDouble(lat_depart), Double.parseDouble(long_arrivee));

                    // création des labels
                    f = new JPanel();

                    labelDepart = new JLabel();
                    labelDepart.setFont(new Font("Tahoma", 1, 14));
                    labelDepart.setText(getAdresseDepart(adresse_depart));
                    labelDepart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    f.add(labelDepart);

                    labelArrivee = new JLabel();
                    labelArrivee.setFont(new Font("Tahoma", 1, 14));
                    labelArrivee.setText(getAdresseArrivee(adresse_arrivee));
                    labelArrivee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    f.add(labelArrivee);

                    boutonSupprimer = new JButton();
                    boutonSupprimer.setBackground(new Color(255, 0, 0));
                    boutonSupprimer.setFont(new Font("Tahoma", 0, 14)); // NOI18N
                    boutonSupprimer.setIcon(new ImageIcon("src/main/resources/img/cross_small.png")); // NOI18N
                    boutonSupprimer.setText("Supprimer");
                    boutonSupprimer.setContentAreaFilled(false);
                    boutonSupprimer.setOpaque(true);
                    boutonSupprimer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            MysqlRequester.supprimerItinerairesFavoris(lat_depart, long_depart, lat_arrivee, long_arrivee);
                            IHMApplication.reloadFavoriPanel();
                            ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
                            JOptionPane.showMessageDialog(null, "L'Itinéraire et les alertes rattachées ont bien été supprimé des favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);
                        }
                    });
                    f.add(boutonSupprimer);
                    panelFavoris.add(f);
                }
            }
        }
        
    	// panel pour alertes 
        
	    JPanel panelAlertes = new JPanel();
	    panelAlertes.setBackground(new java.awt.Color(255, 255, 255));
	    panelAlertes.setLayout(new VerticalLayout());
	
	    Map<Integer, Alerte> listAlerts = MysqlRequester.getListeAlerte();
	      	    
	    if (listAlerts != null) {
            JLabel labelPresentationAlerte = new JLabel();
            labelPresentationAlerte.setText("LISTE DES ALERTES");
            labelPresentationAlerte.setBackground(new java.awt.Color(255, 255, 255));
            panelFavoris.add(labelPresentationAlerte);

	        if (listAlerts.size() != 0) {
                JPanel f;
                JLabel labelDepart_alerte, labelArrivee_alerte, labelDateAlerte;

                for (Entry<Integer, Alerte> currentEntry : listAlerts.entrySet()) {
                    Alerte alerte = currentEntry.getValue();
                    Date dateAlerte = alerte.getTime();

		        	//probl�me de r�cup�ration des donn�es
		        	List<Double> liste_val = MysqlRequester.getItineraireFavorisLocalisationViaId(alerte.getIdItineraireFavori());

                    if (liste_val != null)
                    {
                        if (! liste_val.isEmpty())
                        {
                            // recuperation latitude longitude
                            String long_depart = String.valueOf(liste_val.get(0));
                            String lat_depart = String.valueOf(liste_val.get(1));
                            String long_arrivee = String.valueOf(liste_val.get(2));
                            String lat_arrivee = String.valueOf(liste_val.get(3));

                            String adresse_depart = GoogleMapApi.rechercherAdresseParLatLong(Double.parseDouble(lat_depart), Double.parseDouble(long_arrivee));
                            String adresse_arrivee = GoogleMapApi.rechercherAdresseParLatLong(Double.parseDouble(lat_depart), Double.parseDouble(long_arrivee));

                            // création des labels
                            f = new JPanel();

                            labelDepart_alerte = new JLabel();
                            labelDepart_alerte.setFont(new Font("Tahoma", 1, 14));
                            labelDepart_alerte.setText(getAdresseDepart(adresse_depart));
                            labelDepart_alerte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            f.add(labelDepart_alerte);

                            labelArrivee_alerte = new JLabel();
                            labelArrivee_alerte.setFont(new Font("Tahoma", 1, 14));
                            labelArrivee_alerte.setText(getAdresseArrivee(adresse_arrivee));
                            labelArrivee_alerte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            f.add(labelArrivee_alerte);

                            labelDateAlerte = new JLabel();
                            labelDateAlerte.setFont(new Font("Tahoma", 1, 14));
                            labelDateAlerte.setText(String.valueOf(dateAlerte));
                            labelDateAlerte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            f.add(labelDateAlerte);

                            boutonSupprimer = new JButton();
                            boutonSupprimer.setBackground(new Color(255, 0, 0));
                            boutonSupprimer.setFont(new Font("Tahoma", 0, 14)); // NOI18N
                            boutonSupprimer.setIcon(new ImageIcon("src/main/resources/img/cross_small.png")); // NOI18N
                            boutonSupprimer.setText("Supprimer");
                            boutonSupprimer.setContentAreaFilled(false);
                            boutonSupprimer.setOpaque(true);
                            boutonSupprimer.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {
                                    MysqlRequester.supprimerAlerteByItiFavoEtHeure(alerte.getIdItineraireFavori(), dateAlerte);
                                    IHMApplication.reloadFavoriPanel();
                                    ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
                                    JOptionPane.showMessageDialog(null, "Alerte bien supprimé des favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);
                                }
                            });
                            f.add(boutonSupprimer);
                            panelFavoris.add(f);
                        }
                    }
		    	}
	        }
	    }
		
	    
	     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(IHMApplication.panel4);
	        IHMApplication.panel4.setLayout(layout);
	        layout.setHorizontalGroup(
	                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                                .addComponent(panelFavoris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(panelAlertes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                )
	        );
	        layout.setVerticalGroup(
	                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(panelFavoris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(panelAlertes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(100, Short.MAX_VALUE)
                            )
	        );
	    
	    
	}

    private String getAdresseArrivee(String adresse_arrivee) {
        return "Arrivée : " + adresse_arrivee + " ; ";
    }

    private String getAdresseDepart(String adresse_depart) {
        return "Depart : " + adresse_depart + " ; ";
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
