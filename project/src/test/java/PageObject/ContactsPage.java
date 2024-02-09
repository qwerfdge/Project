package PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

    private WebDriver driver;

    // Локаторы элементов на странице
    @FindBy(id = "contactForm")
    private WebElement contactForm;

    @FindBy(id = "nameInput")
    private WebElement nameInput;

    @FindBy(id = "emailInput")
    private WebElement emailInput;

    @FindBy(id = "messageInput")
    private WebElement messageInput;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    // Конструктор класса
    public ContactsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Метод для заполнения формы контактов
    public void fillContactForm(String name, String email, String message) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        messageInput.sendKeys(message);
    }

    // Метод для отправки формы контактов
    public void submitContactForm() {
        submitButton.click();
    }

    // Метод для проверки видимости формы контактов
    public boolean isContactFormVisible() {
        return contactForm.isDisplayed();
    }
}
