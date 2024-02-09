package PageObject;


import PageObject.components.Header;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class LogoutPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"react-portal\"]/div[2]/div/div/div[2]/div/div/ul/li[1]/ul/li/div/div/div/div/div[2]/a")
    private WebElement accountButton;

    @FindBy(xpath = "//*[@id=\"react-portal\"]/div[2]/div/div/div[2]/div/div/ul/li[7]/a/div/div[2]/span")
    private WebElement logoutOption;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }


    public boolean isUserLoggedIn() {
        try {
            return accountButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void logout() {
        Header header = new Header(driver) {
            @Override
            public void get(String url) {

            }
        };
        header.clickAccountButton();
        header.waitForVisibility(logoutOption);
        logoutOption.click();
    }
}