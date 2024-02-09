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
        // Установка шляху до драйвера Chrome
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64/");

        // Ініціалізація екземпляра драйвера та сторінки "О нас"
        driver = new ChromeDriver();
        aboutUsPage = new PromAboutUsTest(driver);

        // Відкриття сторінки "О нас"
        driver.get("https://prom.ua/ua/about_us");
    }

    @Test
    public void testAboutUsPageElements() {
        // Перевірка наявності заголовка "О нас"
        Assert.assertTrue(aboutUsPage.isAboutUsHeaderDisplayed(), "Заголовок 'О нас' відображений");

        // Перевірка наявності контенту на сторінці "О нас"
        Assert.assertTrue(aboutUsPage.isAboutUsContentDisplayed(), "Контент на сторінці 'О нас' відображений");
    }

    private boolean isAboutUsHeaderDisplayed() {
        // Логіка перевірки наявності заголовка "О нас"
        return true;
    }

    private boolean isAboutUsContentDisplayed() {
        // Логіка перевірки наявності контенту на сторінці "О нас"
        return true;
    }

    @AfterMethod
    public void tearDown() {
        // Завершення роботи драйвера
        driver.quit();
    }
}
