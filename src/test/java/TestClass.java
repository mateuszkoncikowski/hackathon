import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Utils;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class TestClass {
    @Rule
    public TestName testName = new TestName();

    private WebDriver driver;
    private BrowserDriver browserDriver = new BrowserDriver();

    //TestArena credentials:
    public static final String BASE_URL = "http://demo.testarena.pl/";
    public static final String USERNAME = "administrator@testarena.pl";
    public static final String PASSWORD = "sumXQQ72$L";

    //Mr.Buggy credentials:
//    public static final String BASE_URL = "http://demo.mrbuggy2.testarena.pl/";
//    public static final String USERNAME = "admin@tc2014.pl";
//    public static final String PASSWORD = "12qwAS";

    @Before
    public void startBrowser() throws MalformedURLException {
        driver = browserDriver.openLocalBrowser();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @Test
    public void testIfBackToHomePageButtonIsVisible() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //when
        RecoverPasswordPage recoverPasswordPage = loginPage.openRecoverPasswordPage();

        //then
        assertThat(recoverPasswordPage.isBackToHomePageButtonPresent(), equalTo(true));
    }

    @Test
    public void testIfEditingEmailErrorIsCorrect() {
        //given
        LoginPage loginPage = new LoginPage(driver);
        String incorrectEmail = "sd";

        //when
        EditUserPage pageWithError = loginPage
                .logIn(USERNAME, PASSWORD)
                .openAdministrationPage()
                .openUsersPage()
                .clickForFirstUserDetails()
                .openEditUserPage()
                .inputEmail(incorrectEmail)
                .submitIncorrectForm();

        //then
        assertThat(pageWithError.errorMessage(), equalTo("The field must contain at least 6 characters."));
    }

    @Test
    public void testIfNonExistingPageWillBeDisplayedCorrectly() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //when
        ErrorPage errorPage = loginPage.openNonExistingPage();

        //then
        assertThat(errorPage.getPageSource(), containsString("This page doesn't exist."));
    }

    @Test
    public void testIfChangingUserDataIsPossible() {
        //given

        String firstName = Utils.getRandomString();
        String lastName = Utils.getRandomString();
        String email = Utils.getRandomString(30) + "@test.net.pl";
        LoginPage loginPage = new LoginPage(driver);

        //when
        UsersPage usersPage = loginPage
            .logIn(USERNAME, PASSWORD)
            .openAdministrationPage()
            .openUserPage()
            .openAddUserPage()
            .addUser(firstName, lastName, email);

        //then
        assertThat(usersPage.getPageSource(), containsString("Użytkownik został dodany."));
    }

    @After
    public void closeBrowser() throws IOException {
        browserDriver.makeScreenshot(driver, testName);
        browserDriver.closeBrowser(driver);
    }
}
