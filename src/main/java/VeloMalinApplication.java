import was.WebService;

import java.util.Timer;

/**
 * Created by florian on 2015-09-29.
 */
public class VeloMalinApplication {

  public static void main(String[] args) {
    Timer timer = new Timer();
    timer.schedule(new WebService(), 0, 30000);
  }

}

