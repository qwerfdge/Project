import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PromotionAndDiscountTest {

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
    public void testPromotionAndDiscount() {

        WebElement promotionProduct = driver.findElement(By.cssSelector("https://prom.ua/p1704441850-mustela-stick-cold.html"));


        assert promotionProduct.isDisplayed();


        assert promotionProduct.findElement(By.cssSelector("скидка")).isDisplayed();


        promotionProduct.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".https://prom.ua/p1704441850-mustela-stick-cold.html")));


        assert driver.getCurrentUrl().contains("https://prom.ua/p1704441850-mustela-stick-cold.html");


    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

