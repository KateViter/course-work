package UITests.elements;

public class TaskElements {

    public static final String taskAddButton = "//th[contains(@class, 'board-column-header')][1]//a[@title='Add a new task']";
    public static final String taskTittleField = "//*[@name='title']";
    public static final String taskSubmitBtn = "//button[@type='submit']";
    public static final String taskOpenComment = "//div[@id='comments']/preceding-sibling::summary";
    public static final String taskCommentField = "//textarea[@name='comment']";
    public static final String taskSubmitCommentBtn = "//button[@type='submit']";
    public static final String taskCloseBtn = "//a[text()='Close this task']";
    public static final String taskConfirmBtn = "//button[text()='Yes']";

    public static String taskViewBtn(String taskName){
        return "//div[@class='task-board-title']/a[text()='" + taskName +"']";
    }
}
