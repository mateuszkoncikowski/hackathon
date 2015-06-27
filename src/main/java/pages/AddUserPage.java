package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends TestArenaPage {
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id = 'save']")
    private WebElement saveButton;

    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    public UsersPage addUser(String name, String lastname, String email) {
        typeInto(firstNameInput, name);
        typeInto(lastNameInput, lastname);
        typeInto(emailInput, email);
        click(saveButton);
        return new UsersPage(getDriver());
    }
}
