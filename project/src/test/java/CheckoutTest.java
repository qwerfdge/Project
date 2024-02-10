// CheckoutTest.java

import PageObject.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the checkout page URL
        driver.get("https://prom.ua/ua/shopping_cart/checkout/745785583?type=adaptive&source=portal&companyId=2370549");

        // Create an instance of the CheckoutPage
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Fill the checkout form
        checkoutPage.fillCheckoutForm("Anastasia", "Brekher", "123 Main St", "Any town", "12345");

        // Verify if the order form is filled successfully
        Assert.assertTrue(checkoutPage.isOrderFormFilledSuccessfully(), "Order form was not filled successfully");

        // Submit the order
        checkoutPage.submitOrder();

        // Verify if the user is redirected to the confirmation page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("confirmation"), "User was not redirected to the confirmation page");

        // Close the WebDriver
        driver.quit();
    }
}