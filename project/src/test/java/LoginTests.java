import PageObject.LoginPage;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends LoginAuthTest {

    @Test
    @Description("Check that login is worked with valid credentials")
    public void loginWithValidCredentials()  {
        webDriver.get("https://prom.ua/");

        login("Anastasia", "Mar19742005");

        Assert.assertTrue(isUserLoggedIn(), "User isn't logged in successfully");
    }

    @Test
    @Description("Check that login with invalid credentials displayed error message")
    public void loginWithInvalidCredentials() {
        webDriver.get("https://prom.ua/");

        login("Anastasia", "invalid_password");

        LoginPage loginPage = new LoginPage(webDriver);

        String expectedErrorMessage = " Вы указали неверный e-mail или пароль. ";
        Assert.assertTrue(loginPage.isErrorDisplayed(expectedErrorMessage), "Expected error message is not displayed for invalid credentials");
    }
}