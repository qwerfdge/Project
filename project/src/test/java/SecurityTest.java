import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class SecurityTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
    }

    @Test
    public void testSSL() {

        String websiteUrl = "https://prom.ua/";


        boolean isSSL = checkSSL(websiteUrl);
        assertEquals(true, isSSL);
    }

    private boolean checkSSL(String url) {
        try {
            URL httpsURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) httpsURL.openConnection();
            connection.connect();


            return connection.getResponseCode() == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

