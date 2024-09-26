package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static UITests.elements.LoginData.*;
import static UITests.elements.LoginElements.*;

public class UILoginTests extends BaseTest{

    private final static String wrongName = "test";
    private final static String wrongPass = "123456789";
    private final static String errorMessage = "Bad username or password";

    @Test(priority = 1)
    public void wrongNameLogin() {
        driver.get(loginUrl);
        WebElement usernameField = driver.findElement(By.xpath(loginUsernameField));
        usernameField.sendKeys(wrongName);
        WebElement passField = driver.findElement(By.xpath(loginPassField));
        passField.sendKeys(loginPass);
        WebElement submitBtn = driver.findElement(By.xpath(loginSubmitBtn));
        submitBtn.click();
        WebElement errorText = driver.findElement(By.xpath(loginErrorMessage));
        Assert.assertEquals(errorText.getText(), errorMessage);
    }

    @Test(priority = 1)
    public void wrongPassLogin() {
        driver.get(loginUrl);
        WebElement usernameField = driver.findElement(By.xpath(loginUsernameField));
        usernameField.sendKeys(loginName);
        WebElement passField = driver.findElement(By.xpath(loginPassField));
        passField.sendKeys(wrongPass);
        WebElement submitBtn = driver.findElement(By.xpath(loginSubmitBtn));
        submitBtn.click();
        WebElement errorText = driver.findElement(By.xpath(loginErrorMessage));
        Assert.assertEquals(errorText.getText(), errorMessage);
    }

    @Test(priority = 2)
    public void positiveLogin() {
        driver.get(loginUrl);
        WebElement usernameField = driver.findElement(By.xpath(loginUsernameField));
        usernameField.sendKeys(loginName);
        WebElement passField = driver.findElement(By.xpath(loginPassField));
        passField.sendKeys(loginPass);
        WebElement submitBtn = driver.findElement(By.xpath(loginSubmitBtn));
        submitBtn.click();
    }
}
