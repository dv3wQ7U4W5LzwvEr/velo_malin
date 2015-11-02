package IHM;
import java.io.IOException;
import javax.servlet.http.*;

/**
 * Created by laurel on 02/11/2015.
 */
public class GoogleMap {

    private String cle = "AIzaSyC0Cwp8aZmmJx7DZXKVsOFxeDmJjzxfSyM";


    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("{ \"name\": \"World\" }");
    }

    public static void main()
    {
        
    }
}
