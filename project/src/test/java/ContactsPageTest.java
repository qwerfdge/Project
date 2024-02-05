import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContactsPageTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");

    }

    @Test
    public void testContactPageContent() {

        WebElement contactForm = driver.findElement(By.id("contactForm"));
        assertTrue(contactForm.isDisplayed());

        WebElement contactDetails = driver.findElement(By.id("contactDetails"));
        assertTrue(contactDetails.isDisplayed());


        WebElement address = driver.findElement(By.xpath("//div[@id='contactDetails']/p[contains(text(),'123 Main Street')]"));
        assertEquals("123 Main Street", address.getText());

        // Проверьте, что указан корректный номер телефона
        WebElement phoneNumber = driver.findElement(By.xpath("//div[@id='contactDetails']/p[contains(text(),'Phone: +123456789')]"));
        assertEquals("Phone: +123456789", phoneNumber.getText());

        // Проверьте, что указана корректная электронная почта
        WebElement emailAddress = driver.findElement(By.xpath("//div[@id='contactDetails']/p[contains(text(),'Email: info@example.com')]"));
        assertEquals("Email: info@example.com", emailAddress.getText());

        // Заполните и отправьте форму обратной связи (если применимо)
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.sendKeys("John Doe");

        WebElement emailInput = driver.findElement(By.id("emailInput"));
        emailInput.sendKeys("john.doe@example.com");

        WebElement messageInput = driver.findElement(By.id("messageInput"));
        messageInput.sendKeys("Test message for contact form.");

        WebElement submitButton = driver.findElement(By.id("submitButton"));
        submitButton.click();



        WebElement confirmationMessage = driver.findElement(By.id("confirmationMessage"));
        assertTrue(confirmationMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

