import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutProcessTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10);

        driver.get("https://prom.ua/");
    }

    @Test
    public void testCheckoutProcess() {
        // Находим элемент товара (например, первый элемент из результатов поиска)
        WebElement product = driver.findElement(By.cssSelector(".product-item"));

        // Находим кнопку "Добавить в корзину"
        WebElement addToCartButton = product.findElement(By.cssSelector(".add-to-cart-button"));

        // Кликаем на кнопку "Добавить в корзину"
        addToCartButton.click();

        // Ожидаем, пока сообщение о добавлении в корзину появится
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("Товар ")));

        // Находим кнопку "Оформить заказ"
        WebElement checkoutButton = driver.findElement(By.cssSelector(".checkout-button"));

        // Кликаем на кнопку "Оформить заказ"
        checkoutButton.click();

        // Ожидаем, пока страница оформления заказа загрузится
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkout-page")));

        // Проверяем, что страница оформления заказа отображается
        WebElement checkoutPage = driver.findElement(By.cssSelector(".checkout-page"));
        Assert.assertTrue(checkoutPage.isDisplayed());

        // Заполняем форму оформления заказа (данные для тестирования)
        WebElement fullNameInput = driver.findElement(By.id("fullName"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement addressInput = driver.findElement(By.id("address"));
        WebElement phoneNumberInput = driver.findElement(By.id("phoneNumber"));
        WebElement submitOrderButton = driver.findElement(By.cssSelector(".submit-order-button"));

        fullNameInput.sendKeys("John Doe");
        emailInput.sendKeys("johndoe@example.com");
        addressInput.sendKeys("123 Main St");
        phoneNumberInput.sendKeys("1234567890");

        // Кликаем на кнопку "Оформить заказ"
        submitOrderButton.click();

        // Ожидаем, пока сообщение об успешном оформлении заказа появится
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-success-message")));

        // Проверяем, что сообщение об успешном оформлении заказа отображается
        WebElement orderSuccessMessage = driver.findElement(By.cssSelector(".order-success-message"));
        Assert.assertTrue(orderSuccessMessage.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        // Закрытие браузера после выполнения теста
        driver.quit();
    }
}
