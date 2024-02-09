// ProductViewTest.java
import PageObject.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductViewTest extends BaseTest {

    public ProductViewTest(WebDriver driver) {

    }

    @Test
    public void testViewProductDetails() {
        // Переходим на страницу товара
        driver.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");

        // Создаем экземпляр страницы товара
        ProductViewTest productPage = new ProductViewTest(driver);

        // Получаем название и описание товара
        String productName = productPage.getProductName("Stilars 525 Гармата " );
        String productDescription = productPage.getProductDescription("Виробник\n" +
                "Stilars\n" +
                "Колір: Блискучий\n" +
                "\n" +
                "Матеріал: латунь Ливарна - метал в масі\n" +
                "\n" +
                "Розмір: Ширина 10 CM X Висота 22 CM");

        // Проверяем, что название и описание не пустые
        Assert.assertFalse(productName.isEmpty(), "Название товара  найдено");
        Assert.assertFalse(productDescription.isEmpty(), "Описание товара  найдено");

        // Добавляем товар в корзину
        productPage.addToCart();

    }
}

