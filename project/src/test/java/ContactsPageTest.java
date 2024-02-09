import PageObject.ContactsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactsPageTest {

    private WebDriver driver;
    private ContactsPage contactsPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64/");
        driver = new ChromeDriver();
        contactsPage = new ContactsPage(driver);
        driver.get("https://prom.ua/ua/contact_us");
    }

    @Test
    public void testContactFormVisibility() {
        boolean isContactFormVisible = contactsPage.isContactFormVisible();
        Assert.assertTrue(isContactFormVisible);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

