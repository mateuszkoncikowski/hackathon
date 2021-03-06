package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//div[@class = 'remember_check']/a")
    private WebElement recoverPasswordLink;

    @FindBy(id = "email")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public CockpitPage logIn(String username, String password) {
        this.typeInto(loginField, username);
        this.typeInto(passwordField, password);
        this.click(loginButton);
        return new CockpitPage(getDriver());
    }

    public RecoverPasswordPage openRecoverPasswordPage() {
        this.click(recoverPasswordLink);
        return new RecoverPasswordPage(getDriver());
    }
}
