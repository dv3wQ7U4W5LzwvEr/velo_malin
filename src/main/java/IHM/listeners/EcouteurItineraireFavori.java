package IHM.listeners;

import database.MysqlConnecter;
import database.MysqlRequester;
import model.Client;
import model.Station;
import recherche.StatistiquesStation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by laurel on 03/11/2015.
 */
public class EcouteurItineraireFavori implements ActionListener{

    private int id_station_arrivee;
    private int id_station_depart;

    public EcouteurItineraireFavori(int id_station_depart, int id_station_arrivee) {
        this.id_station_depart = id_station_depart;
        this.id_station_arrivee = id_station_arrivee;
    }


	public void actionPerformed(ActionEvent e) {
        Client client_actuel;
        client_actuel = new Client();
        boolean deja_favori = false;
        
        Map<Integer,Integer> liste_itineraires_favoris = MysqlRequester.getListeItinerairesFavoris();
 
        //pb : passe pas dans la boucle ou met pas à jour la variable dans la boucle
        for (Map.Entry<Integer,Integer> currentEntry : liste_itineraires_favoris.entrySet()){      	
        	int station_depart  = currentEntry.getKey();
        	int station_arrivee = currentEntry.getValue();
        	
    		if((id_station_depart == station_depart) && (id_station_arrivee == station_arrivee))
    			deja_favori = false;
        }
        
        /*
        Iterator<Integer> it = liste_itineraires_favoris.keySet().iterator();
    	
    	while (it.hasNext()){
    		int station_depart = it.next();	   				
    		int station_arrivee = liste_itineraires_favoris.get(station_depart);
			
    		if((station_depart == id_station_depart) && (station_arrivee == id_station_arrivee)){
    			deja_favori = true;
    		}
    	}   	
    	*/
    	
    	if(deja_favori == true){	
	        ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
	        JOptionPane.showMessageDialog(null, "Itinéraire déjà enregistré dans vos favoris", "Non sauvegardé", JOptionPane.WARNING_MESSAGE, img);
    	}
    	else{
	        MysqlRequester.insertItineraireFavorit(client_actuel, id_station_depart, id_station_arrivee);
	        ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
	        JOptionPane.showMessageDialog(null, "Itinéraire bien enregistré dans vos favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);
    	}
        
        
    }
}
