import PageObject.LoginPage;
import PageObject.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToFavoritesTest extends BaseTest {

    @Test
    public void testAddToFavorites() {
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login("Anastasia", "Mar19742005");

        driver.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");


        boolean isAddedToFavorites = productPage.addToFavorites();


        Assert.assertTrue(isAddedToFavorites, "Товар успішно додано до списку улюблених");

        driver.quit();
    }
}