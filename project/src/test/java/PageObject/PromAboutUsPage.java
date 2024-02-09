package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PromAboutUsPage {
    private final WebDriver driver;

    // Локаторы элементов на странице
    private final By aboutUsHeaderLocator = By.xpath("//h1[contains(text(),'О нас')]");
    private final By aboutUsContentLocator = By.xpath("//div[@class='about-us-content']");

    // Конструктор класса
    public PromAboutUsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для проверки наличия элементов на странице
    public boolean isAboutUsHeaderDisplayed() {
        return driver.findElement(aboutUsHeaderLocator).isDisplayed();
    }

    public boolean isAboutUsContentDisplayed() {
        return driver.findElement(aboutUsContentLocator).isDisplayed();
    }
}

