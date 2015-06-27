package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestArenaPage extends AbstractPage {

    @FindBy(linkText = "")
    private WebElement administrationPageLink;

    public TestArenaPage(WebDriver driver) {
        super(driver);
    }

    public AdministrationPage openAdministrationPage() {
        System.out.println(getPageSource());
        return new AdministrationPage(driver);
    }
}
