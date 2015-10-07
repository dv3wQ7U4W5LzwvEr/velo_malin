package was;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebService {
  private String contract;

  private String apiKey = "&apiKey=fa1d875bef00abe2c7a281f1087bcc122f62379a";

  private String requestBase = "https://213.41.121.85/vls/v1/stations?";
  // private String requestBase = "https://api.jcdecaux.com/vls/v1/stations?";

  public void run()
  {
    try
    {
      HttpClient client = new DefaultHttpClient();
      HttpGet request = new HttpGet(buildRequest());
      HttpResponse response = client.execute(request);
      BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
      String line = "";
      while ((line = rd.readLine()) != null) {
        System.out.println(line);
      }

      JSONObject json = new JSONObject();
      json.put("name1", "value1");
      json.put("name2", "value2");
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }

  private String buildRequest()
  {
    String request = requestBase + apiKey;
    return request;
  }
}
