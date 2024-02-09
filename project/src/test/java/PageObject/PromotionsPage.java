package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PromotionsPage {

    private WebDriver driver;

    // Локаторы элементов на странице
    @FindBy(xpath = "//h1[contains(text(),'Promotions')]")
    private WebElement pageTitle;

    @FindBy(id = "promoCodeInput")
    private WebElement promoCodeInput;

    @FindBy(id = "applyPromoButton")
    private WebElement applyPromoButton;

    @FindBy(id = "promoSuccessMessage")
    private WebElement promoSuccessMessage;

    // Конструктор класса
    public PromotionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Метод для ввода промокода
    public void enterPromoCode(String promoCode) {
        promoCodeInput.sendKeys(promoCode);
    }

    // Метод для применения промокода
    public void applyPromoCode() {
        applyPromoButton.click();
    }

    // Метод для получения текста сообщения об успешном применении промокода
    public String getPromoSuccessMessage() {
        return promoSuccessMessage.getText();
    }
}


