package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By cartItems = By.cssSelector(".cart-item");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartItemsCount() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size();
    }
}
