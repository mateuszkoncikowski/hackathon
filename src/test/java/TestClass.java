import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CockpitPage;
import pages.ErrorPage;
import pages.LoginPage;
import pages.RecoverPasswordPage;

import static org.hamcrest.CoreMatchers.containsString;
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

    @Test
    public void testIfNonExistingPageWillBeDisplayedCorrectly() {
        LoginPage loginPage = new LoginPage(driver);
        ErrorPage errorPage = loginPage.openNonExistingPage();

        assertThat(errorPage.getPageSource(), containsString("This page doesn't exist."));
    }

    @Test
    public void testIfChangingUserDataIsPossible() {
        LoginPage loginPage = new LoginPage(driver);
        CockpitPage cockpitPage = loginPage.logIn("admin@tc2014.pl", "12qwAS");
        System.out.println(cockpitPage.getPageSource());

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
