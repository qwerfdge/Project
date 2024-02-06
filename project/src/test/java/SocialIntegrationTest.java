import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialIntegrationTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");

        driver = new ChromeDriver();

        driver.get("https://prom.ua/");
    }

    @Test
    public void testSocialIntegration() {

        WebElement facebookIcon = driver.findElement(By.xpath("https://www.facebook.com/prom.ua"));
        WebElement instagramIcon = driver.findElement(By.xpath("https://www.instagram.com/prom.pompom/"));


        assert facebookIcon.isDisplayed();
        assert instagramIcon.isDisplayed();


    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

