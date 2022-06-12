package autoapp.automation.stepDef;

import autoapp.automation.pages.ShoppingCartPage;
import io.cucumber.java.en.Then;

import java.util.Objects;

public class ShoppingCartStepDef {

    @Then("I should see product {int} of color {string} and quantity {int} added to the cart")
    public void iShouldSeeItemsAddedToTheCart(int product, String color, int quantity) {

        try {

            //Ensure Shopping cart section is loaded
            ShoppingCartPage.shoppingCartLoaded();

            //verify correct productID is added to the cart
            assert Objects.equals(ShoppingCartPage.getCartItemDetails("ProductID"), String.valueOf(product));

            //verify correct color is added to the cart
            assert Objects.equals(ShoppingCartPage.getCartItemDetails("Color").toLowerCase(), color.toLowerCase());

            //verify correct quantity is added to the cart
            assert Objects.equals(ShoppingCartPage.getCartItemDetails("Quantity"), String.valueOf(quantity));

        }catch (Exception e) {
            e.printStackTrace();
        }



    }


}
