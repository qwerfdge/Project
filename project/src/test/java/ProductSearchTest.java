import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductSearchTest {

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
    public void testProductSearch() {

        WebElement searchInput = driver.findElement(By.name("https://prom.ua/?source=user_sidebar"));

        searchInput.sendKeys("краска для обуви");

        searchInput.sendKeys(Keys.ENTER);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("https://prom.ua/Kraska-dlya-obuvi")));


    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
