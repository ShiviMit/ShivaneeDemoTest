package autoapp.automation.utility;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriver implements WebDriver {

    public static WebDriver driver;
    String browserName;

    public BrowserDriver(WebDriver driver){
        BrowserDriver.driver = driver;
    }

    public BrowserDriver(String browserName) {
        this.browserName = browserName;

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir") + "/src/test/resources/geckodriver");
            driver = new FirefoxDriver();
        }
    }

    public void close() {
        driver.close();

    }

    public WebElement findElement(By arg0) {
        return driver.findElement(arg0);
    }

    public List<WebElement> findElements(By arg0) {
        return driver.findElements(arg0);
    }

    public void get(String arg0) {
        driver.get(arg0);

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public Options manage() {
        return driver.manage();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public void quit() {
        driver.quit();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }
}