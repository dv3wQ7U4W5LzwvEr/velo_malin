package was.google_map_api;

import model.Localisation;

/**
 * Created by laurel on 04/11/2015.
 */
public class GoogleMapApi {


    public static Localisation rechercherLatLong(final String adresse) {
        GoogleMapEngine googleMapEngine = GoogleMapEngine.getInstance();
        return googleMapEngine.rechercherLatLong(adresse);
    }
}
