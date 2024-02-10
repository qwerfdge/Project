// CartTest.java
import PageObject.CartPage;
import PageObject.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddToCart() {

        WebDriver driver = null;
        driver.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");


        ProductPage productPage = new ProductPage(driver);


        boolean isAddedToCart = productPage.addToCart();


        Assert.assertTrue(isAddedToCart, "Failed to add product to cart");

        driver.get("https://prom.ua/ua/shopping_cart/checkout/745785583?type=adaptive&source=portal&companyId=2370549");

        CartPage cartPage = new CartPage(driver);


        int expectedCartItemsCount = 1;
        int actualCartItemsCount = cartPage.getCartItemsCount();
        Assert.assertEquals(actualCartItemsCount, expectedCartItemsCount, "Number of items in the cart does not match the expected count");
    }
}