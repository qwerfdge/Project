import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class SocialIntegrationTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");

    }

    @Test
    public void testSocialIntegration() {

        WebElement shareButton = driver.findElement(By.id("shareButton"));
        shareButton.click();

       


        WebElement socialMediaLoginButton = driver.findElement(By.id("socialMediaLoginButton"));
        socialMediaLoginButton.click();


        WebElement successMessage = driver.findElement(By.id("successMessage"));
        assertTrue(successMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
