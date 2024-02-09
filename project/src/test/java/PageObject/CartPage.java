package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;
    private By cartItems = By.cssSelector(".cart-item");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }
}
