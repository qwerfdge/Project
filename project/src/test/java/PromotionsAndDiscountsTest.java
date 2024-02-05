import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class PromotionsAndDiscountsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");
        // Другие предварительные настройки, если необходимо
    }

    @Test
    public void testPromotionsAndDiscounts() {

        WebElement discountedProductLink = driver.findElement(By.xpath("https://prom.ua/ua/p2028528493-testirovanie-programmnogo-obespecheniya.html"));
        discountedProductLink.click();




        WebElement discountedPrice = driver.findElement(By.xpath("<span class=\"yzKb6\">527</span>"));
        assertEquals("527.68", discountedPrice.getText()); // Замените на фактическую акционную цену


        WebElement originalPrice = driver.findElement(By.xpath("<span class=\"yzKb6\">544</span>"));
        assertEquals("544.00", originalPrice.getText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
