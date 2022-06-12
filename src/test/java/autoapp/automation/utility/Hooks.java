package autoapp.automation.utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static BrowserDriver driver;

    @Before
    public void setUp(){
        String browserName = "chrome";
        System.out.println("driver "+ browserName +"");
        driver = new BrowserDriver(browserName);
    }

    @After
    public void tearDown(){

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.close();
    }

    private String getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            throw new RuntimeException(name + " is not a parameter!");

        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");

        return value;
    }
}
