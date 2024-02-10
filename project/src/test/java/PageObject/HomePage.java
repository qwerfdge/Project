package PageObject;

// HomePage.java
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By searchInput = By.name("q");
    private By searchButton = By.cssSelector(".search__button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String query) {
        WebElement searchInputField = driver.findElement(searchInput);
        searchInputField.clear(); // Очистка поля вводу перед введенням нового запиту
        searchInputField.sendKeys(query);
        searchInputField.sendKeys(Keys.ENTER);
    }

    public int getSearchResultsCount() {
        return 0;
    }
}


