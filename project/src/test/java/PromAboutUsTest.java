import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PromAboutUsTest {
    private WebDriver driver;
    private PromAboutUsTest aboutUsPage;

    public PromAboutUsTest(WebDriver driver) {
    }

    @BeforeMethod
    public void setUp() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64/");

        // Инициализация экземпляра драйвера и страницы "О нас"
        driver = new ChromeDriver();
        aboutUsPage = new PromAboutUsTest(driver);

        // Открытие страницы "О нас"
        driver.get("https://prom.ua/ua/about_us");
    }

    @Test
    public void testAboutUsPageElements() {
        // Проверка наличия заголовка "О нас"
        Assert.assertTrue(aboutUsPage.isAboutUsHeaderDisplayed(), "Header 'О нас' is  displayed");

        // Проверка наличия контента на странице "О нас"
        Assert.assertTrue(aboutUsPage.isAboutUsContentDisplayed(), "Content on 'О нас' page  displayed");
    }

    private boolean isAboutUsHeaderDisplayed() {
        return false;
    }

    private boolean isAboutUsContentDisplayed() {
        return false;
    }
        @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
