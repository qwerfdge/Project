import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");
        login();
    }

    @Test
    public void testLogout() {
        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        logoutButton.click();


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    private void login() {

    }
}
