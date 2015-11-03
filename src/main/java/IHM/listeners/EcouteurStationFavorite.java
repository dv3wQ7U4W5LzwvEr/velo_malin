package IHM.listeners;

import database.MysqlConnecter;
import database.MysqlRequester;
import model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laurel on 03/11/2015.
 */
public class EcouteurStationFavorite implements ActionListener{
    private int id_station;

    public EcouteurStationFavorite(int id_station) {
        // TODO Auto-generated constructor stub
        this.id_station = id_station;
    }

    public void actionPerformed(ActionEvent e) {
        Client client_actuel;
        client_actuel = new Client();

        //List<Integer> liste_stationsfavoris = new ArrayList<Integer>();
        //liste_stationsfavoris = MysqlRequester.getListeStationsFavories();
        
        MysqlRequester.insertStationFavorite(client_actuel, id_station);
        
        JOptionPane confirm;
        confirm = new JOptionPane();
        ImageIcon img = new ImageIcon("images/cloud_alert.png");
        
        confirm.showMessageDialog(null, "Station bien enregistrée dans vos favoris", "Confirmation", JOptionPane.INFORMATION_MESSAGE, img);
        
        
        
        //onglets.setSelectedIndex( int i); //pour basculer d'un onglet à un autre

    }

}
