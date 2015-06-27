package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends TestArenaPage {

    @FindBy(id = "action_icon")
    private WebElement actionIcon;

    @FindBy(xpath = "//div[@class = 'collapse']/ul/li/a")
    private WebElement editUser;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public void clickForFirstUserDetails() {
        this.click(actionIcon);
    }

    public EditUserPage openEditUserPage() {
        this.click(editUser);
        return new EditUserPage(driver);
    }

}
