package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class SearchPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"page-block\"]/div/header/div[1]/div/div[2]/div/div/div[2]/div/div[1]/form/div/div[2]/div/input")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"page-block\"]/div/header/div[1]/div/div[2]/div/div/div[2]/div/div/form/div/div[4]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"page-block\"]/div/div[2]/div/div[3]/div/div/h1/span")
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
