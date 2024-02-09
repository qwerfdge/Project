import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SocialPage {

    private final WebDriver driver;

    public SocialPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFacebookButtonDisplayed() {
        WebElement facebookButton = driver.findElement(By.cssSelector("https://www.facebook.com/prom.ua"));
        return facebookButton.isDisplayed();
    }

    public boolean isYoutubeButtonDisplayed() {
        WebElement twitterButton = driver.findElement(By.cssSelector("https://www.youtube.com/prom4ua"));
        return twitterButton.isDisplayed();
    }

    public boolean isInstagramButtonDisplayed() {
        WebElement linkedInButton = driver.findElement(By.cssSelector("https://www.instagram.com/prom.pompom/"));
        return linkedInButton.isDisplayed();
    }
}

