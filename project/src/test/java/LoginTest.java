import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://prom.ua/");
    }

    @Test
    public void testLogin() {
        // Найдем и кликнем по элементу, который вызывает всплывающее окно для входа
        WebElement loginLink = driver.findElement(By.id("https://prom.ua/?source=user_sidebar"));
        loginLink.click();

        // Ожидание, чтобы убедиться, что всплывающее окно появилось
        WebElement loginPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginPopup")));

        // Ввод данных для входа
        WebElement usernameInput = loginPopup.findElement(By.id("Anastasia"));
        WebElement passwordInput = loginPopup.findElement(By.id("Mar19742005"));

        usernameInput.sendKeys("brehernasti@gmail.com");
        passwordInput.sendKeys("Mar19742005.");

        // Отправка формы
        WebElement loginButton = loginPopup.findElement(By.id("loginButton"));
        loginButton.click();

        // Дождитесь, чтобы убедиться, что вход выполнен успешно (пример)
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcomeMessage")));
        System.out.println(welcomeMessage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
