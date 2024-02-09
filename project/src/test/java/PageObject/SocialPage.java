package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SocialPage {

    private final WebDriver driver;

    public SocialPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFacebookButtonDisplayed() {
        WebElement facebookButton = driver.findElement(By.cssSelector("a[href='https://www.facebook.com/prom.ua']"));
        return facebookButton.isDisplayed();
    }

    public boolean isYoutubeButtonDisplayed() {
        WebElement youtubeButton = driver.findElement(By.cssSelector("a[href='https://www.youtube.com/prom4ua']"));
        return youtubeButton.isDisplayed();
    }

    public boolean isInstagramButtonDisplayed() {
        WebElement instagramButton = driver.findElement(By.cssSelector("a[href='https://www.instagram.com/prom.pompom/']"));
        return instagramButton.isDisplayed();
    }
}

