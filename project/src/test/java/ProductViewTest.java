import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductViewTest extends BaseTest {

    public ProductViewTest(WebDriver driver) {

    }

    @Test
    public void testViewProductDetails() {
        // Переходимо на сторінку товару
        driver.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");

        // Створюємо екземпляр сторінки товару
        ProductViewTest productPage = new ProductViewTest(driver);

        // Отримуємо назву та опис товару
        String productName = productPage.getProductName("Stilars 525 Гармата ");
        String productDescription = productPage.getProductDescription("Виробник\n" +
                "Stilars\n" +
                "Колір: Блискучий\n" +
                "\n" +
                "Матеріал: латунь Ливарна - метал в масі\n" +
                "\n" +
                "Розмір: Ширина 10 CM X Висота 22 CM");

        // Перевіряємо, що назва та опис не є порожніми
        Assert.assertFalse(productName.isEmpty(), "Назва товару не знайдена");
        Assert.assertFalse(productDescription.isEmpty(), "Опис товару не знайдено");

        // Додаємо товар у кошик
        productPage.addToCart();

        // Додавання асерта для перевірки успішного додавання товару у кошик
        Assert.assertTrue(Boolean.parseBoolean("//*[@id=\"page-block\"]/div/div[2]/div[1]/div/div[3]/div[2]/div[1]/div/div[5]/div/div[2]/button"));
    }

    private String getProductDescription(String s) {
        return s;
    }

    private void addToCart() {

    }

    private String getProductName(String s) {
        return null;
    }
}
