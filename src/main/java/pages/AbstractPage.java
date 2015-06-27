package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    private final WebDriverWait wait;
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);

        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public AbstractPage typeInto(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
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

    public WebElement waitForPresence(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
