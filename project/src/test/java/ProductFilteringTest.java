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

public class ProductFilteringTest {

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
    public void testProductFiltering() {

        WebElement categoryFilter = driver.findElement(By.xpath("https://prom.ua/search?search_term=%D0%B1%D0%BB%D0%B5%D0%BD%D0%B4%D0%B5%D1%80&category=64301"));

        categoryFilter.click();


        WebElement electronicsCategory = driver.findElement(By.xpath("https://prom.ua/search?search_term=%D0%B1%D0%BB%D0%B5%D0%BD%D0%B4%D0%B5%D1%80&category=64301"));
        electronicsCategory.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("https://prom.ua/search?search_term=%D0%B1%D0%BB%D0%B5%D0%BD%D0%B4%D0%B5%D1%80&category=64301")));


        WebElement filteredCategory = driver.findElement(By.xpath("https://prom.ua/search?search_term=%D0%B1%D0%BB%D0%B5%D0%BD%D0%B4%D0%B5%D1%80&sort=price&category=64426&binary_filters=discount"));
        Assert.assertTrue(filteredCategory.isDisplayed());
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

