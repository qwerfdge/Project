import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PromAboutUsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the Chrome driver
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64/");

        // Initialize the driver instance and open the "About Us" page
        driver = new ChromeDriver();
        driver.get("https://prom.ua/ua/about_us");
    }

    @Test
    public void testAboutUsPageElements() {
        // Check the presence of the "About Us" header
        Assert.assertTrue(isAboutUsHeaderDisplayed(), "The 'About Us' header is displayed");

        // Check the presence of the content on the "About Us" page
        Assert.assertTrue(isAboutUsContentDisplayed(), "The content on the 'About Us' page is displayed");
    }

    private boolean isAboutUsHeaderDisplayed() {
        // Logic to check the presence of the "About Us" header
        // For example, you can use element search by its ID or CSS selector
        return driver.findElement(By.id("aboutUsHeader")).isDisplayed();
    }

    private boolean isAboutUsContentDisplayed() {
        // Logic to check the presence of the content on the "About Us" page
        // For example, you can use element search by its ID or CSS selector
        return driver.findElement(By.id("aboutUsContent")).isDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver
        driver.quit();
    }
}