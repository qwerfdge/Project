import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SearchSortingTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10);

        driver.get("https://prom.ua/");
    }

    @Test
    public void testSearchSorting() {

        WebElement searchInput = driver.findElement(By.name("<input type=\"search\" class=\"Dm7py\" name=\"search_term\" placeholder=\"Я ищу...\" autocomplete=\"off\" autocorrect=\"off\" autocapitalize=\"off\" value=\"\">"));

        searchInput.sendKeys("книга");

        searchInput.submit();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("https://prom.ua/search?search_term=%D0%BA%D0%BD%D0%B8%D0%B3%D0%B0")));


        WebElement sortingDropdown = driver.findElement(By.cssSelector("https://prom.ua/search?search_term=%D0%BA%D0%BD%D0%B8%D0%B3%D0%B0&sort=price"));

        sortingDropdown.sendKeys("дешевле");


        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("https://prom.ua/search?search_term=%D0%BA%D0%BD%D0%B8%D0%B3%D0%B0&sort=price")));


        List<WebElement> productPrices = driver.findElements(By.cssSelector("https://prom.ua/search?search_term=%D0%BA%D0%BD%D0%B8%D0%B3%D0%B0&sort=price"));
        Assert.assertTrue(isSorted(productPrices));
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }


    private boolean isSorted(List<WebElement> elements) {
        for (int i = 1; i < elements.size(); i++) {
            if (getPriceValue(elements.get(i - 1)) > getPriceValue(elements.get(i))) {
                return false;
            }
        }
        return true;
    }


    private double getPriceValue(WebElement element) {
        String priceText = element.getText().replaceAll("[^0-9.]", "");
        return Double.parseDouble(priceText);
    }
}

