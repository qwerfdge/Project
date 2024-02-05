import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductDetailsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");
        // Другие предварительные настройки, если необходимо
    }

    @Test
    public void testViewProductDetails() {
        // Найдите товар, который вы хотите протестировать
        WebElement productLink = driver.findElement(By.xpath("https://prom.ua/ua/p1667051712-binokl-dlya-nablyudeniya.html"));
        productLink.click();




        String expectedPageTitle = "Бінокль для спостереження, 8X40 GALILEO W7, бінокль для полювання та туризму";
        assertEquals(expectedPageTitle, driver.getTitle());


        WebElement productName = driver.findElement(By.xpath("https://prom.ua/ua/p1667051712-binokl-dlya-nablyudeniya.html"));
        assertTrue(productName.isDisplayed());

        WebElement productPrice = driver.findElement(By.xpath("<span class=\"yzKb6\">809</span>"));
        assertTrue(productPrice.isDisplayed());



        WebElement addToCartButton = driver.findElement(By.id("addToCartButton"));
        addToCartButton.click();



        // Проверьте, что товар добавлен в корзину (пример)
        WebElement cartItemCount = driver.findElement(By.id("https://prom.ua/ua/shopping_cart/checkout/744328668?type=adaptive&source=portal&companyId=3610387"));
        assertEquals("1", cartItemCount.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

