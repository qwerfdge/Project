package PageObject;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class FavoritesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"react-portal\"]/div[2]/div/div/div[2]/div/div/ul/li[1]/div/button")
    private WebElement loginPopup;

    @FindBy(xpath = "//*[@id=\"react-portal\"]/div[4]/div/div/div[2]/div/div/div/div[1]/div/button/svg/path")
    private WebElement closeLoginPopup;

    @FindBy(xpath = "//*[@id=\"page-block\"]/div/div[2]/div[1]/div/div[3]/div[2]/div[1]/div/div[1]/div/div[2]/div/div/span")
    private WebElement addToFavoriteButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[1]/div[1]/span")
    private WebElement inFavorite;

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInFavorites() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(inFavorite));
        return inFavorite.isDisplayed();
    }

    public boolean isProductRemoveFromFavorite() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addToFavoriteButton));
        return addToFavoriteButton.isDisplayed();
    }

    public void clickAddToFavorite() {
        addToFavoriteButton.click();
    }

    public void removeFromFavorite() {
        inFavorite.click();
    }

    public WebElement getAddToFavoriteButton() {
        return addToFavoriteButton;
    }

    public boolean isLoginPopupDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(loginPopup));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void closeLoginPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(closeLoginPopup)).click();
    }



}