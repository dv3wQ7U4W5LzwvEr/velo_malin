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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by laurel on 03/11/2015.
 */
public class EcouteurAlerte implements ActionListener{

    private int id_itineraire_favori;
    private Date heure;

    public EcouteurAlerte(Date heure,int id_itineraire_favori) {
        this.heure = heure;
    	this.id_itineraire_favori = id_itineraire_favori;
    }


	public void actionPerformed(ActionEvent e) {   
	    MysqlRequester.setAlerte(heure,id_itineraire_favori);
	    ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
	    JOptionPane.showMessageDialog(null, "Alerte bien configuré", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);
  
    }
}
