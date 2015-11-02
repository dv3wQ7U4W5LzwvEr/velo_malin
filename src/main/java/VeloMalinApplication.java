import was.ServiceWeb;

import java.util.Timer;

/**
 * Created by florian on 2015-09-29.
 */
public class VeloMalinApplication {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new ServiceWeb(), 0, 10000);
    }
}

