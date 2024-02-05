import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SortingTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");

    }

    @Test
    public void testSearchResultsSorting() {

        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("чашка с надписью");


        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();


        Select sortDropdown = new Select(driver.findElement(By.id("sortDropdown")));
        sortDropdown.selectByVisibleText("За рейтингом");




        List<WebElement> searchResults = driver.findElements(By.className("searchResult"));


        assertTrue(isSorted(searchResults));
    }

    private boolean isSorted(List<WebElement> searchResults) {
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    }
}

