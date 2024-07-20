package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class Login_Steps extends Base_PO {
    private final Login_PO login_po;

    public Login_Steps(Login_PO login_po) {
        this.login_po = login_po;
    }

    @Given("I access the Demoblaze page")
    public void iAccessTheDemoblazePage() {
        login_po.navigateTo_DemoBlaze_Login_Page();
    }

    @When("I enter Username {} and Password {}")
    public void iEnterUsernameAndPassword(String username, String password) {
        login_po.clickOn_Login_Link();
        login_po.setUsername(username);
        login_po.setPassword(password);
        login_po.clickOn_Login_Button();
        login_po.validate_Successful_SubmissionMessage_Text(username);
    }
    
    @And("I add products to the cart")
    public void iAddProductProductAndProductProductToTheCart() {
        login_po.clickOn_MenuHome_TextField();
        login_po.add_Product1Cart();
        login_po.clickOn_MenuHome_TextField();
        login_po.add_Product2Cart();
    }

    @And("I view the cart")
    public void iViewTheCart() {
        login_po.clickOn_MenuCart_TextField();
        login_po.clickOn_PlaceOrder_Button();
    }

    @And("I complete the purchase form: {}, {}, {}, {}, {}, {}")
    public void iCompleteThePurchaseForm(String name, String country, String city, String credit_card, String month, String year) {
        login_po.complete_PurchaseForm(name, country, city, credit_card, month, year);
        login_po.clickOn_Purchase_Button();
    }

    @Then("I should see the purchase confirmation")
    public void iShouldSeeThePurchaseConfirmation() {
        login_po.confirmationMessage();
    }
}