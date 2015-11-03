package IHM.listeners;

import database.MysqlConnecter;
import database.MysqlRequester;
import model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        MysqlRequester.insertItineraireFavorit(client_actuel, id_station_depart, id_station_arrivee);

        JOptionPane confirm;
        confirm = new JOptionPane();
        ImageIcon img = new ImageIcon("images/cloud_alert.png");
        confirm.showMessageDialog(null, "Itinéraire bien enregistré dans vos favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);
    }
}
