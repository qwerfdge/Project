package PageObject;

// ProductPage.java
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean addToFavorites() {
        // Реализация метода добавления товара в избранное на странице товара
        return false;
    }

    public void addToCart() {
    }
}

