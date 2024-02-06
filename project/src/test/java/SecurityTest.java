import org.testng.annotations.Test;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

public class SecurityTest {

    @Test
    public void testSSL() {
        try {

            URL url = new URL("https://prom.ua/");

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            assert connection.getResponseCode() == 200;

            assert connection.getCipherSuite() != null;

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

