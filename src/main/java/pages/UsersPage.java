package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends TestArenaPage {
    @FindBy(xpath = "//a[text() = 'Dodaj użytkownika']")
    private WebElement addUserLink;

    @FindBy(id = "action_icon")
    private WebElement actionIcon;

    @FindBy(xpath = "//div[@class = 'collapse']/ul/li/a")
    private WebElement editUser;

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public UsersPage clickForFirstUserDetails() {
        this.click(actionIcon);
        return this;
    }

    public EditUserPage openEditUserPage() {
        this.click(editUser);
        return new EditUserPage(driver);
    }

    public AddUserPage openAddUserPage() {
        click(addUserLink);
        return new AddUserPage(getDriver());
    }
}
