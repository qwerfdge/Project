// CartTest.java
import PageObject.CartPage;
import PageObject.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddToCart() {
        // Go to the product page
        WebDriver driver = null;
        driver.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");

        // Create an instance of the product page
        ProductPage productPage = new ProductPage(driver);

        // Add the product to the cart
        boolean isAddedToCart = productPage.addToCart();

        // Check if the product is added to the cart
        Assert.assertTrue(isAddedToCart, "Failed to add product to cart");

        // Go to the cart page
        driver.get("https://prom.ua/ua/shopping_cart/checkout/745785583?type=adaptive&source=portal&companyId=2370549");

        // Create an instance of the cart page
        CartPage cartPage = new CartPage(driver);

        // Check if the number of items in the cart matches the expected count
        int expectedCartItemsCount = 1;
        int actualCartItemsCount = cartPage.getCartItemsCount();
        Assert.assertEquals(actualCartItemsCount, expectedCartItemsCount, "Number of items in the cart does not match the expected count");
    }
}