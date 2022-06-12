package autoapp.automation.stepDef;

import autoapp.automation.pages.PersonalInfoPage;
import autoapp.automation.pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.Objects;

public class RegisterStepDef {


    @Given("^Automation practice application is opened$")
    public void automation_practice_application_is_opened() {
        RegisterPage.openApplicaiton();
    }

    @When("^I click sign in$")
    public void i_click_sign_in() {
        RegisterPage.clickSignIn();

    }

    @And("^I create account with emailid \"([^\"]*)\"$")
    public void i_create_account_with_emailid(String emailId)  {
        RegisterPage.createAccount(emailId);
   //     Thread.sleep(5000);
    }


    @Then("^I should be able to register with my below details$")
    public void i_should_be_able_to_register_with_my_below_details(DataTable dataTable) {
        PersonalInfoPage.enterPersonalInformation(dataTable);
   //     Thread.sleep(5000);
    }


    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage) {

        //get error message displayed on the screen
        String errorMsg = RegisterPage.getErrorMessage();

        //compare with expected error message
        assert Objects.equals(errorMsg, errorMessage);

    }


}
