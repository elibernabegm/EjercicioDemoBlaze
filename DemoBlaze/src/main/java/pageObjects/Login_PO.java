package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Global_Vars;

public class Login_PO extends Base_PO {

    public Login_PO() {
        super();
    }


    public @FindBy(id = "login2")
    WebElement login_Link;

    public @FindBy(id = "loginusername")
    WebElement username_TextField;

    public @FindBy(id = "loginpassword")
    WebElement password_TextField;

    public @FindBy(xpath = "//button[@onclick=\"logIn()\"]")
    WebElement login_Button;

    public @FindBy(id = "nameofuser")
    WebElement successfulSubmission_Message_Text;

    public @FindBy(xpath = "//a[@class=\"nav-link\" and contains(text(),\"Home\")]")
    WebElement menuHome_TextField;

    public @FindBy(xpath = "//a[@onclick=\"byCat('phone')\"]")
    WebElement categoryPhones_TextField;


    public @FindBy(xpath = "//h4[@class=\"card-title\"]//a[contains(text(),\"Samsung galaxy s6\")]")
    WebElement add_Product1;

    public @FindBy(xpath = "//h4[@class=\"card-title\"]//a[contains(text(),\"Nokia lumia 1520\")]")
    WebElement add_Product2;

    public @FindBy(xpath = "//a[contains(text(),\"Add to cart\")]")
    WebElement addCart_Button;

    public @FindBy(xpath = "//a[@class=\"nav-link\" and contains(text(),\"Cart\")]")
    WebElement menuCart_TextField;

    public @FindBy(xpath = "//button[contains(text(),\"Place Order\")]")
    WebElement placeOrder_Button;

    public @FindBy(xpath = "//input[@class=\"form-control\" and @id=\"name\"]")
    WebElement nameForm_TextField;

    public @FindBy(xpath = "//input[@class=\"form-control\" and @id=\"country\"]")
    WebElement countryForm_TextField;

    public @FindBy(xpath = "//input[@class=\"form-control\" and @id=\"city\"]")
    WebElement cityForm_TextField;

    public @FindBy(xpath = "//input[@class=\"form-control\" and @id=\"card\"]")
    WebElement ccForm_TextField;

    public @FindBy(xpath = "//input[@class=\"form-control\" and @id=\"month\"]")
    WebElement monthForm_TextField;

    public @FindBy(xpath = "//input[@class=\"form-control\" and @id=\"year\"]")
    WebElement yearForm_TextField;

    public @FindBy(xpath = "//button[contains(text(),\"Purchase\")]")
    WebElement purchaseForm_Button;

    public @FindBy(xpath = "//div[@class=\"sweet-alert  showSweetAlert visible\"]//h2")
    WebElement confirmationMessage_TextField;

    public @FindBy(xpath = "//button[contains(text(),\"OK\")]")
    WebElement ok_Button;


    public void navigateTo_DemoBlaze_Login_Page() {
        navigateTo_URL(Global_Vars.WEBDRIVER_DEMOBLAZE_URL);
    }

    public void clickOn_Login_Link() {
        waitForWebElementAndClick(login_Link);
    }

    public void setUsername(String username) {
        sendKeys(username_TextField, username);
    }

    public void setPassword(String password) {
        sendKeys(password_TextField, password);
    }

    public void clickOn_Login_Button() {
        waitForWebElementAndClick(login_Button);
    }

    public void validate_Successful_SubmissionMessage_Text(String username) {
        waitFor(successfulSubmission_Message_Text);
        Assert.assertEquals(successfulSubmission_Message_Text.getText(), "Welcome " + username);
    }

    public void clickOn_MenuHome_TextField() {
        waitForWebElementAndClick(menuHome_TextField);
    }

    public void clickOn_MenuCart_TextField() {
        waitForWebElementAndClick(menuCart_TextField);
    }

    public void add_Product1Cart() {
        waitForWebElementAndClick(categoryPhones_TextField);
        waitForWebElementAndClick(add_Product1);
        waitForWebElementAndClick(addCart_Button);
        waitForAlert_And_Accept();
    }

    public void add_Product2Cart() {
        waitForWebElementAndClick(categoryPhones_TextField);
        waitForWebElementAndClick(add_Product2);
        waitForWebElementAndClick(addCart_Button);
        waitForAlert_And_Accept();
    }

    public void clickOn_PlaceOrder_Button() {
        waitForWebElementAndClick(placeOrder_Button);
    }

    public void complete_PurchaseForm(String name, String country, String city, String credit_card, String month, String year) {
        sendKeys(nameForm_TextField, name);
        sendKeys(countryForm_TextField, country);
        sendKeys(cityForm_TextField, city);
        sendKeys(ccForm_TextField, credit_card);
        sendKeys(monthForm_TextField, month);
        sendKeys(yearForm_TextField, year);
    }

    public void clickOn_Purchase_Button() {
        waitForWebElementAndClick(purchaseForm_Button);
    }

    public void confirmationMessage() {
        waitForAlert_And_ValidateMessage(confirmationMessage_TextField);
        waitForWebElementAndClick(ok_Button);
    }
}

