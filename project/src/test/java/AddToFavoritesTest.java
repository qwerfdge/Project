import PageObject.LoginPage;
import PageObject.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToFavoritesTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testAddToFavorites() {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login("Anastasia", "Mar19742005");

        driver.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");

        boolean isAddedToFavorites = productPage.addToFavorites();

        Assert.assertTrue(isAddedToFavorites, "Товар успішно додано до списку улюблених");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
