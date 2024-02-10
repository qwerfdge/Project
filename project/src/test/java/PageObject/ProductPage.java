package PageObject;

// ProductPage.java

import org.openqa.selenium.WebDriver;
public class ProductPage extends BasePage {


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String url) {

    }

    @Override
    public boolean addToCart() {
        return false;
    }


}