package autoapp.automation.stepDef;

import autoapp.automation.pages.HomePage;
import autoapp.automation.pages.DressesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Objects;

public class DressesStepDef {


    @When("I click on menu {string} {string}")
    public void iClickOnMenu(String menu, String subMenu) {
        HomePage.clickSubMenu(menu, subMenu);

    }

    @Then("I should see category on page {string}")
    public void iShouldSeeCategoryOnPage(String category) {

        String categoryName = DressesPage.getCategoryName();
        //compare with expected error message
        assert Objects.equals(categoryName, category);

    }

    @And("I quick select product {int} and color {string}")
    public void iQuickSelectProductAndColor(int productID, String color) {
        DressesPage.quickSelectProductColor(productID, color);

    }

    @And("I click on Add to Cart")
    public void iClickOnAddToCart() {
        DressesPage.addToCart();
    }

    @And("I proceed to the checkout")
    public void iProceedToTheCheckout() {
        DressesPage.proceedToCheckout();

    }

}


