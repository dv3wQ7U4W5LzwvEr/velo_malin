package was.velov;

import java.util.Timer;

/**
 * Created by florian on 2015-09-29.
 */
public class VelovApplication {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Velov(), 0, 10000);
    }
}

