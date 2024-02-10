import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SocialPage {
    private final WebDriver driver;

    public SocialPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFacebookButtonDisplayed() {
        return isElementDisplayed(By.cssSelector("a[href='https://www.facebook.com/prom.ua']"));
    }

    public boolean isYoutubeButtonDisplayed() {
        return isElementDisplayed(By.cssSelector("a[href='https://www.youtube.com/prom4ua']"));
    }

    public boolean isInstagramButtonDisplayed() {
        return isElementDisplayed(By.cssSelector("a[href='https://www.instagram.com/prom.pompom/']"));
    }

    private boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}
