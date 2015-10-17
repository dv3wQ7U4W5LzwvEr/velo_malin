import was.ServiceWeb;

import java.util.Timer;

/**
 * Created by florian on 2015-09-29.
 */
public class VeloMalinApplication {

  public static void main(String[] args) {
    Timer timer = new Timer();
    ServiceWeb was = new ServiceWeb();
    was.creationDesInformationsSurLesStations();
    timer.schedule(new ServiceWeb(), 0, 100000);
  }

}

