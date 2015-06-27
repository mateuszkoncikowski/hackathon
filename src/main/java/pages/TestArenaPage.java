package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestArenaPage extends AbstractPage {

    @FindBy(linkText = "Administracja")
    private WebElement administrationPageLink;

    @FindBy(xpath = "//a[text() = 'Użytkownicy']")
    private WebElement userPageLink;

    public TestArenaPage(WebDriver driver) {
        super(driver);
    }

    public AdministrationPage openAdministrationPage() {
        click(administrationPageLink);
        return new AdministrationPage(driver);
    }

    public UsersPage openUserPage() {
        click(userPageLink);
        return new UsersPage(driver);
    }
}
