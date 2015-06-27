package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    private WebDriver getDriver() {
        return this.driver;
    }

    public AbstractPage typeInto(WebElement element, String value) {
        element.sendKeys(value);
        return this;
    }

    public AbstractPage click(WebElement element) {
        element.click();
        return this;
    }
}
