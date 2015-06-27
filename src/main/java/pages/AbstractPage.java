package pages;

import org.openqa.selenium.By;
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

    public String getPageSource() {
        return getDriver().getPageSource();
    }

    public ErrorPage openNonExistingPage() {
        getDriver().get("https://testarena.pgs-soft.com/zaloguj2");
        return new ErrorPage(driver);
    }

    public AbstractPage click(WebElement element) {
        element.click();
        return this;
    }

    public boolean isElementPresent(By by) {
        return getDriver().findElements(by).size() > 0;
    }
}
