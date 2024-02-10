package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SocialPage {

    private final WebDriver driver;

    @FindBy(css = "a[href='https://www.facebook.com/prom.ua']")
    private WebElement facebookButton;

    @FindBy(css = "a[href='https://www.youtube.com/prom4ua']")
    private WebElement youtubeButton;

    @FindBy(css = "a[href='https://www.instagram.com/prom.pompom/']")
    private WebElement instagramButton;

    public SocialPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFacebookButtonDisplayed() {
        return facebookButton.isDisplayed();
    }

    public boolean isYoutubeButtonDisplayed() {
        return youtubeButton.isDisplayed();
    }

    public boolean isInstagramButtonDisplayed() {
        return instagramButton.isDisplayed();
    }
}


