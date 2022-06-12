package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage extends BasePage {

    //locators
    private static final By cartSummary = By.id("cart_summary");
    private static final By productCode = By.xpath("//small[@class='cart_ref']");
    private static final By productColor = By.xpath("//td[@class='cart_description']//small//a[contains(@href,'color')]");
    private static final By quantity = By.xpath("//td[contains(@class,'cart_quantity')]//input[@type='hidden']");

    public ShoppingCartPage() {
        super((BrowserDriver) driver);
    }


    public static void shoppingCartLoaded(){

        //wait until shopping cart summary is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartSummary));


    }

    public static String getCartItemDetails(String itemDesc){

        String itemValue = null;

        //find value of certain attribute in shopping cart
        switch (itemDesc) {
            case "ProductID":

                itemValue = driver.findElement(productCode).getText();

                //extract productID
                itemValue = itemValue.substring(itemValue.indexOf("_")+1);

                break;
            case "Color":
                itemValue = driver.findElement(productColor).getText();

                //extract color
                itemValue = itemValue.substring(itemValue.indexOf("Color : ")+8, itemValue.indexOf(","));

                break;
            case "Quantity":
                itemValue = driver.findElement(quantity).getAttribute("value");

                break;

        }

        return itemValue;

    }






}
