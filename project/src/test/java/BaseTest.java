import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/");
        ChromeOptions options = new ChromeOptions();

        webDriver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() {

        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
