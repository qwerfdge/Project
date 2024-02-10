package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromAboutUsPage {
    private final WebDriver driver;

    // Локатори елементів на сторінці
    @FindBy(xpath = "//h1[contains(text(),'О нас')]")
    private WebElement aboutUsHeader;

    @FindBy(xpath = "//div[@class='about-us-content']")
    private WebElement aboutUsContent;

    // Конструктор класу
    public PromAboutUsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для перевірки видимості заголовка "Про нас"
    public boolean isAboutUsHeaderDisplayed() {
        return aboutUsHeader.isDisplayed();
    }

    // Метод для перевірки видимості контенту "Про нас"
    public boolean isAboutUsContentDisplayed() {
        return aboutUsContent.isDisplayed();
    }
}
