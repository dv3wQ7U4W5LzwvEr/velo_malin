package was.google_map_api;

import model.Localisation;

/**
 * Created by laurel on 04/11/2015.
 */
public class GoogleMapApi {


    public static Localisation rechercherLatLongParAdresse(final String adresse) {
        GoogleMapEngine googleMapEngine = GoogleMapEngine.getInstance();
        return googleMapEngine.rechercherLatLongParAdresse(adresse);
    }

    public static String rechercherAdresseParLatLong(double latitude, double longitude)
    {
        GoogleMapEngine googleMapEngine = GoogleMapEngine.getInstance();
        return googleMapEngine.rechercherAdresseParLatLong(latitude, longitude);
    }
}
