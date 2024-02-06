import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductDetailsViewTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://prom.ua/");
    }

    @Test
    public void testProductDetailsView() {

        WebElement product = driver.findElement(By.cssSelector("https://prom.ua/p2048745354-luchshij-polevoj-binokl.html"));
        product.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-details")));


        WebElement productDetails = driver.findElement(By.cssSelector(".product-details"));
        Assert.assertTrue(productDetails.isDisplayed());


    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

