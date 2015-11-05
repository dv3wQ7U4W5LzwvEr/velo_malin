package IHM.listeners;

import database.MysqlConnecter;
import database.MysqlRequester;
import model.Client;
import model.Station;
import recherche.StatistiquesStation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by laurel on 03/11/2015.
 */
public class EcouteurItineraireFavori implements ActionListener{

    private int id_station_arrivee;
    private int id_station_depart;
    List<Integer> tab_test_dep = new ArrayList<Integer>();
    List<Integer> tab_test_arr = new ArrayList<Integer>();

    public EcouteurItineraireFavori(int id_station_depart, int id_station_arrivee) {
        this.id_station_depart = id_station_depart;
        this.id_station_arrivee = id_station_arrivee;
    }


	public void actionPerformed(ActionEvent e) {
        Client client_actuel;
        client_actuel = new Client();
        boolean deja_favori = false;

        
        Map<Integer,Integer> liste_itineraires_favoris = MysqlRequester.getListeItinerairesFavoris();
 
        for (Map.Entry<Integer,Integer> currentEntry : liste_itineraires_favoris.entrySet()){      	      	  	
        	int station_depart  = currentEntry.getKey();
        	int station_arrivee = currentEntry.getValue();
        	
        	tab_test_dep.add(station_depart);
        	tab_test_arr.add(station_arrivee);
        	
    		if((id_station_depart == station_depart) && (id_station_arrivee == station_arrivee))
    			deja_favori = true;  			
        }
        
 
    	if(deja_favori == true){	
	        ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
	        JOptionPane.showMessageDialog(null, "Attention : itinéraire déjà enregistré dans vos favoris", "Non sauvegardé", JOptionPane.WARNING_MESSAGE, img);
    	}
    	else{
	        MysqlRequester.insertItineraireFavorit(client_actuel, id_station_depart, id_station_arrivee);
	        ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
	        JOptionPane.showMessageDialog(null, "Itinéraire bien enregistré dans vos favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);
    	}
        
        
    }
}
