package UITests;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class BaseTest {

    protected RemoteWebDriver driver;

    protected URL remoteUrl() {
        try {
            return new URL("http://localhost:4444");
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
