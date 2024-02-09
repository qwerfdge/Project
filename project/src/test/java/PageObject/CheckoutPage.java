package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private WebDriver driver;
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By addressInput = By.id("address");
    private By cityInput = By.id("city");
    private By zipCodeInput = By.id("zip-code");
    private By submitButton = By.cssSelector(".submit-button");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCheckoutForm(String firstName, String lastName, String address, String city, String zipCode) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(zipCodeInput).sendKeys(zipCode);
    }

    public void submitOrder() {
        driver.findElement(submitButton).click();
    }
}