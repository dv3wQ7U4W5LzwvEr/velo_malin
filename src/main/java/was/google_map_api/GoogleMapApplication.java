package was.google_map_api;


import java.util.Timer;

/**
 * Created by laurel on 04/11/2015.
 */
public class GoogleMapApplication {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new GoogleMap(), 0, 10000);
    }
}
