package UITests;

import org.testng.annotations.Test;

public class UITests extends BaseTest{



    @Test
    public void start() {
        driver.get("http://192.168.31.253/login:4444");
    }
}
