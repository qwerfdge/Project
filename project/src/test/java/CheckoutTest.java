// CheckoutTest.java

import PageObject.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout() {
        // Переходим на сторінку оформлення замовлення
        driver.get("https://prom.ua/ua/shopping_cart/checkout/745785583?type=adaptive&source=portal&companyId=2370549");

        // Створюємо екземпляр сторінки оформлення замовлення
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Заповнюємо форму оформлення замовлення
        checkoutPage.fillCheckoutForm("Anastasia", "Brekher", "123 Main St", "Any town", "12345");

        // Отримуємо URL-адресу поточної сторінки після відправлення замовлення
        String currentUrlAfterSubmit = driver.getCurrentUrl();

        // Перевіряємо, чи ми перенаправлені на сторінку підтвердження замовлення
        // Або можемо перевірити наявність підтвердження успішного оформлення на поточній сторінці
        Assert.assertTrue(currentUrlAfterSubmit.contains("confirmation"), "Order submission was not successful");
    }
}
