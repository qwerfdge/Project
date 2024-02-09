import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PromLoginTest {
    private WebDriver driver;
    private PromLoginTest loginPage;

    public PromLoginTest(WebDriver driver) {
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64/");
        driver = new ChromeDriver();
        loginPage = new PromLoginTest(driver);
        driver.get("https://prom.ua/?source=user_sidebar");
    }

    @Test
    public void testLogin() {
        loginPage.setUsername("Anastasia");
        loginPage.setPassword("Mar19742005");
        loginPage.clickLoginButton();

        // Додайте асерт для перевірки успішного входу користувача
        boolean isUserLoggedIn = isUserLoggedIn();
        Assert.assertTrue(isUserLoggedIn, "Користувач успішно увійшов");
    }

    private boolean isUserLoggedIn() {
        // Реалізуйте перевірку наявності елемента або тексту, що свідчить про успішний вхід користувача
        return true;
    }

    private void clickLoginButton() {
        // Логіка натискання кнопки входу
    }

    private void setPassword(String mar19742005) {
        // Логіка встановлення паролю
    }

    private void setUsername(String Anastasia) {
        // Логіка встановлення імені користувача
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
