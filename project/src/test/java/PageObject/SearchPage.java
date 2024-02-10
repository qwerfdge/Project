package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public abstract class SearchPage extends BasePage {
    @FindBy(css = "input[name='q']")
    private WebElement searchInput;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//h1[contains(@class, 'search-results-title')]//span")
    private List<WebElement> searchResults;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void performSearch(String searchQuery) {
        searchInput.sendKeys(searchQuery);
        searchButton.click();
    }

    public boolean areSearchResultsDisplayed() {
        return !searchResults.isEmpty() && searchResults.get(0).isDisplayed();
    }

    public boolean areSearchResultsMatchingQuery(String searchQuery) {
        for (WebElement result : searchResults) {
            if (!result.getText().contains(searchQuery)) {
                return false;
            }
        }
        return true;
    }
}
