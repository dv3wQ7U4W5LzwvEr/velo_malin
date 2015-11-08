package IHM.panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by tof on 03/11/2015.
 */
public class EcouteurBoutonLancerRecherche implements ActionListener {
    private String adresse_depart;
    private String adresse_arrivee;
	private Date date;
	//private Time heure;
    
    public EcouteurBoutonLancerRecherche(String adresse_depart, String adresse_arrivee, Date date) {
        this.adresse_depart = adresse_depart;
        this.adresse_arrivee = adresse_arrivee;
        this.date = date;
        //this.heure = heure;
    }

    public void actionPerformed(ActionEvent e) {
    	
    	 ImageIcon img = new ImageIcon("src/main/resources/img/cloud_alert.png");
	     JOptionPane.showMessageDialog(null, "TEST" + adresse_depart + "/" + adresse_arrivee, "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);

    }
}
