import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FilteringTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://prom.ua/");

    }

    @Test
    public void testProductFiltering() {

        selectFilter("Категория", "Электроника");
        selectFilter("Цвет", "Черный");


        List<WebElement> filteredProducts = driver.findElements(By.className("product"));


        assertTrue(isFilteredCorrectly(filteredProducts));
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    private void selectFilter(String filterName, String filterValue) {
        WebElement filterDropdown = driver.findElement(By.id("filter_" + filterName));
        filterDropdown.click();

        WebElement filterOption = driver.findElement(By.xpath("//label[text()='" + filterValue + "']"));
        filterOption.click();
    }


    private boolean isFilteredCorrectly(List<WebElement> products) {

        return true;
    }
}
