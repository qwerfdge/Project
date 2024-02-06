import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        // Создание экземпляра WebDriver
        driver = new ChromeDriver();
        // Открытие страницы для тестирования
        driver.get("https://prom.ua/");
    }

    @Test
    public void testLogin() {
        // Находим и кликаем по ссылке "Вход"
        WebElement loginLink = driver.findElement(By.id("https://prom.ua/?source=user_sidebar"));
        loginLink.click();


        WebElement usernameInput = driver.findElement(By.id("Anastasia"));


        WebElement passwordInput = driver.findElement(By.id("Mar19742005"));
        passwordInput.sendKeys("Mar19742005");


        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();


    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
