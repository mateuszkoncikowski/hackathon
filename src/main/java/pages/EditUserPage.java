package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserPage extends TestArenaPage {

    @FindBy(xpath = "(//div[@class = 'error_msg'])[2]")
    private WebElement emailErrorMessage;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id = 'save']")
    private WebElement submitButton;

    public EditUserPage(WebDriver driver) {
        super(driver);
    }

    public EditUserPage inputEmail(String email) {
        this.emailField.clear();
        this.emailField.sendKeys(email);
        return this;
    }

    public EditUserPage submitIncorrectForm() {
        this.submitButton.click();
        return new EditUserPage(driver);
    }

    public String errorMessage() {
        return this.emailErrorMessage.getText();
    }
}
