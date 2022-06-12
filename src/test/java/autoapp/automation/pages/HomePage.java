package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

    //Locators
    private static final String xpathMegaMenu = "//div[@id='block_top_menu']//ul[contains(@class,'sf-menu')]//li//a[@title='MegaMenu']";
    private static final String xpathSubMenu = "//div[@id='block_top_menu']//ul[contains(@class,'submenu')]//a[@title='SubMenu']";

    public HomePage() {
        super((BrowserDriver) driver);
    }

    //Click on Submenu based on the parameters provided
    public static void clickSubMenu(String menu, String subMenu) {

        //replace MegaMenu and SubMenu in xpath with value of menu and subMenu
        String megaMenuValue = xpathMegaMenu.replace("MegaMenu", menu);
        String subMenuValue = xpathSubMenu.replace("SubMenu", subMenu);


        //locate the mega menu to hover over
        WebElement megaMenuElement = driver.findElement(By.xpath(megaMenuValue));

        //Initiate mouse action using Actions class
        Actions builder = new Actions(driver);

        // move the mouse to the identified menu option- Dresses
        builder.moveToElement(megaMenuElement).build().perform();

        //locate sub menu and click on it
        WebElement subMenuElement = driver.findElement(By.xpath(subMenuValue));
        subMenuElement.click();


    }




}
