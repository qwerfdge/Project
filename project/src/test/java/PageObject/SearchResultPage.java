package PageObject;

// SearchResultPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    private WebDriver driver;
    private By searchResults = By.cssSelector(".search-result");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getSearchResultsCount() {
        List<WebElement> results = driver.findElements(searchResults);
        return results.size();
    }

    public void openSortingOptions() {
    }

    public void openSortingOptions(String option) {
    }

    public void openSortingOptions(String option) {
    }
}

