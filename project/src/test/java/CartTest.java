// CartTest.java

import PageObject.CartPage;
import PageObject.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddToCart() {
        // Переходим на сторінку товару
        driver.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");

        // Створюємо екземпляр сторінки товару
        ProductPage productPage = new ProductPage(driver);

        // Додаємо товар до корзини
        productPage.addToCart();

        // Переходимо на сторінку корзини
        driver.get("https://prom.ua/ua/shopping_cart/checkout/745785583?type=adaptive&source=portal&companyId=2370549");

        // Створюємо екземпляр сторінки корзини
        CartPage cartPage = new CartPage(driver);

        // Перевіряємо, що товар додано в корзину
        int expectedCartItemsCount = 1;
        int actualCartItemsCount = cartPage.getCartItemsCount();
        Assert.assertEquals(actualCartItemsCount, expectedCartItemsCount, "Кількість товарів у корзині відповідає очікуваній");
    }
}
