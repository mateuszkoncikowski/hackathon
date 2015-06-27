import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.RecoverPasswordPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestClass {
    public WebDriver driver = new FirefoxDriver();

    @Before
    public void startBrowser() {
        driver.get("https://testarena.pgs-soft.com");
    }

    @Test
    public void testIfBackToHomePageButtonIsVisible() {
        LoginPage loginPage = new LoginPage(driver);

        RecoverPasswordPage recoverPasswordPage = loginPage.openRecoverPasswordPage();

        assertThat(recoverPasswordPage.isBackToHomePageButtonPresent(), equalTo(true));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
