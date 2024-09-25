package UITests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        opt.addArguments("--headless");  // Add this line
        opt.addArguments("--disable-gpu"); // Disable GPU if not needed
        opt.addArguments("--no-sandbox"); // Required for Docker
        driver =  new ChromeDriver(opt);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethodAction(ITestResult result) {
            driver.quit();

    }
}
