import PageObject.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SearchTest extends BaseTest {

    private HomePage homePage;

    @Test
    public void testSearch() {

        String searchTerm = "книга";
        homePage.searchFor(searchTerm);


        int searchResultsCount = 0;
        searchResultsCount = searchResultsCount;
        Assert.assertTrue(searchResultsCount > 0, "Результаты поиска  найдены");
    }
}