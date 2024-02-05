import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class FeedbackFormTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");

    }

    @Test
    public void testFeedbackFormSubmission() {
        // Заполните форму обратной связи
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.sendKeys("Anastasia");

        WebElement emailInput = driver.findElement(By.id("emailInput"));
        emailInput.sendKeys("brehernasta@gmail.com");

        WebElement messageInput = driver.findElement(By.id("messageInput"));
        messageInput.sendKeys("Test message for feedback form.");


        WebElement submitButton = driver.findElement(By.id("submitButton"));
        submitButton.click();


        WebElement successMessage = driver.findElement(By.id("successMessage"));
        assertTrue(successMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

