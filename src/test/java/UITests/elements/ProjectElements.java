package UITests.elements;

import lombok.Getter;

@Getter
public class ProjectElements {

    public static final String projectNewBtn = "//div[@class='page-header']//a[contains(text(), 'New project')]";
    public static final String projectNameField = "//*[@name='name']\n";
    public static final String projectSubmitBtn = "//button[@type='submit' and  text()='Save']\n";

    public static String projectOpenBtn(String projectName){
        return "//a[text()='" + projectName + "']";
    }
}
