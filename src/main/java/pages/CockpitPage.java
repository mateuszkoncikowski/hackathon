package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CockpitPage extends TestArenaPage {

    @FindBy(xpath = "//div[@class = 'header_admin']/a")
    private WebElement adminPage;

    public CockpitPage(WebDriver driver) {
        super(driver);
    }

    public AdministrationPage openAdministrationPage() {
        this.click(adminPage);
        return new AdministrationPage(driver);
    }
}
