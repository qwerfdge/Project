package PageObject;
// LoginPage.java
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"registrationConfirmButton\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"react-portal\"]/div[4]/div/div/div[2]/div/div/div/div[2]/div/span")
    private WebElement errorMessage;
    private Alert passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isErrorDisplayed(String expectedErrorMessage) {
        try {
            return errorMessage.isDisplayed() && errorMessage.getText().equals(expectedErrorMessage.trim());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}