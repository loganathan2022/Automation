package Stepdef.Login;


import BrowserAccess.BrowserControl;
import Functional.BussinessFun;
import Util.GlobalFunction;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.io.IOException;

public class login  {


    String sheetname = "Login";
    int Rowno;
    @Given("^I lanuch the web broser$")
    public void iLanuchTheWebBroser() {
        BrowserControl.getInstance().openBrowser();

    }



    @And("^I need to click \"([^\"]*)\"$")
    public void iNeedToClick(String arg0) throws Throwable {

    }

    @And("^I need to click sign button$")
    public void iNeedToClickSignButton() {
    }

    @And("^I need to verify the sign page$")
    public void iNeedToVerifyTheSignPage() {
    }

    @And("^I need to click \"([^\"]*)\" hyper link$")
    public void iNeedToClickHyperLink(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^click \"([^\"]*)\"$")
    public void click(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^user needs to verify the list of issue from the dropdown$")
    public void userNeedsToVerifyTheListOfIssueFromTheDropdown() {
    }

    @Given("^the 'Admin' launches the application$")
    public void theAdminLaunchesTheApplication() {
        BrowserControl.getInstance().openBrowser();

    }

    @When("^the 'Admin' enters the username and password in the \"([^\"]*)\"$")
    public void theAdminEntersTheUsernameAndPasswordInThe(int  thisRowno) throws Throwable {
        Rowno = thisRowno;

    }

    @And("^the 'Admin' clicks on Log In Button$")
    public void theAdminClicksOnLogInButton() throws IOException {

BussinessFun.getInstance().loginAuthentication(sheetname,Rowno);
    }

    @And("^The 'User' clicks order items$")
    public void theUserClicksOrderItems() {

        BussinessFun.getInstance().validateOerdeItms();
    }

    @And("^'User' Select lastest Order and view details$")
    public void userSelectLastestOrderAndViewDetails() {
    }

    @Then("^'User' Get the information$")
    public void userGetTheInformation() {
    }

    @When("^the 'Admin' enters the username and password$")
    public void theAdminEntersTheUsernameAndPassword() {
    }

    @SuppressWarnings("CucumberJavaStepDefClassIsPublic")
    private static class Global extends GlobalFunction {


    }
}