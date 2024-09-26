package UITests.elements;

import lombok.Getter;

@Getter
public class LoginElements {

    public static final String loginUsernameField = "//*[@name='username']\n";
    public static final String loginPassField = "//*[@name='password']\n";
    public static final String loginSubmitBtn = "//button[text()='Sign in']";
    public static final String loginErrorMessage = "//p[text()='Bad username or password']";

}
