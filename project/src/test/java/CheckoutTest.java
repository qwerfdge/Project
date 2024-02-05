import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");

    }

    @Test
    public void testCheckoutProcess() {

        addToCart("Product A", 2);


        WebElement cartLink = driver.findElement(By.id("cartLink"));
        cartLink.click();


        WebElement checkoutButton = driver.findElement(By.id("checkoutButton"));
        checkoutButton.click();


        WebElement firstNameInput = driver.findElement(By.id("firstNameInput"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("lastNameInput"));
        lastNameInput.sendKeys("Doe");

        WebElement addressInput = driver.findElement(By.id("addressInput"));
        addressInput.sendKeys("123 Main Street");

        WebElement cityInput = driver.findElement(By.id("cityInput"));
        cityInput.sendKeys("Cityville");

        WebElement zipCodeInput = driver.findElement(By.id("zipCodeInput"));
        zipCodeInput.sendKeys("12345");

        WebElement paymentMethodDropdown = driver.findElement(By.id("paymentMethodDropdown"));
        paymentMethodDropdown.selectByVisibleText("Credit Card");


        WebElement payButton = driver.findElement(By.id("payButton"));
        payButton.click();


        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='confirmation-message']"));
        assertEquals("Your order has been successfully placed.", confirmationMessage.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    private void addToCart(String Бінокль, int quantity) {

    }
}

