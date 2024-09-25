package UITests;

import org.testng.annotations.Test;

public class UITests extends BaseTest{



    @Test
    public void start() {
        driver.get("http://localhost/login:4444");
    }
}
