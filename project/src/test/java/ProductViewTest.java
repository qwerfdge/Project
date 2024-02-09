import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductViewTest extends BaseTest {

    @Test
    public void testViewProductDetails() {
        // Переходимо на сторінку товару
        driver.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");

        // Перевіряємо, що назва та опис товару присутні на сторінці
        WebElement productNameElement = driver.findElement(By.xpath("//h1[@class='product__title']"));
        Assert.assertNotNull(productNameElement, "Назва товару не знайдена на сторінці");

        WebElement productDescriptionElement = driver.findElement(By.xpath("//div[@class='product__description']"));
        Assert.assertNotNull(productDescriptionElement, "Опис товару не знайдено на сторінці");


        addToCart();


        WebElement addToCartButton = driver.findElement(By.xpath("//button[@data-action='buy']"));
        Assert.assertNotNull(addToCartButton, "Кнопка додавання у кошик знайдена на сторінці");
    }

    private void addToCart() {

    }
}
