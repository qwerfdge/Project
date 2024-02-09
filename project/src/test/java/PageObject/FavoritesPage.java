package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavoritesPage {
    private WebDriver driver;
    private By favoriteItems = By.cssSelector(".favorite-item");

    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInFavorites(String productName) {
        WebElement productElement = driver.findElement(By.xpath("//div[@class='favorite-item' and contains(text(),'" + productName + "')]"));
        return productElement != null;
    }
}