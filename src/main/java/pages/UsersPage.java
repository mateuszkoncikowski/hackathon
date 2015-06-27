package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends TestArenaPage {
    @FindBy(xpath = "//a[text() = 'Dodaj użytkownika']")
    private WebElement addUserLink;

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public AddUserPage openAddUserPage() {
        click(addUserLink);
        return new AddUserPage(driver);
    }
}
