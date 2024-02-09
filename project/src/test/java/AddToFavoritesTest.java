import PageObject.LoginPage;
import PageObject.ProductPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public final class AddToFavoritesTest extends BaseTest {

    private final LoginPage loginPage;
    private final ProductPage productPage;

    public AddToFavoritesTest(LoginPage loginPage, ProductPage productPage) {
        this.loginPage = loginPage;
        this.productPage = productPage;
    }

    @Test
    public void testAddToFavorites() {

        loginPage.login("Anastasia", "Mar19742005");


        loginPage.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");


        productPage.addToFavorites();


        assertTrue(productPage.addToFavorites(), "Failed to add product to favorites");
    }
}


