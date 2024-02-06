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

public class AddToFavoritesTest {

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
    public void testAddToFavorites() {

        WebElement product = driver.findElement(By.cssSelector(".product-item"));


        WebElement addToFavoritesButton = product.findElement(By.cssSelector(".add-to-favorites-button"));


        Assert.assertTrue(addToFavoritesButton.isDisplayed());


        addToFavoritesButton.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".favorite-added-message")));


        WebElement favoriteAddedMessage = driver.findElement(By.cssSelector(".favorite-added-message"));
        Assert.assertTrue(favoriteAddedMessage.isDisplayed());
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

