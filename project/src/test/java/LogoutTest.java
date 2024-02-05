import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LogoutTest {

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
    public void testLogout() {

        WebElement logoutButton = driver.findElement(By.id("https://prom.ua/?source=user_sidebar"));
        logoutButton.click();


        WebElement loginLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("https://prom.ua/")));
        assertEquals("https://prom.ua/", driver.getCurrentUrl());
        System.out.println(loginLink);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
