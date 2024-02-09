// CartTest.java

import PageObject.CartPage;
import PageObject.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddToCart() {
        // Переходим на страницу товара
        driver.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");

        // Создаем экземпляр страницы товара
        ProductPage productPage = new ProductPage(driver);

        // Добавляем товар в корзину
        productPage.addToCart();

        // Переходим на страницу корзины
        driver.get("https://prom.ua/ua/shopping_cart/checkout/745785583?type=adaptive&source=portal&companyId=2370549");

        // Создаем экземпляр страницы корзины
        CartPage cartPage = new CartPage(driver);

        // Проверяем, что товар добавлен в корзину
        int expectedCartItemsCount = 1;
        int actualCartItemsCount = cartPage.getCartItemsCount();
        Assert.assertEquals(actualCartItemsCount, expectedCartItemsCount, "Количество товаров в корзине  соответствует ожидаемому");
    }
}

