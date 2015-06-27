package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage extends AbstractPage {
    public RecoverPasswordPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isBackToHomePageButtonPresent() {
        return this.isElementPresent(By.xpath("//div[@class = 'remember_check']/a"));
    }
}
