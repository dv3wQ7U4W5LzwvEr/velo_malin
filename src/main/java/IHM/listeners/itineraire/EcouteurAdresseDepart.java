package IHM.listeners.itineraire;

import was.google_map_api.GoogleMapApi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by laurel on 03/11/2015.
 */
public class EcouteurAdresseDepart implements ActionListener {

    public EcouteurAdresseDepart() {
    }

    public void actionPerformed(ActionEvent e) {
        String adresse = "";
        GoogleMapApi.rechercherLatLongParAdresse(adresse);

    }
}
