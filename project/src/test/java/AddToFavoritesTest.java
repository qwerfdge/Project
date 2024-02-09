import PageObject.LoginPage;
import PageObject.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToFavoritesTest extends BaseTest {

    private LoginPage loginPage;
    private  ProductPage productPage;

    public AddToFavoritesTest(LoginPage loginPage, ProductPage productPage) {
        this.loginPage = loginPage;
        this.productPage = productPage;
    }

    @Test
    public void testAddToFavorites() {

        loginPage.login("Anastasia", "Mar19742005");
        loginPage.get("https://prom.ua/ua/p347760680-stilars-525-pushka.html");


        boolean isAddedToFavorites = productPage.addToFavorites();


        Assert.assertTrue(isAddedToFavorites, "Failed to add product to favorites");
    }
}
