package UITests;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class BaseTest {

    protected RemoteWebDriver driver;
    // selenium-firefox to run in remote browser in another container with firefox browser
    // should be selected by running via Jenkins
    private final static String remoteUrl = "http://selenium-firefox:4444";

    // localhost to run locally in remote browser in another container with firefox browser
    // should be selected by running locally from IDEA
//    private final static String remoteUrl = "http://localhost:4444";

    protected URL remoteUrl() {
        try {
            return new URL(remoteUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setUp() {
        FirefoxOptions opt = new FirefoxOptions();
        opt.addArguments("--no-sandbox");
        opt.addArguments("--disable-dev-shm-usage");
        driver = new RemoteWebDriver(remoteUrl(), opt);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethodAction(ITestResult result) {
            driver.quit();

    }
}
