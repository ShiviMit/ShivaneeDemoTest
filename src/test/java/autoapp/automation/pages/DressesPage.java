package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DressesPage extends BasePage {

    //locators
    private static final By categoryName = By.xpath("//span[@class='category-name']");
    private static final String xpathProductImage = "//a[@class='product_img_link'][contains(@href,'id_product=ProductID')]";
    private static final String xpathProductColor = "//a[@class='product_img_link'][contains(@href,'id_product=ProductID')]//ancestor::div[@class='left-block']/following-sibling::div[@class='right-block']//div[@class='color-list-container']//a[contains(@href,'ColorName')]";

    private static final By addToCartBtn = By.name("Submit");
    private static final By proceedToCheckoutBtn = By.xpath("//a[@title='Proceed to checkout']");

    public DressesPage() {
        super((BrowserDriver) driver);
    }


    public static String getCategoryName(){

        //wait until Category name is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryName));

        return driver.findElement(categoryName).getText();

    }


    public static void quickSelectProductColor(int productId, String color) {

        //replace ProductID and ColorName in xpath with value of productID and color
        String product_ID = xpathProductImage.replace("ProductID", String.valueOf(productId));
        String product_color = xpathProductColor.replace("ProductID", String.valueOf(productId));
        product_color = product_color.replace("ColorName", color);

        //locate the dress quick view to  hover over
        WebElement productImage = driver.findElement(By.xpath(product_ID));

        //Initiate mouse action using Actions class
        Actions builder = new Actions(driver);

        // move the mouse to the identified menu option- Dresses
        builder.moveToElement(productImage).build().perform();

        //locate product color and select
        WebElement productColor = driver.findElement(By.xpath(product_color));
        productColor.click();

    }


    public static void addToCart() {
        //click on Add to Cart button
        driver.findElement(addToCartBtn).click();

    }

    public static void proceedToCheckout(){
        //click on proceed to checkout
        driver.findElement(proceedToCheckoutBtn).click();

    }


}
