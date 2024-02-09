// CheckoutTest.java
import PageObject.BaseTest;
import PageObject.CheckoutPage;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout() {
        // Переходим на страницу оформления заказа
        driver.get("https://prom.ua/ua/shopping_cart/checkout/745785583?type=adaptive&source=portal&companyId=2370549");

        // Создаем экземпляр страницы оформления заказа
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Заполняем форму оформления заказа
        checkoutPage.fillCheckoutForm("Anastasia", "Brekher", "123 Main St", "Anytown", "12345");

        // Отправляем заказ
        checkoutPage.submitOrder();

    }
}

