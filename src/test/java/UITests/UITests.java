package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static UITests.elements.LoginData.*;
import static UITests.elements.LoginElements.*;
import static UITests.elements.ProjectElements.*;
import static UITests.elements.TaskElements.*;

public class UITests extends BaseTest{

    private static final String projectName = "Stardust";
    private static final String taskName = "Important thing";
    private static final String commentText = "Task is updated";


    @BeforeMethod
    public void loginTest() {
        driver.get(loginUrl);
        WebElement usernameField = driver.findElement(By.xpath(loginUsernameField));
        usernameField.sendKeys(loginName);
        WebElement passField = driver.findElement(By.xpath(loginPassField));
        passField.sendKeys(loginPass);
        WebElement submitBtn = driver.findElement(By.xpath(loginSubmitBtn));
        submitBtn.click();
    }

    @Test (priority = 1)
    public void addProjectTest() {
        WebElement newProjectBtn = driver.findElement(By.xpath(projectNewBtn));
        newProjectBtn.click();
        WebElement nameField = driver.findElement(By.xpath(projectNameField));
        nameField.sendKeys(projectName);
        WebElement submitBtnEl = driver.findElement(By.xpath(projectSubmitBtn));
        submitBtnEl.click();
    }

    @Test (priority = 2)
    public void addTask() {
        WebElement newProject = driver.findElement(By.xpath(projectOpenBtn(projectName)));
        newProject.click();
        WebElement addTaskBtn = driver.findElement(By.xpath(taskAddButton));
        addTaskBtn.click();
        WebElement titleField = driver.findElement(By.xpath(taskTittleField));
        titleField.sendKeys(taskName);
        WebElement submitBtn = driver.findElement(By.xpath(taskSubmitBtn));
        submitBtn.click();
    }

    @Test(priority = 3)
    public void closeTask() {
        WebElement newProject = driver.findElement(By.xpath(projectOpenBtn(projectName)));
        newProject.click();
        WebElement viewTask = driver.findElement(By.xpath(taskViewBtn(taskName)));
        viewTask.click();
        WebElement closeTaskBtn = driver.findElement(By.xpath(taskCloseBtn));
        closeTaskBtn.click();
        WebElement confirmBtn = driver.findElement(By.xpath(taskConfirmBtn));
        confirmBtn.click();
    }

    @Test (priority = 4)
    public void addComment() {
        addTask();
        WebElement newTask = driver.findElement(By.xpath(taskViewBtn(taskName)));
        newTask.click();
        WebElement commentBlock = driver.findElement(By.xpath(taskOpenComment));
        commentBlock.click();
        WebElement commentField = driver.findElement(By.xpath(taskCommentField));
        commentField.sendKeys(commentText);
        WebElement submitBtn = driver.findElement(By.xpath(taskSubmitCommentBtn));
        submitBtn.click();
    }

}
