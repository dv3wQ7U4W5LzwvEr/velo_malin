package IHM.listeners;
import IHM.*;

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

    private double lat_dep;
    private double long_dep;
    private double lat_arr;
    private double long_arr;

    private boolean pas_info = false;

	public EcouteurItineraireFavori(double lat_dep, double long_dep, double lat_arr, double long_arr) {
		super();
		this.lat_dep = lat_dep;
		this.long_dep = long_dep;
		this.lat_arr = lat_arr;
		this.long_arr = long_arr;
	}


	public void actionPerformed(ActionEvent e) {
        Client client_actuel;
        client_actuel = new Client();
        
        Map<Integer,List<Double>> liste_itineraires_favoris = MysqlRequester.getListeItinerairesFavoris();

		boolean deja_favori = false;
		if(MysqlRequester.isItineraireFavoriExist(String.valueOf(lat_dep), String.valueOf(long_dep), String.valueOf(lat_arr), String.valueOf(long_arr)))
		{
			deja_favori = true;
		}
 
    	if(deja_favori){
	        ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
	        JOptionPane.showMessageDialog(null, "Attention : itinéraire déjà enregistré dans vos favoris", "Non sauvegardé", JOptionPane.WARNING_MESSAGE, img);
    	}
    	else{
	        MysqlRequester.insertItineraireFavorit(client_actuel,  String.valueOf(lat_dep), String.valueOf(long_dep),  String.valueOf(lat_arr), String.valueOf(long_arr));
	        ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
	        JOptionPane.showMessageDialog(null, "Itinéraire bien enregistré dans vos favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);
    	}
    	//rajouté manuellement le 10/11/2015 à 16:15
    	IHMApplication.reloadFavoriPanel();
    }
}
