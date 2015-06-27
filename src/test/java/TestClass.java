import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;
import utils.Utils;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class TestClass {
    public WebDriver driver = new FirefoxDriver();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void startBrowser() {
        driver.get("http://demo.testarena.pl/");
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
        LoginPage loginPage = new LoginPage(driver);

//        CockpitPage cockpitPage = loginPage.logIn("admin@tc2014.pl", "12qwAS");
        CockpitPage cockpitPage = loginPage.logIn("admin@testarena.pl", "12qwAS");
        AdministrationPage adminPage = cockpitPage.openAdministrationPage();
        UserPage userPage = adminPage.openUsersPage();
        userPage.clickForFirstUserDetails();
        EditUserPage editUserPage = userPage.openEditUserPage();
        editUserPage.inputEmail("sd");
        EditUserPage pageWithError = editUserPage.submitIncorrectForm();
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
        String username = "administrator@testarena.pl";
        String password = "sumXQQ72$L";

        String firstName = Utils.getRandomString();
        String lastName = Utils.getRandomString();
        String email = Utils.getRandomString(30) + "@test.net.pl";
        LoginPage loginPage = new LoginPage(driver);

        //when
        UsersPage usersPage = loginPage
            .logIn(username, password)
            .openAdministrationPage()
            .openUserPage()
            .openAddUserPage()
            .addUser(firstName, lastName, email);

        //then
        assertThat(usersPage.getPageSource(), containsString("Użytkownik został dodany."));

    }

    @After
    public void closeBrowser() throws IOException {
        String screenshotName = String.format("%s.png", testName.getMethodName());

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(screenshotName));
        driver.quit();
    }
}
