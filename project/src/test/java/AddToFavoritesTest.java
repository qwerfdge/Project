import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class AddToFavoritesTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://yourpromwebsite.com");

    }

    @Test
    public void testAddToFavorites() {

        WebElement productLink = driver.findElement(By.xpath("//div[@class='product']/a"));
        productLink.click();


        WebElement addToFavoritesButton = driver.findElement(By.id("addToFavoritesButton"));
        addToFavoritesButton.click();


        WebElement favoritesCount = driver.findElement(By.id("favoritesCount"));
        assertTrue(favoritesCount.getText().equals("1"));


        driver.navigate().back();


        WebElement favoritesLink = driver.findElement(By.id("favoritesLink"));
        favoritesLink.click();


        WebElement favoriteProduct = driver.findElement(By.xpath("//div[@class='favorite-product']/a"));
        assertTrue(favoriteProduct.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

