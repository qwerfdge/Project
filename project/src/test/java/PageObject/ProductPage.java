package PageObject;

// ProductPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToFavorites() {
        // Реализация метода добавления товара в избранное на странице товара
    }

    public void addToCart() {
    }
}

