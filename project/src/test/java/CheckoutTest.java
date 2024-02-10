// CheckoutTest.java

import PageObject.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout() {

        WebDriver driver = new ChromeDriver();


        driver.get("https://prom.ua/ua/shopping_cart/checkout/745785583?type=adaptive&source=portal&companyId=2370549");


        CheckoutPage checkoutPage = new CheckoutPage(driver);


        checkoutPage.fillCheckoutForm("Anastasia", "Brekher", "123 Main St", "Any town", "12345");


        Assert.assertTrue(checkoutPage.isOrderFormFilledSuccessfully(), "Order form was not filled successfully");


        checkoutPage.submitOrder();


        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("confirmation"), "User was not redirected to the confirmation page");


        driver.quit();
    }
}