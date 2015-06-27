import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CockpitPage;
import pages.LoginPage;

public class TestClass {
    public WebDriver driver = new FirefoxDriver();

    @Before
    public void startBrowser() {
        driver.get("https://testarena.pgs-soft.com");
    }

    @Test
    public void test() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CockpitPage cockpitPage = loginPage.logIn("admin@testarena.pl", "12qwAS");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
