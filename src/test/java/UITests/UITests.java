package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UITests extends BaseTest{

    @Test
    public void loginTest() {
        driver.get("http://192.168.31.253/login");
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("admin");
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("admin");
        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        submitBtn.click();
        WebElement dashboardTitle = driver.findElement(By.partialLinkText("New project"));
        System.out.println(dashboardTitle.getText());
        Assert.assertEquals(dashboardTitle.getText(),"New project");
    }
}
