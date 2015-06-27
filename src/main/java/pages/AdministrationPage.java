package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdministrationPage extends TestArenaPage {

    @FindBy(xpath = "//li[@class = 'item4']/a")
    private WebElement users;

    public AdministrationPage(WebDriver driver) {
        super(driver);
    }

    public UsersPage openUsersPage() {
        this.click(users);
        return new UsersPage(driver);
    }
}
