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

public class NavigationTest {

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
    public void testNavigationToComputerLiterature() {

        WebElement computerLiteratureLink = driver.findElement(By.linkText("Компьютерные книги"));
        computerLiteratureLink.click();

        String expectedUrl = "https://prom.ua/Kompyuternaya-literatura";
        wait.until(ExpectedConditions.textToBePresentInElement("https://prom.ua/Kompyuternaya-literatura"));
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}