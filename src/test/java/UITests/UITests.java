package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UITests extends BaseTest{

    @BeforeMethod
    public void loginTest() {
        driver.get("http://192.168.31.253/login");
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("admin");
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("admin");
        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        submitBtn.click();
    }

    @Test (priority = 1)
    public void addProjectTest() {
        WebElement newProjectBtn = driver.findElement(By.partialLinkText("New project"));
        newProjectBtn.click();
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Some Project");
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit' and  text()='Save']\n"));
        submitBtn.click();
    }

    @Test (priority = 2)
    public void addTask() {
        WebElement newProject = driver.findElement(By.xpath("//a[text()='Some Project']"));
        newProject.click();
        WebElement addTaskBtn = driver.findElement(By.xpath("//th[contains(@class, 'board-column-header')][1]//a[@title='Add a new task']"));
        addTaskBtn.click();
        WebElement titleField = driver.findElement(By.name("title"));
        titleField.sendKeys("Task 1");
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();
    }

    @Test(priority = 3)
    public void closeTask() {
        WebElement newProject = driver.findElement(By.xpath("//a[text()='Some Project']"));
        newProject.click();
        WebElement newTask = driver.findElement(By.xpath("//div[@class='task-board-title']/a[text()='Task 1']"));
        newTask.click();
        WebElement closeTaskBtn = driver.findElement(By.xpath("//a[text()='Close this task']"));
        closeTaskBtn.click();
        WebElement confirmBtn = driver.findElement(By.xpath("//button[text()='Yes']"));
        confirmBtn.click();
    }

    @Test (priority = 4)
    public void addComment() {
        addTask();
        WebElement newTask = driver.findElement(By.xpath("//div[@class='task-board-title']/a[text()='Task 1']"));
        newTask.click();
        WebElement comentBlock = driver.findElement(By.xpath("//div[@id='comments']/preceding-sibling::summary"));
        comentBlock.click();
        WebElement commentField = driver.findElement(By.xpath("//textarea[@name='comment']"));
        commentField.sendKeys("This is a comment");
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();
    }

}
