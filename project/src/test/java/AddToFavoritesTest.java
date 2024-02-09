
import PageObject.BaseTest;
import PageObject.LoginPage;
import PageObject.ProductPage;
import org.testng.annotations.Test;

public class AddToFavoritesTest extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;

    @Test
    public void testAddToFavorites() {
        loginPage.login("Anastasia", "Mar19742005");

        driver.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");

        productPage.addToFavorites();


    }
}

