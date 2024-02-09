package PageObject;

// BaseTest.java
// BaseTest.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected SearchResultPage searchResultPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64/");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    protected void addToCart() {
    }

    protected String getProductDescription(String характеристикиТаОпис) {
        return характеристикиТаОпис;
    }

    protected String getProductName(String s) {
        return s;
    }
}
