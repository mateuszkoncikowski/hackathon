import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserDriver {

    public BrowserDriver() {}

    public WebDriver openLocalBrowser() {
        return new FirefoxDriver();
    }

    public WebDriver openRemoteBrowser() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("version", "32");
        capabilities.setCapability("platform", Platform.WIN8);

        return new RemoteWebDriver(
                new URL("http://mateuszkoncikowski:1c0aa84b-a41d-47ee-8ccb-21784669f782@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
    }

    public void makeScreenshot(WebDriver driver, TestName testName) throws IOException {
        String screenshotName = String.format("%s.png", testName.getMethodName());

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(screenshotName));
    }

    public void closeBrowser(WebDriver driver) {
        driver.quit();
    }
}
