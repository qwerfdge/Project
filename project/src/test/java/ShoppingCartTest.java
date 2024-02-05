import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");

    }

    @Test
    public void testShoppingCartManagement() {

        addToCart("https://prom.ua/ua/p1667051712-binokl-dlya-nablyudeniya.html", 1);


        WebElement cartLink = driver.findElement(By.id("<span class=\"zkpK2\" data-qaid=\"title\">Кошик</span>"));
        cartLink.click();


        WebElement cartProduct = driver.findElement(By.xpath("https://prom.ua/ua/shopping_cart/checkout/744328668?type=adaptive&source=portal&companyId=3610387"));
        assertEquals("https://prom.ua/ua/p1667051712-binokl-dlya-nablyudeniya.html", cartProduct.getText());


        WebElement cartProductQuantity = driver.findElement(By.xpath("https://prom.ua/ua/p1667051712-binokl-dlya-nablyudeniya.html"));
        assertEquals("1", cartProductQuantity.getAttribute("value"));


        WebElement increaseQuantityButton = driver.findElement(By.id("increaseQuantityButton"));
        increaseQuantityButton.click();




        assertEquals("2", cartProductQuantity.getAttribute("value"));


        WebElement removeProductButton = driver.findElement(By.id("https://prom.ua/?source=user_sidebar"));
        removeProductButton.click();




        WebElement emptyCartMessage = driver.findElement(By.xpath("//div[@class='empty-cart-message']"));
        assertEquals("Your shopping cart is empty.", emptyCartMessage.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    private void addToCart(String productName, int quantity) {
        WebElement productLink = driver.findElement(By.xpath("//div[@class='product']/a[contains(text(),'" + productName + "https://prom.ua/ua/p1667051712-binokl-dlya-nablyudeniya.html"));
        productLink.click();

        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));

        WebElement addToCartButton = driver.findElement(By.id("addToCartButton"));
        addToCartButton.click();

    }
}

