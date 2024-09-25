package UITests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class BaseTest {

    protected RemoteWebDriver driver;

    protected URL startStandaloneGrid() {
        try {
//            URL gridUrl = new URL("http://localhost/login:4444");
            return new URL("http://localhost:" + "4444");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//      ChromeOptions opt = new ChromeOptions();

//        opt.addArguments("--remote-allow-origins=*");
//        opt.addArguments("--headless");  // Add this line
//        opt.addArguments("--disable-gpu"); // Disable GPU if not needed
//        opt.addArguments("--no-sandbox"); // Required for Docker

//      driver =  new ChromeDriver(opt);
//        driver =  new FirefoxDriver(opt);

    @BeforeMethod
    public void setUp() {
        FirefoxOptions opt = new FirefoxOptions();
        driver = new RemoteWebDriver(startStandaloneGrid(), opt);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethodAction(ITestResult result) {
            driver.quit();

    }
}
