package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UILoginTests extends BaseTest{

    @Test(priority = 1)
    public void wrongNameLogin() {
        driver.get("http://192.168.31.253/login");
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("test");
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("admin");
        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        submitBtn.click();
        WebElement errorText = driver.findElement(By.xpath("//p[text()='Bad username or password']"));
        Assert.assertEquals(errorText.getText(), "Bad username or password");
    }

    @Test(priority = 1)
    public void wrongPassLogin() {
        driver.get("http://192.168.31.253/login");
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("admin");
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("123456789");
        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        submitBtn.click();
        WebElement errorText = driver.findElement(By.xpath("//p[text()='Bad username or password']"));
        Assert.assertEquals(errorText.getText(), "Bad username or password");
    }

    @Test(priority = 2)
    public void positiveLogin() {
        driver.get("http://192.168.31.253/login");
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("admin");
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("admin");
        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        submitBtn.click();
    }
}
