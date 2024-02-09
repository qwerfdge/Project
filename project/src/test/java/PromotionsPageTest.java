
import PageObject.PromotionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PromotionsPageTest {

    private WebDriver driver;
    private PromotionsPage promotionsPage;

    public PromotionsPageTest(WebDriver driver) {

    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/anastasia/webDriver/chromedriver_linux64/");
        driver = new ChromeDriver();
        promotionsPage = new PromotionsPage(driver);
        driver.get("https://example.com/promotions");
    }

    @Test
    public void testApplyPromoCode() {
        promotionsPage.enterPromoCode("E4535");
        promotionsPage.applyPromoCode();
        String successMessage = promotionsPage.getPromoSuccessMessage();
        Assert.assertEquals(successMessage, "Promo code successfully applied.", "The success message is not as expected.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
