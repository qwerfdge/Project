import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AboutUsPageTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64");

        driver = new ChromeDriver();
        driver.get("https://prom.ua/about_us");
    }

    @Test
    public void testAboutUsPage() {
        assert driver.getTitle().contains("О нас");


        WebElement aboutTextElement = driver.findElement(By.cssSelector("Prom.ua — крупнейший маркетплейс Украины. Здесь есть все от корма для котенка до бронежилета, от детских игрушек до газонокосилок и культиваторов. Ежедневно здесь происходит более 70 тысяч покупок. У нас продают десятки тысяч продавцов со всех уголков Украины — это малый и средний бизнес, на котором держится экономика Украины.\n" +
                "\n"));


        assert aboutTextElement.isDisplayed();
        assert aboutImageElement.isDisplayed();


    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

