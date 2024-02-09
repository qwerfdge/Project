import PageObject.SocialPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialPageTest {

    private WebDriver driver;
    private SocialPage socialPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64/");
        driver = new ChromeDriver();
        socialPage = new SocialPage(driver);
        driver.get("https://example.com/social");
    }

    @Test
    public void testSocialButtonsVisibility() {
        Assert.assertTrue(socialPage.isFacebookButtonDisplayed(), "Facebook button is not displayed");
        Assert.assertTrue(socialPage.isYoutubeButtonDisplayed(), "Youtube button is not displayed");
        Assert.assertTrue(socialPage.isInstagramButtonDisplayed(), "Instagram button is not displayed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
