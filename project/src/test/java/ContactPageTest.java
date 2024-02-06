import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactPageTest {

    private WebDriver driver;
    private WebElement phoneElement;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");

        driver = new ChromeDriver();

        driver.get("https://prom.ua/contact_us");
    }

    @Test
    public void testContactPage() {

        assert driver.getTitle().contains("Контактная информация");

        // Находим элементы контактной информации (например, адрес, телефон, email)
        WebElement addressElement = driver.findElement(By.cssSelector("Харьковское шоссе,"));
        WebElement emailElement = driver.findElement(By.cssSelector(". s@prom.ua"));


        assert addressElement.isDisplayed();
        assert phoneElement.isDisplayed();
        assert emailElement.isDisplayed();


    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

