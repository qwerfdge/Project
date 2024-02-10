import PageObject.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUpHomePage() {
        WebDriver driver = null;
        homePage = new HomePage(driver);
    }

    @Test
    public void testSearch() {
        String searchTerm = "книга";
        homePage.searchFor(searchTerm);

        // Get the actual search results count
        int searchResultsCount = homePage.getSearchResultsCount();

        Assert.assertTrue(searchResultsCount > 0, "Результати пошуку знайдені");
    }
}