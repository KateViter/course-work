package UITests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class UITests extends BaseTest{


    @Test
    public void start() {
        driver.get("http://192.168.31.253/login:4444");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("admin");
    }
}
